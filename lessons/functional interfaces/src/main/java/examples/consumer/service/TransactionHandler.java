package examples.consumer.service;

import examples.consumer.model.TransactionInfo;
import model.Transaction;

import java.sql.Timestamp;
import java.util.List;
import java.util.function.Consumer;

public class TransactionHandler {
  public void handle(List<Transaction> transactions, Consumer<TransactionInfo> resultSender) {
    System.out.println("=========Началась обработка транзакций===========");
    transactions.stream()
        .map(this::getTransactionStatistics)
        .forEach(resultSender);
  }

  private TransactionInfo getTransactionStatistics(Transaction transaction) {
    return new TransactionInfo(
        transaction.getAmount() % 2 == 0,
        (double) transaction.getType().toString().length() / transaction.getAmount(),
        new Timestamp(System.currentTimeMillis())
    );
  }
}
