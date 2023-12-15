package Services;

import Models.Wallet;
import Repository.TransactionRepository;
import Repository.WalletRepository;

public class RewardService {
    WalletRepository walletRepository;
    TransactionRepository transactionRepository;

    public RewardService(WalletRepository walletRepository, TransactionRepository transactionRepository){
        this.walletRepository = walletRepository;
        this.transactionRepository = transactionRepository;
    }

    public void addReward(String user, double amount){
        Wallet userWallet = walletRepository.getWallet(user);
        userWallet.setBalance(userWallet.getBalance() + amount);
    }
}
