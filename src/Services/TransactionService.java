package Services;

import Enums.TransactionType;
import Models.Transaction;
import Repository.TransactionRepository;

import java.util.List;

public class TransactionService {

    TransactionRepository transactionRepository;

    public TransactionService(TransactionRepository transactionRepository){
        this.transactionRepository = transactionRepository;
    }

    public void addTransactions(String userTo, String userFrom, double amount){
        addNewTransaction(userFrom, userTo, amount, TransactionType.DEBIT);
        addNewTransaction(userTo, userFrom, amount, TransactionType.CREDIT);
    }

    public void addNewTransaction(String user, String participant, double amount, Enums.TransactionType transactionType){
        Transaction transaction = new Transaction(participant, amount, transactionType);
        transactionRepository.addTransaction(user, transaction);
    }

    public void getTransactions(String user){
        List<Transaction> userTransactions = transactionRepository.getTransactions(user);
        for(Transaction transaction: userTransactions){
            System.out.println(transaction.getUser() + " " + transaction.getAmount() +  " " + transaction.getTransactionType());
        }
    }





}
