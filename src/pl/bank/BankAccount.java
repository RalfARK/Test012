package pl.bank;

public class BankAccount implements Account {

    private String nr;
    private int balance;

    public BankAccount(String nr, int balance) {
        this.nr = nr;
        this.balance = balance;
    }

    public String getNr() {
        return nr;
    }

    public int getBalance() {
        return balance;
    }

    @Override
    public void deposit(int amount) {
        if (amount > 0) {
            this.balance += amount;
        }
        else throw new IllegalArgumentException("Wartość musi byc większa od 0");
    }

    @Override
    public void withdraw(int amount) {
        if (balance < amount) {
            throw new IllegalArgumentException("Brak środków na koncie");
        }
        else balance -= amount;
    }




}
