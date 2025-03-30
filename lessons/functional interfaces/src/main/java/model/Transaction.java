package model;

public class Transaction {
  private TransactionType type;
  private int amount; // int используется для простоты

  public Transaction(TransactionType type, int amount) {
    this.type = type;
    this.amount = amount;
  }

  public TransactionType getType() {
    return type;
  }

  public int getAmount() {
    return amount;
  }

  @Override
  public String toString() {
    return "Transaction{" +
        "type=" + type +
        ", amount=" + amount +
        '}';
  }
}
