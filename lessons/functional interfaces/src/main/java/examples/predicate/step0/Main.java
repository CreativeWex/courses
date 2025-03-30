package examples.predicate.step0;

import examples.predicate.step0.service.EtransferTransactionValidator;
import examples.predicate.step0.service.LimitedByAmountTransactionValidator;
import model.Transaction;
import model.TransactionType;

import java.util.List;

/**
 * На вход поступают банковские транзакции.
 * От вида транзакции зависит способ ее обработки.
 * За принадлежность транзакции к определенному виду отвечают фильтры.
 * Фильтр 1: тип транзакции E_TRANSFER, размер не превышает 10 тыс.
 * Фильтр 2: тип транзакции не ATM_VSP_PURCHASE, размер больше 150 тыс.
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
    // фильтр 1
    EtransferTransactionValidator firstValidator = new EtransferTransactionValidator();
    List<Transaction> firstFilterTransactions = firstValidator.filterTransactions(transactions);
    printTransactionList(firstFilterTransactions, "Транзакции для обработки по фильтру 1.");

    // фильтр 2
    LimitedByAmountTransactionValidator secondValidator = new LimitedByAmountTransactionValidator();
    List<Transaction> secondFilterTransactions = secondValidator.filterTransactions(transactions);
    printTransactionList(secondFilterTransactions, "Транзакции для обработки по фильтру 2.");
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
 * Нарушается SRP: валидатор
 * 1. Проверяет транзакцию
 * 2. Создает список транзакций
 * К чему ведет:
 * 1. Дублирование кода, отличающегося 1 строкой
 * 2. Добавление нового фильтра означает еще копипасты в 30+ строк с отличием в одну строк
 */