package model;

public class LoginLogic {//処理のみモデルにはexecute
	/**
	 * Userインスタンスの中のpassが”1234”であるかどうかを
	 * 調べるメソッド
	 * 　User user--name：名前
	 *             pass：パスワード
	 *  使い方：LoginLogic logic = new Loginlogic();
	 *        if(login.execute(user)){
	 *        //正しいパスワードの時の処理
	 *        }　else{
	 *        //まちがったパスワードの時の処理
	 *        }	 *               
	 * ＠param　user
	 * ＠return　true--パスワードが1234である
	 *          false--違う
	 * */
	public boolean execute(User user) {//execute実行する　引数はUserビーンズ
		if(user.getPass().equals("1234")) {
			return true;
			}
		return false;
	}
}
