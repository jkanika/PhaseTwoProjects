package com.phaseTwo.AssignmentThree.AddProduct;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "person")
public class Person {

	Person(){
		
	}
	
	@Id
	@Column(name = "p_id")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int p_id;
	

	@Column(name = "p_name")
	String p_name;

	@Column(name = "p_add")
	String p_add;

	@Column(name = "p_city")
	String p_city;

	public Person(String p_name, String p_add, String p_city) {
		this.p_name = p_name;
		this.p_add = p_add;
		this.p_city = p_city;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public String getP_add() {
		return p_add;
	}

	public void setP_add(String p_add) {
		this.p_add = p_add;
	}

	public String getP_city() {
		return p_city;
	}

	public void setP_city(String p_city) {
		this.p_city = p_city;
	}

	@Override
	public String toString() {
		return "Person [p_id=" + p_id + ", p_name=" + p_name + ", p_add=" + p_add + ", p_city=" + p_city + "]";
	}
}
