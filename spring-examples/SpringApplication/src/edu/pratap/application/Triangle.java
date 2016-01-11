package edu.pratap.application;

public class Triangle 
{
	private String type;
	private int area;
	public String getType() {
		return type;
	}
	public int getArea() {
		return area;
	}
	public void setType(String type) {
		this.type = type;
	}
	public void setArea(int area) {
		this.area = area;
	}
	
	public void showDetails(){
		System.out.println(type+" with area="+area);
	}
}
