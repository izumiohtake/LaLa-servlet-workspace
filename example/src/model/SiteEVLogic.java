package model;

public class SiteEVLogic {
	//likeの数を１増やす
	public void like(SiteEV site) {//SiteEV のjavabeans siteというインスタンスの中に数入ってる
		int count = site.getLike();
		site.setLike(count + 1);
	}
	//dislikeの数を１増やす
	public void dislike(SiteEV site) {
		int count = site.getDislike();
		site.setDislike(count + 1);
	}
	
}
