// 2019.12.19
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
    	System.out.println(" : " + Bank.amount);
    }
}
