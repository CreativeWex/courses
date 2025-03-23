package examples.predicate.step0.service;

import model.Transaction;
import model.TransactionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Фильтр 2: тип транзакции не ATM_VSP_PURCHASE, размер больше 150 тыс.
 */
public class LimitedByAmountTransactionValidator {
  public List<Transaction> filterTransactions(List<Transaction> transactions) {
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction transaction : transactions) {
      System.out.println("Проверка транзакции: " + transaction);
      boolean checkResult = !transaction.getType().equals(TransactionType.ATM_VSP_PURCHASE) && transaction.getAmount() > 150_000;
      System.out.println("Результат проверки: " + checkResult);
      if (checkResult) {
        filteredTransactions.add(transaction);
      }
    }
    return filteredTransactions;
  }
}
