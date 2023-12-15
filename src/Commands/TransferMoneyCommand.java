package Commands;

import Controller.WalletController;
import Models.User;
import Models.Wallet;

public class TransferMoneyCommand implements ICommand{

    WalletController walletController;
    String userFrom;
    String userTo;
    double amount;

    public TransferMoneyCommand(WalletController walletController, String userFrom, String userTo, double amount){
        this.walletController = walletController;
        this.userFrom = userFrom;
        this.userTo = userTo;
        this.amount = amount;
    }
    public void execute(){
        walletController.transferMoney(userFrom, userTo, amount);
    }
}
