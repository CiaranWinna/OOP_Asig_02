/**
 * Assignment 2_2017
 *
 * Student Name: Ciaran Winnan
 * Student Number: 2940836
 */
import java.util.*;

public class Assignment2_2017 {
	
	public static void main(String[] args) {
		
    //Question 1 test Circle class here
    
    //generating an instance of myPoint, passing the x and y coordinates
    Point myPoint = new Point (2.5, 4.5);
    //Calling the toString method to return the coordinates as a string
    String centrePoint = myPoint.toString();
    //Will display the centre point of the first circle
    System.out.println("Question 1:\n.....................................\n\n1)Centre of the circle: " + centrePoint + "\n");
    //Generation of the instance myCircle, passing the instance of myPoint and the radius of the circle
    Circle myCircle = new Circle (myPoint, 4.5);
    //Calling the getRadius method to return the radius of the circle in the form of a double
    double circleRadius = myCircle.getRadius();
    //Display the returned result from calling th getRadius method
    System.out.println("2)Radius: " + circleRadius);
    //Calling the getArea method to return the area of the circle as a double
    double circleArea = myCircle.getArea ();
    //Display the result of calling the above method
    System.out.println("\n3)Area: " + circleArea);
    //call the getCircumference method to return the circumference of the circle in the form of a double
    double circleCircumference = myCircle.getCircumference();
    //Display the result of calling the above method
    System.out.println("\n4)Circumference:" + circleCircumference);
    //Generation of a random point instance, passing the x and y coordinates
    Point mySecondPoint = new Point (1.2,6.2);
  	//sending the instance of the random point to the distance method from the instance of myPoint
  	double circleDistance = myPoint.distance(mySecondPoint);
  	//Displaying the result of the return from calling the above method
  	System.out.println("\n5)Distance between random point and centre point: " + circleDistance);
    //Passing the double circleDistance to the method distanceChecker from the instance myCircle
    String randomPointDistanceChecker = myCircle.distanceChecker(circleDistance);
    //Display the result
    System.out.println(randomPointDistanceChecker);
    //Generation of the centre point instance of C1
    Point pointC1 = new Point (7.5, 7.5);
   	//Calling the method .distance and passing the the pointC1 instance
   	double firstCircleDistanceToC1 = myPoint.distance(pointC1);
   	//Displaying the result
   	System.out.println("\n6)Distance between the first circla and C1:" + firstCircleDistanceToC1);
   	//Calling the .distanceCheckerForTwoCircles and passing the variable firstCircleDistanceToC1 and the radius of the second circle
   	String intersectionOfCircles = myCircle.distanceCheckerForTwoCircles(firstCircleDistanceToC1, 3.5);
   	//Displaying the result
   	System.out.println(intersectionOfCircles);
    
    
    
    //============================================================
    //Question 2 testing here ====================================
    
    //Creating an instance of the class Email and passing varibles to the class
    Email myEmails = new Email("john@gmail.com", "jimmyjack@gmail.com");
    //Calling method to retrieve home and work email and displaying information to the user
	String homeEmail = myEmails.getHomeEmail();
	String workEmail = myEmails.getWorkEmail();
	System.out.println("\nQuestion 2:\n.....................................\n\nHork email: " + homeEmail + "\nWork email: " + workEmail);
	//Asking the user to input a new home and work email
	Scanner myScanner = new Scanner(System.in);
	System.out.println("\nPlease enter your new home address:");  
	String homeEmailChange = myScanner.nextLine();
	System.out.println("\nPlease enter your new work address:");
  	String workEmailChange = myScanner.nextLine();
  	//Passing the newly stored home and work email to the relevent set methods in the Email class
  	myEmails.setHomeEmail(homeEmailChange);
  	myEmails.setWorkEmail(workEmailChange);
  	//Generating an output to display the newly changed emails
  	System.out.println("\nNew home email: " + myEmails.getHomeEmail());
  	System.out.println("New work email: " + myEmails.getWorkEmail() + "\n");
  	//Creating an instance of the Employee class and taking in 3 arguments
  	Employee employee1 = new Employee ("John", "Williams" ,myEmails);
  	String userName = employee1.getName();
  	String userEmails = employee1.getEmails();
  	System.out.println(userName + userEmails);
  
  }
}
//Classes for Question 1======================================
class Circle{
	
	private Point p;
	private double r;
	
	public Circle(Point p0, double r0){
		p = p0;
		r = r0;
	}
	
	public double getRadius(){
		return r;
	}
	
	public double getArea(){
		double circleArea = (Math.PI * (r*r));
		return circleArea;
	}
	
	public double getCircumference(){
		double circleCircumference = (2*Math.PI*r);
		return circleCircumference;
	}
	
	public String distanceChecker(double d){
		
		if(d > r){
			return ("The point is outside of the circle!");
		}
		else if (d < r){
			return ("The point is inside the circle!");
		}
		else{
			return ("The point is on the circle");
		}
	}
	
	public String distanceCheckerForTwoCircles(double d, double rC1){
		if(d > (rC1 + r)){
			return ("\n7)The circles do not intersect");
		}
		else{
			return ("\n7)The circles do intersect");
		}
	}

}

class Point{
	
	private double x;
	private double y;
	
	public Point(double x0, double y0){
		x = x0; 
		y = y0;
	}
	
	public double getX(){
		return x;
	}
	
	public double getY(){
		return y;
	}
	
	public void setX(double x0){
		x = x0;
	}
	
	public void setY(double y0){
		y = y0;
	}
	
	public String toString(){
		return "("+x+","+y+")";
	}
	
	public double distance(Point p){
		double x1 = this.x-p.getX();
		double y1 = this.y-p.getY();
		double d = Math.sqrt(x1*x1+y1*y1);
		return d;
	}
}

//classes for Question 2==================================================
class Email{
	private String home;
	private String work;
	
	public Email(String h, String w){
		home = h;
		work = w;
	}
	
	public String getHomeEmail(){
		return home;
	}
	
	public String getWorkEmail(){
		return work;
	}
	
	public void setHomeEmail(String h){
		home = h;
		
	}
	
	public void setWorkEmail(String w){
		work = w;
	}
}

class Employee{

	private String name;
	private String sureName;
	private Email emails;
		
	public Employee(String n, String s, Email e){
		name = n;
		sureName = s;
		emails = e;
	}
	
	public String getName(){
		return new String ("Name: " + name + " " + sureName);
	}
	
	public String getEmails(){
		return new String ("\nHome Email: " + emails.getHomeEmail() + "\nWork Email: " + emails.getWorkEmail());
	}
}
