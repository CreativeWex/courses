package examples.predicate.step3.service;

import model.Transaction;

@FunctionalInterface
public interface TransactionFilter {
  boolean isTransactionCorrect(Transaction transaction);
}
