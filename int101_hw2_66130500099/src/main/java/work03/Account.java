package work03;

import java.util.Objects;
import work02.Person;
import work01.Utilitor;

public class Account {
    private static long nextNo = 1_000_000_000;
    private final long no;
    private Person owner;
    private double balance;
    public Account (Person owner){
        if (owner == null){
            throw new NullPointerException("owner is null");
        }
        this.owner = owner;
        var result = Utilitor.computeIsbn10(nextNo);
        while (result == 10){
            nextNo +=1;
            result = Utilitor.computeIsbn10(nextNo);
        }
        this.no = 10 * nextNo + result;
        nextNo += 1;
        this.balance = 0.0;
    }

    public long getNo() {
        return no;
    }

    public Person getOwner() {
        return owner;
    }

    public double getBalance() {
        return balance;
    }

    public double deposit(double amount){
        if(Utilitor.testPositive(amount) < 0){
            throw new IllegalArgumentException("amount is not positive");
        } balance += amount;

        return balance;
    }
    public double withdraw(double amount){
        if(Utilitor.testPositive(amount) < 0){
            throw new IllegalArgumentException("amount is not positive");
        } balance -= amount;
        if (Utilitor.testPositive(balance) < 0){
            throw new IllegalArgumentException("balance not enough for withdraw");
        }return balance;
    }
    public void transfer(double amount, Account account){
        if(account == null || Utilitor.testPositive(balance) < 0){
            throw new IllegalArgumentException("account is null");
        }   withdraw(amount);
            account.deposit(amount);
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Account{");
        sb.append("no=").append(no);
        sb.append(", owner=").append(owner);
        sb.append(", balance=").append(balance);
        sb.append('}');
        return sb.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Account account)) return false;
        return getNo() == account.getNo() && Double.compare(getBalance(), account.getBalance()) == 0 
                && Objects.equals(getOwner(), account.getOwner());
    }

    @Override
    public int hashCode() {
        return 0;
    }
}
