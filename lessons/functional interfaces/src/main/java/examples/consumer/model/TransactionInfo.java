package examples.consumer.model;

import java.sql.Timestamp;

public class TransactionInfo {
  private boolean isAmountEvenNumber;
  private double valueRatioFeature;
  private Timestamp timestamp;

  public TransactionInfo(boolean isAmountEvenNumber, double valueRatioFeature, Timestamp timestamp) {
    this.isAmountEvenNumber = isAmountEvenNumber;
    this.valueRatioFeature = valueRatioFeature;
    this.timestamp = timestamp;
  }

  @Override
  public String toString() {
    return "TransactionInfo{" +
        "isAmountEvenNumber=" + isAmountEvenNumber +
        ", valueRatioFeature=" + valueRatioFeature +
        ", timestamp=" + timestamp +
        '}';
  }
}
