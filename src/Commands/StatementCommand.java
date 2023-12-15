package Commands;

import Controller.WalletController;

public class StatementCommand implements ICommand{

    WalletController walletController;
    String user;

    public StatementCommand(WalletController walletController, String user){
        this.walletController = walletController;
        this.user = user;
    }


    @Override
    public void execute() {
        walletController.getStatement(user);
    }
}
