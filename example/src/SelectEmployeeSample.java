import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectEmployeeSample {
	// データベースに接続
	public static void main(String[] args) {
		//()内自動で閉じる connは接続オブジェクト
		//先にcatch分をつくる
		try (Connection conn = DriverManager.getConnection(
				"jdbc:h2:tcp://localhost/~/example", "sa", "")) {

			// select文を準備
			String sql = "SELECT ID,NAME,AGE FROM EMPLOYEE";
			preparedStatement pStm = conn.preparedStatement(sql);
			
			//select文を実行し、結果表（ResultSet）を取得
			ResultSet re = pStmt = conn.preparedStatement(sql);
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

}
