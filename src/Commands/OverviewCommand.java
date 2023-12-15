package Commands;

import Controller.WalletController;

public class OverviewCommand implements ICommand{
    WalletController walletController;

    public OverviewCommand(WalletController walletController){
        this.walletController = walletController;
    }
    @Override
    public void execute() {
        walletController.overview();
    }
}
