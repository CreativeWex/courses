package examples.predicate.step2.service;

import model.Transaction;

@FunctionalInterface
public interface TransactionFilter {
  boolean isTransactionCorrect(Transaction transaction);
}
