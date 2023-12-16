package Services;

import Enums.OfferName;
import Enums.TransactionType;
import Models.Transaction;
import Models.Wallet;
import Repository.TransactionRepository;
import Repository.WalletRepository;
import Strategy.AddAmountToBothReceipent;
import Strategy.Offer1Strategy;

import java.util.List;

public class WalletService {

    WalletRepository walletRepository;
    TransactionRepository transactionRepository;
    Offer1Strategy offer1Strategy;
    public WalletService(WalletRepository walletRepository, TransactionRepository transactionRepository){
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    // add method to create wallet given user, balance and currency
    public void createWallet(String user, double initialAmount, String currency) {
        Wallet wallet = new Wallet(user, currency, initialAmount);
        walletRepository.addWallet(wallet);
    }

    // add method to add money to wallet given user and amount

    public void addMoneyToWallet(String user, double amount) {
        Wallet wallet = walletRepository.getWallet(user);
        wallet.setBalance(wallet.getBalance() + amount);

    }

    // add method to transfer money from one wallet to another given userFrom, userTo and amount

    public void transferMoney(String userFrom, String userTo, double amount) {
        Wallet fromWallet = walletRepository.getWallet(userFrom);
        Wallet toWallet = walletRepository.getWallet(userTo);
        if(fromWallet.getBalance() < amount){
            System.out.println("Insufficient balance");
            return;
        }
        fromWallet.setBalance(fromWallet.getBalance() - amount);
        toWallet.setBalance(toWallet.getBalance() + amount);
        checkAndApplyOffer1(userFrom, userTo);
    }

    private void checkAndApplyOffer1(String userFrom, String userTo) {
        offer1Strategy = new AddAmountToBothReceipent(userFrom, userTo, 10,walletRepository,transactionRepository);
        offer1Strategy.applyOffer1();
    }

    private void addNewTransaction(String user, String participant, double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction(participant, amount, transactionType);
        transactionRepository.addTransaction(user, transaction);
    }


    public void overview() {
        List<Wallet> walletList = walletRepository.getWallets();
        for(Wallet wallet: walletList){
            System.out.println(wallet.getUser() + " " + wallet.getBalance() + " " + wallet.getCurreny());
        }
    }

    public void getStatement(String user) {
        List<Transaction> userTransactions = transactionRepository.getTransactions(user);
        for(Transaction transaction: userTransactions){
            System.out.println(transaction.getUser() + " " + transaction.getAmount() +  " " + transaction.getTransactionType());
        }

    }

    public void applyOffer2() {
        // suggest code to get three users with highest number of transactions

//        List<Wallet> walletList = walletRepository.getWallets();


    }

    public Wallet getWallet(String userTo) {
        return walletRepository.getWallet(userTo);
    }
}
