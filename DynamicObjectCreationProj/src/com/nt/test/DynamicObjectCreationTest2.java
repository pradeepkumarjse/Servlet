package com.nt.test;
import java.lang.reflect.Constructor;

public class DynamicObjectCreationTest2 {
 public static void main(String[] args) throws Exception{
	 //load the class
	 Class c=Class.forName(args[0]);
	 //get all constructors of loaded java class
 Constructor cons[]=c.getDeclaredConstructors();
 //perform object creation process
 Object obj1=cons[0].newInstance();//0-para,
 System.out.println("obj1 data ::"+obj1);
 System.out.println("................");
 //perform object creation process
 Object obj2=cons[1].newInstance(10,20);//2-param
 System.out.println("Obj2 data ::"+obj2);
 
	 
 }
}
