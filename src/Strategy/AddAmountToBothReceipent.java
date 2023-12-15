package Strategy;

import Enums.OfferName;
import Enums.TransactionType;
import Models.Transaction;
import Models.Wallet;
import Repository.TransactionRepository;
import Repository.WalletRepository;
import Services.RewardService;
import Services.WalletService;

public class AddAmountToBothReceipent implements Offer1Strategy{

    String userFrom;
    String userTo;
    double amount;
    WalletRepository walletRepository;
    TransactionRepository transactionRepository;


    public AddAmountToBothReceipent(String userFrom, String userTo, double amount, WalletRepository walletRepository, TransactionRepository transactionRepository){
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    @Override
    public void applyOffer1() {
        Wallet toWallet = walletRepository.getWallet(userTo);
        Wallet fromWallet = walletRepository.getWallet(userFrom);
        double diff = Math.abs(toWallet.getBalance() -fromWallet.getBalance());
        if(diff<0.00000001) {

            fromWallet.setBalance(fromWallet.getBalance() + amount);
            toWallet.setBalance(toWallet.getBalance() + amount);
            addNewTransaction(userTo, OfferName.Offer1.toString(), amount, TransactionType.CREDIT);
            addNewTransaction(userFrom, OfferName.Offer1.toString(), amount, TransactionType.CREDIT);
        }
    }

    private void addNewTransaction(String user, String participant, double amount, TransactionType transactionType) {
        Transaction transaction = new Transaction(participant, amount, transactionType);
        transactionRepository.addTransaction(user, transaction);
    }
}
