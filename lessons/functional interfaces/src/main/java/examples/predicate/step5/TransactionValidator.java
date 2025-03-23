package examples.predicate.step5;

import model.Transaction;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class TransactionValidator {
  public List<Transaction> filterTransactions(List<Transaction> transactions, Predicate<Transaction> predicate) {
    return transactions.stream()
        .peek(tr -> System.out.println("Проверка транзакции: " + tr))
        .filter(tr -> {
          boolean checkResult = predicate.test(tr);
          System.out.println("Результат проверки: " + checkResult);
          return checkResult;
        })
        .collect(Collectors.toList());

//    return transactions.stream()
//        .filter(examples.predicate)
//        .collect(Collectors.toList());
  }
}
