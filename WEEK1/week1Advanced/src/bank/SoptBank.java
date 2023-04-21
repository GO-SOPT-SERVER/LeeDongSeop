package bank;

import account.SoptAccount;

import java.util.ArrayList;

public class SoptBank implements Bank{

    public static ArrayList<SoptAccount> accountList = new ArrayList<>();

    @Override
    public void createAccount(Long accountNumber, String accountOwner) {
        SoptAccount newAccount = new SoptAccount(accountNumber, accountOwner);
        accountList.add(newAccount);
        System.out.println("[System] 계좌번호:" + accountNumber + ", 계좌주인:" + accountOwner + " 의 SOPT 은행 계좌가 생성되었습니다.");
    }

    @Override
    public void checkLeftMoney(Long accountNumber) {
        SoptAccount findAccount = null;
        for (SoptAccount curAccount : accountList) {
            if (curAccount.getAccountNumber().equals(accountNumber)) {
                findAccount = curAccount;
            }
        }
        if (findAccount == null) {
            System.out.println("[Error] 요청하신 계좌번호는 유효하지 않습니다.");
        } else {
            System.out.println("[System] 게좌번호 " + accountNumber + "의 잔액은 " + findAccount.getLeftMoney() + "입니다.");
        }
    }

    @Override
    public void deposit(Long accountNumber, Long inputMoney) {
        SoptAccount findAccount = null;
        for (SoptAccount curAccount : accountList) {
            if (curAccount.getAccountNumber().equals(accountNumber)) {
                findAccount = curAccount;
            }
        }
        if (findAccount == null) {
            System.out.println("[Error] 요청하신 계좌번호는 유효하지 않습니다.");
        } else {
            findAccount.deposit(inputMoney);
            System.out.println("[System] 게좌번호 " + accountNumber + "의 입금 후 잔액은 " + findAccount.getLeftMoney() + "입니다.");
        }
    }

    @Override
    public void withdraw(Long accountNumber, Long outputMoney) {
        SoptAccount findAccount = null;
        for (SoptAccount curAccount : accountList) {
            if (curAccount.getAccountNumber().equals(accountNumber)) {
                findAccount = curAccount;
            }
        }
        if (findAccount == null) {
            System.out.println("[Error] 요청하신 계좌번호는 유효하지 않습니다.");
        } else {
            findAccount.withdraw(outputMoney);
            System.out.println("[System] 게좌번호 " + accountNumber + "의 출금 후 잔액은 " + findAccount.getLeftMoney() + "입니다.");
        }
    }

    @Override
    public void finish() {
        System.out.println("[Goodbye] SOPT 은행을 종료합니다.");
    }


}
