import Commands.*;
import Controller.OfferController;
import Controller.TransactionController;
import Controller.WalletController;
import Repository.TransactionRepository;
import Repository.WalletRepository;
import Services.OfferService;
import Services.TransactionService;
import Services.WalletService;

public class Main {
    public static void main(String[] args) {

        TransactionRepository transactionRepository = new TransactionRepository();
        WalletRepository walletRepository = new WalletRepository();
        WalletService walletService = new WalletService(walletRepository, transactionRepository);
        TransactionService transactionService = new TransactionService(transactionRepository);
        OfferService offerService = new OfferService(walletRepository, transactionRepository);
        WalletController walletController = new WalletController(walletService);
        TransactionController transactionController = new TransactionController(transactionService);
        OfferController offerController = new OfferController(offerService);

        ICommand command  = new CreateWalletCommand(walletController, "Harry", 100, "INR");
        command.execute();
        command  = new CreateWalletCommand(walletController, "Ron", 95.7, "INR");
        command.execute();
        command  = new CreateWalletCommand(walletController, "Hermione", 104, "INR");
        command.execute();
        command  = new CreateWalletCommand(walletController, "Albus", 200, "INR");
        command.execute();
        command  = new CreateWalletCommand(walletController, "Draco", 500, "INR");
        command.execute();


        command = new OverviewCommand(walletController);
        command.execute();

        command = new TransferMoneyCommand(walletController, transactionController,offerController, "Albus", "Draco", 30);
        command.execute();
        command = new TransferMoneyCommand(walletController, transactionController,offerController, "Hermione", "Harry", 2);
        command.execute();
        command = new TransferMoneyCommand(walletController, transactionController,offerController,"Albus", "Ron", 5);
        command.execute();


        command = new OverviewCommand(walletController);
        command.execute();

        command = new StatementCommand(transactionController, "Harry");
        command.execute();
        command = new StatementCommand(transactionController, "Albus");
        command.execute();


    }
}