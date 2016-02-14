package de.dhbwka.java.exercise.classes;

public class Point {
	private double x;
	private double y;
	
	public Point(double x, double y){
		this.x = x;
		this.y = y;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x){
		this.x = x;
	}
	
	public void setY(double y){
		this.y = y;
	}
	
	public String toString(){
		return "X: "+x+" Y: "+y;
	}
	
	public double getAbstandToUrsprung(){
		System.out.println(Math.pow(x, 2));
		System.out.println(Math.sqrt(8));
		return Math.sqrt(Math.pow(x, 2) + Math.pow(y, 2));
	}
	
	public Point spiegelnAnX(){
		return new Point(x, y*(-1));
	}
	
	public Point spiegelnAnY(){
		return new Point(x*(-1),y);
	}
	
	public Point spiegelnAnUrsprung(){
		return new Point(x*(-1), y*(-1));
	}
	
	public double getAbstandTo(Point point2){
		return Math.sqrt(Math.pow(point2.getX() - x, 2)+ Math.pow(point2.getY() - y, 2));
	}
}
