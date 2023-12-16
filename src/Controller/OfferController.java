package Controller;

import Services.OfferService;

public class OfferController {
    OfferService offerService;
    public OfferController(OfferService offerService){
        this.offerService = offerService;
    }
    public void applyOffer1(String userFrom, String userTo){
        offerService.applyOffer1(userFrom,userTo);
    }

    public void applyOffer2(){
        offerService.applyOffer2();
    }

}
