package Repository;

import Models.Transaction;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class TransactionRepository {

    HashMap<String, List<Transaction>> userTransactions = new HashMap<String, List<Transaction>>();
    public void addTransaction(String user, Transaction transaction){
        if(userTransactions.containsKey(user)) {
            userTransactions.get(user).add(transaction);
            return;
        }
        userTransactions.put(user, new ArrayList<>(List.of(transaction)));
    }

    public List<Transaction> getTransactions(String user){
        return userTransactions.get(user);
    }
}
