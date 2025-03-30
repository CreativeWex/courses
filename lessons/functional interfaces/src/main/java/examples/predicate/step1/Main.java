package examples.predicate.step1;

import examples.predicate.step1.service.TransactionValidator;
import examples.predicate.step1.service.filter.EtransferTransactionFilter;
import examples.predicate.step1.service.filter.LimitedByAmountTransactionFilter;
import examples.predicate.step1.service.filter.TransactionFilter;
import model.Transaction;
import model.TransactionType;

import java.util.List;

/**
 * Добавление функциональных интерфейсов
 */
public class Main {
  // подыгрываем считывание транзакций из смежного сервиса
  private static List<Transaction> transactions = List.of(
      new Transaction(TransactionType.E_TRANSFER, 5_000),
      new Transaction(TransactionType.E_TRANSFER, 15_000),
      new Transaction(TransactionType.ATM_VSP_PURCHASE, 25_500),
      new Transaction(TransactionType.CARD_PAYMENT, 178_000),
      new Transaction(TransactionType.E_TRANSFER, 210_000),
      new Transaction(TransactionType.E_TRANSFER, 560_000),
      new Transaction(TransactionType.CARD_PAYMENT, 3_000)
  );

  public static void main(String[] args) {
    TransactionValidator validator = new TransactionValidator();

    // фильтр 1
    TransactionFilter firstFilter = new EtransferTransactionFilter();
    List<Transaction> firstFiltertransactions = validator.filterTransactions(transactions, firstFilter);
    printTransactionList(firstFiltertransactions, "Транзакции для обработки по фильтру 1.");

    // фильтр 2
    TransactionFilter secondFilter = new LimitedByAmountTransactionFilter();
    List<Transaction> secondFiltertransactions = validator.filterTransactions(transactions, secondFilter);
    printTransactionList(secondFiltertransactions, "Транзакции для обработки по фильтру 2.");
  }

  private static void printTransactionList(List<Transaction> transactions, String message) {
    System.out.println("=========================");
    System.out.println(message + " Транзакции из списка: ");
    for (Transaction transaction : transactions) {
      System.out.println("\t" + transaction);
    }
    System.out.println("=========================");
  }
}

/**
 * Добавление нового фильтра не влечет изменения в валидаторе
 */