package examples.consumer;

import examples.consumer.service.TransactionHandler;
import examples.consumer.service.sender.DatabaseTransactionInfoSender;
import examples.consumer.service.sender.KafkaTransactionInfoSender;
import examples.consumer.service.sender.TransactionInfoSender;
import model.Transaction;
import model.TransactionType;

import java.util.List;

/**
 * Обработчик банковских транзакций, прошедших фильтр
 * 1. Для каждой транзакции необходимо собрать статистику {@link examples.consumer.model.TransactionInfo}
 * 2. Статистику нужно отправить в один из каналов в зависимости от пройденного фильтра
 */
public class Main {
  public static void main(String[] args) {
    TransactionHandler handler = new TransactionHandler();

    List<Transaction> transactionsForDbWriting = getTransactionsForDbWriting();
    TransactionInfoSender dbSender = new DatabaseTransactionInfoSender();
    handler.handle(transactionsForDbWriting, dbSender);

    List<Transaction> transactionsForKafkaWriting = getTransactionsForKafkaSending();
    TransactionInfoSender kafkaSender = new KafkaTransactionInfoSender();
    handler.handle(transactionsForKafkaWriting, kafkaSender);
  }

  private static List<Transaction> getTransactionsForDbWriting() {
    return List.of(
        new Transaction(TransactionType.E_TRANSFER, 5_000),
        new Transaction(TransactionType.CARD_PAYMENT, 3_000)
    );
  }

  private static List<Transaction> getTransactionsForKafkaSending() {
    return List.of(
        new Transaction(TransactionType.E_TRANSFER, 5_000),
        new Transaction(TransactionType.ATM_VSP_PURCHASE, 25_500),
        new Transaction(TransactionType.E_TRANSFER, 210_000)
    );
  }
}
