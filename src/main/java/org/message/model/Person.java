package org.message.model;

import javax.persistence.*;

@Entity
@Table(name = "person")
public class Person{

	@Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
	private int userId;
	
	@Column(length=255, unique = true)
	private String name;
	
	public Person(){
		
	}
	
	public Person(int userId, String name) {
		this.userId = userId;
		this.name = name;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "User [userId=" + userId + ", name=" + name + "]";
	}
	
}
