package examples.predicate.step3.service;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionValidator {
  public List<Transaction> filterTransactions(List<Transaction> transactions, TransactionFilter filter) {
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction transaction : transactions) {
      System.out.println("Проверка транзакции: " + transaction);
      boolean checkResult = filter.isTransactionCorrect(transaction); // используем фильтр
      System.out.println("Результат проверки: " + checkResult);
      if (checkResult) {
        filteredTransactions.add(transaction);
      }
    }
    return filteredTransactions;
  }
}
