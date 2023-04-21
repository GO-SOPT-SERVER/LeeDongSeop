package account;

public abstract class Account {

    Long accountNumber; // 10자리 계좌번호이므로 long 사용
    String accountOwner; // 계좌 주인
    Long leftMoney; // 계좌 잔액

    public Account(Long accountNumber, String accountOwner) {
        this.accountNumber = accountNumber;
        this.accountOwner = accountOwner;
        this.leftMoney = 0L;
    }

    public abstract void deposit(Long inputMoney);

    public abstract void withdraw(Long outputMoney);

    public abstract Long getLeftMoney();

}
