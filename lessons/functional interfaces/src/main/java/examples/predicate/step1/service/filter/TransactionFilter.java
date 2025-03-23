package examples.predicate.step1.service.filter;

import model.Transaction;

@FunctionalInterface
public interface TransactionFilter {
  boolean isTransactionCorrect(Transaction transaction);
}
