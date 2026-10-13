# BankAccount Concurrency Project

## 📌 Overview
This project demonstrates **multithreading and concurrency in Java** using a simple banking system.  
It simulates money transfers between multiple accounts to highlight:
- Race conditions (unsynchronized code)
- Thread safety with `synchronized` methods
- Performance trade‑offs when using locks
- Reporting results with `Callable` and `Future`

---

## 🏦 Features
- **BankAccount class**: Holds account number and balance, with `deposit` and `withdraw` methods.
- **TransferTask class**: Represents a transfer operation between two accounts.
- **ExecutorService**: Manages a thread pool to run thousands of transfers concurrently.
- **Race condition demo**: Shows how totals drift when methods aren’t synchronized.
- **Thread safety demo**: Fixes race conditions using `synchronized`.
- **Callable upgrade**: Returns success/failure messages for each transfer.


---

