package examples.consumer.service.sender;

import examples.consumer.model.TransactionInfo;

public class KafkaTransactionInfoSender implements TransactionInfoSender {
  @Override
  public void accept(TransactionInfo transactionInfo) {
    System.out.println("Начинается отправка транзакции в Kafka");
    System.out.println("Отправлена транзакция: " + transactionInfo);
  }
}
