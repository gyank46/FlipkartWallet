package Commands;

import Controller.WalletController;

public class OfferCommand {
    WalletController walletController;

    public OfferCommand(WalletController walletController){
        this.walletController = walletController;
    }

    public void execute() {
        walletController.applyOffer2();
    }


}
