package examples.predicate.step0.service;

import model.Transaction;
import model.TransactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Фильтр 1: тип транзакции E_TRANSFER, размер не превышает 10 тыс.
 */
public class EtransferTransactionValidator {
  public List<Transaction> filterTransactions(List<Transaction> transactions) {
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction transaction : transactions) {
      System.out.println("Проверка транзакции: " + transaction);
      boolean checkResult = transaction.getType().equals(TransactionType.E_TRANSFER) && transaction.getAmount() <= 10_000;
      System.out.println("Результат проверки: " + checkResult);
      if (checkResult) {
        filteredTransactions.add(transaction);
      }
    }
    return filteredTransactions;
  }
}
