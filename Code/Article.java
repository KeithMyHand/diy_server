package com.keith.diy;

public class Article {

	private int id;
	private String title;
	private String des;
	private String icon;

	public Article() {

	}
	
	public Article(int id, String title, String des, String icon) {
		this.id = id;
		this.title = title;
		this.des = des;
		this.icon = icon;
	}
	
	public void setId(int id) {
		this.id = id;
	}

	public int getId() {
		return this.id;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}

	public String getTitle() {
		return this.title;
	}
	
	public void setDes(String des) {
		this.des = des;
	}

	public String getDes() {
		return this.des;
	}
	
	public void setIcon(String icon) {
		this.icon = icon;
	}

	public String getIcon() {
		return this.icon;
	}
}