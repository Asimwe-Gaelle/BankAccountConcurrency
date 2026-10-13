import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;

public class Main {
    public static void main(String[] args) throws InterruptedException {
        //step 1: create a List of array of 10BankAccount objects
        List<BankAccount> accounts = new ArrayList<>();
        for (int i = 0; i < 10; i++) {
            accounts.add(new BankAccount("ACC" + i, 10000));
        }
        //step 2: create a thread pool
        ExecutorService pool = Executors.newFixedThreadPool(10);
        Random random = new Random();

        List<Future<String>> results = new ArrayList<>();

        Long startTime = System.currentTimeMillis();

        //step 3: submit 100,000 tansfer tasks
        for (int i = 0; i < 100000; i++) {
            int srcIndex = random.nextInt(10);
            int destIndex;
            do {
                destIndex = random.nextInt(10);
            } while (destIndex == srcIndex);
            double amount = random.nextInt(1000);
            TransferTask task = new TransferTask(accounts.get(srcIndex), accounts.get(destIndex), amount);
            results.add(pool.submit(task));
        }

        //step 4: Shutdown and wait
        pool.shutdown();
        while (!pool.isTerminated()) {
            pool.awaitTermination(1, TimeUnit.MINUTES);
        }

        Long endTime = System.currentTimeMillis();

        //Print results

        for (Future<String> f : results) {
            try {
                System.out.println(f.get());
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        //step 5: Sum up the balances
        double total = 0;
        for (BankAccount acc : accounts) {
            total = total + acc.getBalance();
            System.out.println(acc.getAccountNumber() + " balance: " + acc.getBalance());
        }
        System.out.println("Total balance: " + total);
        System.out.println("Execution time: " + (endTime - startTime) + " ms");
    }
}