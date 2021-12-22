package model;

public class HealthCheckLogic {
	public void execute(Health health) {//クラスを引数(参照)にとる
		 double height = health.getHeight() / 100.0;//値あり
		 double weight = health.getWeight();//値あり
		 double bmi = weight / (height * height);
	     health.setBmi(bmi);//値なし
	     
	     String bodyType;
	     if(bmi < 18.5) {
	    	 bodyType = "やせ型";
	     } else if(bmi < 25) {
	    	 bodyType = "普通";
	     } else {
	    	 bodyType = "肥満";
	     }
	     health.setBodyType(bodyType);//値なし
	}
}
