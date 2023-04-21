import bank.SoptBank;

import java.util.Scanner;

public class week1Advanced {

    public static void main(String[] args) {
        SoptBankService soptBankService = new SoptBankService(new SoptBank(), new Scanner(System.in));
        soptBankService.run();
    }
}
