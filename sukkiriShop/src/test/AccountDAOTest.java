package test;

import dao.AccountDAO;
import model.Account;
import model.Login;

public class AccountDAOTest {

	public static void main(String[] args) {
		testFindByLogin1();
		testFindByLogin2();
	}

	public static void testFindByLogin1() {
		Login login = new Login("minato", "1234");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result != null) {
			System.out.println("あった");
		}
		if(result.getUserId().equals("minato    +")) {
		} else {
			System.out.println("id違う");
		}
		if(result.getPass().equals("1234")) {
		} else {
			System.out.println("pass違う");
		}
		if(result.getMail().equals("minato@sukkiri.com")) {
		} else {
			System.out.println("mail違う");
		}
		if(result.getName().equals("湊 祐輔")) {
		} else {
			System.out.println("name");
		}
		if(result.getAge() == 23) {
		} else {
			System.out.println("age違う");
		}
	}

	public static void testFindByLogin2() {
		Login login = new Login("minato", "12345");
		AccountDAO dao = new AccountDAO();
		Account result = dao.findByLogin(login);
		if (result == null) {
			System.out.print("testFindByLogin2:成功しました");
		} else {
			System.out.print("testFindByLogin2:失敗しました");
		}
	}
}
