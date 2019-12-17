package e_class;

public class Account {
    void deposit(int amt) { // 입금
    	Bank.amount += amt;
    	prn();
    }
    void withdraw(int amt) { // 출금
    	Bank.amount -= amt;
    	prn();
    }
    void prn() {
    	System.out.println("잔액 : " + Bank.amount);
    }
}
