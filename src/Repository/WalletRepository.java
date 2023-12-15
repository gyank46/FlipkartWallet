package Repository;

import Models.Wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class WalletRepository {
    HashMap<String, Wallet> wallets = new HashMap<String, Wallet>();

    public void addWallet(Wallet wallet){
        wallets.put(wallet.getUser(), wallet);
    }

    public Wallet getWallet(String name){
        return wallets.get(name);
    }

    public void updateWallet(Wallet wallet){
        wallets.put(wallet.getUser(), wallet);
    }

    public void deleteWallet(Wallet wallet){
        wallets.remove(wallet.getUser());
    }


    public List<Wallet> getWallets() {
        return new ArrayList<Wallet>(wallets.values());
    }
}
