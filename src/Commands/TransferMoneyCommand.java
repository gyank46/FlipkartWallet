package Commands;

import Controller.OfferController;
import Controller.TransactionController;
import Controller.WalletController;
import Models.User;
import Models.Wallet;

public class TransferMoneyCommand implements ICommand{

    WalletController walletController;
    TransactionController transactionController;
    OfferController offerController;
    String userFrom;
    String userTo;
    double amount;

    public TransferMoneyCommand(WalletController walletController, TransactionController transactionController, OfferController offerController, String userFrom, String userTo, double amount){
        this.walletController = walletController;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
        this.transactionController = transactionController;
        this.offerController = offerController;
    }
    public void execute(){
        walletController.transferMoney(userFrom, userTo, amount);
        transactionController.addTransactions(userTo, userFrom, amount);
        offerController.applyOffer1(userFrom,userTo);
    }
}
