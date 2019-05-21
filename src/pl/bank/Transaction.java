package pl.bank;

public class Transaction implements BankTransfer{
    private static final int CHARGE = 1;
    private int nrTrans;

    public Transaction(int nrTrans) {
        this.nrTrans = nrTrans;
    }

    public int getNrTrans() {
        return nrTrans;
    }

    public void setNrTrans(int nrTrans) {
        this.nrTrans = nrTrans;
    }

    @Override
    public void transfer(BankAccount from, BankAccount to, int amount) {
        from.withdraw(amount+CHARGE);
        to.deposit(amount);
        this.nrTrans += 1;
        System.out.println("Transakcja nr: " + nrTrans + " z konta: "+ from.getNr() + " na konto: " + to.getNr() + " kwota plus opłata: " + (amount+CHARGE));
    }

    public static void main(String[] args) {
        BankAccount b1 = new BankAccount("12 1010 0000 0001", 10000);
        BankAccount b2 = new BankAccount("12 1020 0000 0002", 20000);
        BankAccount b3 = new BankAccount("12 1030 0000 0003", 30000);
        BankAccount b4 = new BankAccount("12 1040 0000 0004", 40000);

        Transaction t1 = new Transaction(0);
        t1.transfer(b1, b2, 6996);
        t1.transfer(b3, b4, 1000);
        t1.transfer(b1, b4, 1000);
        t1.transfer(b1, b3, 1000);
        t1.transfer(b1, b2, 1000);

        System.out.println("Konto b1, nr: " + b1.getNr() + " balance: " + b1.getBalance());
        System.out.println("Konto b2, nr: " + b2.getNr() + " balance: " + b2.getBalance());
        System.out.println("Konto b3, nr: " + b3.getNr() + " balance: " + b3.getBalance());
        System.out.println("Konto b4, nr: " + b4.getNr() + " balance: " + b4.getBalance());

    }
}
