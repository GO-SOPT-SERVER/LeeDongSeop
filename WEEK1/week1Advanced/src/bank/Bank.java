package bank;

public interface Bank {

    public abstract void createAccount(Long accountNumber, String accountOwner);

    public abstract void checkLeftMoney(Long accountNumber);

    public abstract void deposit(Long accountNumber, Long inputMoney);

    public abstract void withdraw(Long accountNumber, Long outputMoney);

    public abstract void finish();

}
