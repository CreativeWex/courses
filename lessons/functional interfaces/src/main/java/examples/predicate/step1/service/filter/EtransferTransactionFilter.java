package examples.predicate.step1.service.filter;

import model.Transaction;
import model.TransactionType;

/**
 * Фильтр 1: тип транзакции E_TRANSFER, размер не превышает 10 тыс.
 */
public class EtransferTransactionFilter implements TransactionFilter {
  @Override
  public boolean isTransactionCorrect(Transaction transaction) {
    return transaction.getType().equals(TransactionType.E_TRANSFER) && transaction.getAmount() <= 10_000;
  }
}
