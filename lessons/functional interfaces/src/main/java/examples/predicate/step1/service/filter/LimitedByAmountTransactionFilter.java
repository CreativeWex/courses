package examples.predicate.step1.service.filter;

import model.Transaction;
import model.TransactionType;

/**
 * Фильтр 2: тип транзакции не ATM_VSP_PURCHASE, размер больше 150 тыс.
 */
public class LimitedByAmountTransactionFilter implements TransactionFilter {
  @Override
  public boolean isTransactionCorrect(Transaction transaction) {
    return !transaction.getType().equals(TransactionType.ATM_VSP_PURCHASE) && transaction.getAmount() > 150_000;
  }
}
