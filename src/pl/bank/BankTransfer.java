package pl.bank;

public interface BankTransfer {
    void transfer(BankAccount from, BankAccount to, int amount);
}
