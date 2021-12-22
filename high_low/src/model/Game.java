package model;

import java.io.Serializable;

public class Game implements Serializable{
	private int user;
	private int com;
	private String msg;
	
	public Game() {}//引数なしのコンストラクタ
	public Game(int user, int com, String msg) {//引数3つののコンストラクタ
		this.user = user;
		this.com = com;
		this.msg = msg;
	}
	

	public int getUser() {
		return user;
	}
	public void setUser(int user) {
		this.user = user;
	}
	public int getCom() {
		return com;
	}
	public void setCom(int com) {
		this.com = com;
	}
	public String getMsg() {
		return msg;
	}
	public void setMsg(String msg) {
		this.msg = msg;
	}
}
