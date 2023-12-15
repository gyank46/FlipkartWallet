package Controller;

import Models.User;
import Services.WalletService;

public class WalletController {
    WalletService walletService;
    public WalletController(WalletService walletService){
        this.walletService = walletService;
    }
    public void createWallet(String user, double initialAmount, String currency) {
        walletService.createWallet(user, initialAmount, currency);
    }

    public void addMoneyToWallet(String user, double amount) {
        walletService.addMoneyToWallet(user, amount);
    }
    public void transferMoney(String userFrom, String userTo, double amount) {
        walletService.transferMoney(userFrom, userTo, amount);
    }

    public void overview() {
        walletService.overview();
    }

    public void getStatement(String user) {
        walletService.getStatement(user);
    }

    public void applyOffer2() {
        walletService.applyOffer2();
    }
}
