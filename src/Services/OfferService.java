package Services;

import Models.Wallet;
import Repository.TransactionRepository;
import Repository.WalletRepository;
import Strategy.AddAmountToBothReceipent;
import Strategy.Offer1Strategy;
import Strategy.Offer2Strategy;

public class OfferService {
    Offer1Strategy offer1Strategy;
    Offer2Strategy offer2Strategy;
    WalletRepository walletRepository;
    TransactionRepository transactionRepository;


    public OfferService(WalletRepository walletRepository, TransactionRepository transactionRepository){
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    public void applyOffer1(String userFrom, String userTo){
        offer1Strategy = new AddAmountToBothReceipent(userFrom, userTo, 10, walletRepository, transactionRepository);
        offer1Strategy.applyOffer1();
    }

    public void applyOffer2(){
        offer2Strategy.applyOffer2();
    }

}
