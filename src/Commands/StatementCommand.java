package Commands;

import Controller.TransactionController;
import Controller.WalletController;

public class StatementCommand implements ICommand{

    TransactionController transactionController;
    String user;

    public StatementCommand(TransactionController transactionController, String user){
        this.transactionController = transactionController;
        this.user = user;
    }


    @Override
    public void execute() {
        transactionController.getTransactions(user);
    }
}
