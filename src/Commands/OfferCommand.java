package Commands;

import Controller.OfferController;
import Controller.WalletController;

public class OfferCommand {
    OfferController offerController;

    public OfferCommand(OfferController offerController){
        this.offerController = offerController;
    }

    public void execute() {
        offerController.applyOffer2();
    }


}
