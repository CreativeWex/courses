package examples.predicate.step2;

import examples.predicate.step2.service.TransactionFilter;
import examples.predicate.step2.service.TransactionValidator;
import model.Transaction;
import model.TransactionType;

import java.util.List;

/**
 * Анонимные методы
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
    TransactionFilter firstFilter = new TransactionFilter() {
      @Override
      public boolean isTransactionCorrect(Transaction transaction) {
        return transaction.getType().equals(TransactionType.E_TRANSFER) && transaction.getAmount() <= 10_000;
      }
    };
    List<Transaction> firstFiltertransactions = validator.filterTransactions(transactions, firstFilter);
    printTransactionList(firstFiltertransactions, "Транзакции для обработки по фильтру 1.");

    // фильтр 2
    TransactionFilter secondFilter = new TransactionFilter() {
      @Override
      public boolean isTransactionCorrect(Transaction transaction) {
        return !transaction.getType().equals(TransactionType.ATM_VSP_PURCHASE) && transaction.getAmount() > 150_000;
      }
    };
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