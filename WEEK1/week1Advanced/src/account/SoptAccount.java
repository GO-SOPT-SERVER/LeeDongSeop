package account;

public class SoptAccount extends Account {

//    상속받은 필드 (default 접근지정자로, 같은 패키지 내에 있으므로 사용 가능)
//    Long accountNumber;
//    String accountOwner;
//    Long leftMoney;

    public SoptAccount(Long accountNumber, String accountOwner) {
        super(accountNumber, accountOwner);
        celebration();
    }

    @Override
    public void deposit(Long inputMoney) {
        leftMoney += inputMoney;
    }

    @Override
    public void withdraw(Long outputMoney) {
        if (leftMoney >= outputMoney) {
            leftMoney -= outputMoney;
        } else {
            System.out.println("[Error] 잔액 부족으로 인해 출금에 실패하였습니다.");
        }
    }

    @Override
    public Long getLeftMoney() {
        return leftMoney;
    }

    public Long getAccountNumber() {
        return accountNumber;
    }

    public void celebration() {
        System.out.println("[Welcome] " + accountOwner + "님, SOPT 계좌에 가입하신 것을 축하드립니다~~!!");
    }
}
