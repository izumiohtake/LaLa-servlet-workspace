package dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import model.Employee;

public class EmployeeDAO {
	private final String JDBC_URL = "jdbc:h2:tcp://localhost/~/example";
	private final String DB_USER= "sa";
	private final String DB_PASS = "";
	
	/**
	 * findAll()は全従業員のリストを返すしてくれるメソッド
	 * <Employee>
	 * String id
	 * String name
	 * ｉｎｔ age
	 * ＜使い方＞
	 * EmployeeDAO dao = new EmployeeDAO();
	 * List<Employee> empList = dao.findAll();
	 *＠param引数なし 
	 * @return　List<Employee>
	 * @author ohtake
	 */
	public List<Employee> findAll(){
		List<Employee> empList = new ArrayList<>();
		
//		return empList;
	
	
	 try (Connection conn = DriverManager.getConnection(
			 JDBC_URL, DB_USER, DB_PASS)) {
	// select文を準備
				String sql = "SELECT id,name,age FROM employee";
				//preparedStatementはクラスconnはインスタンス
				PreparedStatement pStmt = conn.prepareStatement(sql);
				
				//select文を実行し、結果表（ResultSet）を取得・実行
				//executeQueryメソッド データを読み取る（件数分）→リストが返ってreに入る
				ResultSet rs = pStmt.executeQuery();
				
				//Employee employee;ここで宣言してはダメ！
				while(rs.next()) {
					String id = rs.getString("ID");
					String name = rs.getString("NAME");
					int age = rs.getInt("AGE");
					
					Employee employee = new Employee(id, name, age);
					empList.add(employee);
				
				}
				
			} catch (SQLException e) {
				e.printStackTrace();//エラーを出すデータベース以外のエラーは出さない クロ－ズ処理不要
				return null;
			}
	 			return empList;
		}
	
}
