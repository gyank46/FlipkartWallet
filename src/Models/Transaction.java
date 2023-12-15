package Models;

import Enums.TransactionType;

public class Transaction {
    String participantName;
    TransactionType transactionType;
    double amount;

    public Transaction(String participantName, double amount, TransactionType transactiontype) {
        this.participantName = participantName;
        this.amount = amount;
        this.transactionType = transactiontype;
    }

    public String getUser() {
        return participantName;
    }

    public double getAmount() {
        return amount;
    }

    public TransactionType getTransactionType() {
        return transactionType;
    }
}
