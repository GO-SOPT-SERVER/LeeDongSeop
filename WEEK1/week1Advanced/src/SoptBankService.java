import bank.SoptBank;

import java.util.Scanner;

public class SoptBankService {

    private SoptBank soptBank;
    private Scanner scanner;

    public SoptBankService(SoptBank soptBank, Scanner scanner) {
        this.soptBank = soptBank;
        this.scanner = scanner;
    }

    public void run() {
        boolean finish = false;
        while (!finish) {
            System.out.println("=====SOPT BANK PROGRAM=====");
            System.out.println("1. 신규 계좌 생성");
            System.out.println("2. 계좌 잔액 조회");
            System.out.println("3. 입금");
            System.out.println("4. 출금");
            System.out.println("5. 종료");
            System.out.print(">> ");

            String command = scanner.nextLine();
            switch (command) {
                case "1":
                    createAccount();
                    break;
                case "2":
                    checkLeftMoney();
                    break;
                case "3":
                    deposit();
                    break;
                case "4":
                    withdraw();
                    break;
                case "5":
                    finish();
                    finish = true;
                    break;
                default:
                    System.out.println("[Error] 유효하지 않은 요청번호입니다.");
                    break;
            }
            System.out.println();
        }
        scanner.close();
    }

    private void createAccount() {
        System.out.print("계좌번호: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();
        System.out.print("가입자명: ");
        String accountOwner = scanner.nextLine();
        soptBank.createAccount(accountNumber, accountOwner);
    }

    private void checkLeftMoney() {
        System.out.print("계좌번호: ");
        Long accountNumber = scanner.nextLong();
        scanner.nextLine();
        soptBank.checkLeftMoney(accountNumber);
    }

    private void deposit() {
        System.out.print("계좌번호: ");
        Long accountNumber = scanner.nextLong();
        System.out.print("입금액: ");
        Long inputMoney = scanner.nextLong();
        scanner.nextLine();
        soptBank.deposit(accountNumber, inputMoney);
    }

    private void withdraw() {
        System.out.print("계좌번호: ");
        Long accountNumber = scanner.nextLong();
        System.out.print("출금액: ");
        Long outputMoney = scanner.nextLong();
        scanner.nextLine();
        soptBank.withdraw(accountNumber, outputMoney);
    }

    private void finish() {
        soptBank.finish();
    }
}
