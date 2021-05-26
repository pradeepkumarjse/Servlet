package com.nt.test;

public class DynamicObjectCreationTest1 {
 public static void main(String[] args) throws Exception {
	 //load the class
	 Class c=Class.forName(args[0]);
	 //object creation using newInstance() of java.lang.Class
	 Object obj=c.newInstance();
	 System.out.println(obj.toString());
 }
}
