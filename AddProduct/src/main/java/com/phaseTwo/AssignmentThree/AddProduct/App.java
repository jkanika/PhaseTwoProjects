package com.phaseTwo.AssignmentThree.AddProduct;

import java.util.Scanner;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class App 
{
    public static void main( String[] args ) {
    	//Get a Reference to the SessionFactory object
	  	SessionFactory theFactory = new Configuration()
	  								.configure("HibernateConfig.xml")
	  								.addAnnotatedClass(Person.class)
	  								.buildSessionFactory();
	  	
	  	//Get a reference to the Session object
	  	Session theSession = theFactory.getCurrentSession();
	  	
	  	try {
	  	//Begin the transaction
	  	theSession.beginTransaction();
	  	
	  	Scanner scan = new Scanner(System.in);
	  	
	  	System.out.print("Enter the ID of the person : ");
	  	int id = scan.nextInt();
	  	scan.nextLine();
	  	
	  	Person thePerson = theSession.get(Person.class, id);
	  	
	  	if(thePerson == null) {
	  		
	  		System.out.print("Enter Name of the person : ");
	  		String name = scan.nextLine();
	  		System.out.print("Enter Address of the person : ");
	  		String add = scan.nextLine();
	  		System.out.print("Enter City of the person : ");
	  		String city = scan.nextLine();
	  		
	  		Person newP = new Person(name,add,city);
	  		theSession.save(newP);
	  		
//			commit the transaction
			theSession.getTransaction().commit();
	  	}
	  	else {
	  		
	  		System.out.println("Details at the id entered : \n" + thePerson);
	  		
//			commit the transaction
			theSession.getTransaction().commit();
	  	}

	}finally {
		theFactory.close();
		}

	}
}
