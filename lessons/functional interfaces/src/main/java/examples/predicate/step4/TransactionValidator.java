package examples.predicate.step4;

import model.Transaction;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class TransactionValidator {
  public List<Transaction> filterTransactions(List<Transaction> transactions, Predicate<Transaction> predicate) {
    List<Transaction> filteredTransactions = new ArrayList<>();
    for (Transaction transaction : transactions) {
      System.out.println("Проверка транзакции: " + transaction);
      boolean checkResult = predicate.test(transaction); // используем фильтр
      System.out.println("Результат проверки: " + checkResult);
      if (checkResult) {
        filteredTransactions.add(transaction);
      }
    }
    return filteredTransactions;
  }
}
