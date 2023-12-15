package Commands;

import Controller.WalletController;

public class CreateWalletCommand implements ICommand{
    WalletController walletController;
    String user;
    double initialAmount;
    String currency;

    public CreateWalletCommand(WalletController walletController, String user, double initialAmount, String currency){
        this.walletController = walletController;
        this.user = user;
        this.initialAmount = initialAmount;
        this.currency = currency;
    }

    public void execute(){
        walletController.createWallet(user, initialAmount, currency);
    }
}
