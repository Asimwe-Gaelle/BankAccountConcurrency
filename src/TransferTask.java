import java.util.concurrent.Callable;
public class TransferTask  implements Callable<String> {
    private BankAccount source;
    private BankAccount destination;
    private double amount;

    //Constructor
    public TransferTask(BankAccount source, BankAccount destination, double amount) {
        this.source = source;
        this.destination = destination;
        this.amount = amount;
    }
    @Override
    public String call() {
        if (source.withdraw(amount)) {
            destination.deposit(amount);
            return "Transferred " + amount + " from "
                    + source.getAccountNumber() + " to "
                    +destination.getAccountNumber();
        } else {
            return "Transfer failed: insufficient funds in " + source.getAccountNumber();
        }
    }
}
