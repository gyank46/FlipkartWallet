package Models;

import java.util.Date;

public class Wallet {
    String user;
    String curreny;
    double balance;

    Date createdAt;

    public Wallet(String user, String currency, double initialAmount) {
        this.balance   = initialAmount;
        this.user = user;
        this.curreny = currency;
        this.createdAt = new Date();
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getCurreny() {
        return curreny;
    }

    public void setCurreny(String curreny) {
        this.curreny = curreny;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }


}
