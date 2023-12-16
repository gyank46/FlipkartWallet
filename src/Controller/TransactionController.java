package Controller;

import Services.TransactionService;

public class TransactionController {

    TransactionService transactionService;

    public TransactionController(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    public void addTransactions(String userTo, String userFrom, double amount){
        transactionService.addTransactions(userTo, userFrom, amount);
    }

    public void getTransactions(String user){
        transactionService.getTransactions(user);
    }
}
