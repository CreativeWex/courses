package examples.consumer.service.sender;

import examples.consumer.model.TransactionInfo;

public class DatabaseTransactionInfoSender implements TransactionInfoSender {
  @Override
  public void accept(TransactionInfo transactionInfo) {
    System.out.println("Начинается сохранение транзакции в БД");
    System.out.println("INSERT INTO DATABASE, бла бла бла");
    System.out.println("Сохранена транзакция: " + transactionInfo);
  }
}
