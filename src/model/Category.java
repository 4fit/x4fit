package model;

public class Category 
{
	private int id;
	private String name;
	private String detail;
	private int count_post;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDetail() {
		return detail;
	}
	public void setDetail(String detail) {
		this.detail = detail;
	}
	public int getCount_post() {
		return count_post;
	}
	public void setCount_post(int count_post) {
		this.count_post = count_post;
	}
	
}
