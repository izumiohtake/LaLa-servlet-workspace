package model;

public class GameLogic {
	public void execute(Game game) {
		int user = game.getUser();
		int com = game.getCom();
		String msg = game.getMsg();

		if (user > com) {
			msg = "大きすぎます";
		} else if (user < com) {
			msg = "小さすぎます";
		} else {
			msg = "正解です";
		}
		game.setMsg(msg);// 新しいgameインスタンス
	}

}
