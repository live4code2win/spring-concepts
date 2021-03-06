package com.spring.concepts.com;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	@Column(name = "emp_name")
	private String name;
	@Column(name = "emp_code")
	private String code;
	@Column(name = "emp_gender")
	private String gender;
	@Column(name = "emp_salary")
	private double salary;
	@Column(name = "emp_mail_id")
	private String email;
	@Column(name = "emp_contact")
	private long contact;
	@Column(name = "emp_password")
	private String password;
	
	public Employee() {
		System.out.println("loading the employee class...");
		this.id = 1010;
		this.name = "Rakesh Sharma";
		this.code = "PROD";
		this.email = "xyz.saiglobal.com";
		this.gender = "Male";
		this.salary = 97298.56d;
	}
	
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
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public long getContact() {
		return contact;
	}
	public void setContact(long contact) {
		this.contact = contact;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + id;
		return result;
	}
	
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Employee other = (Employee) obj;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + name + ", code=" + code + ", gender=" + gender + ", salary=" + salary
				+ ", email=" + email + ", contact=" + contact + ", password=" + password + "]";
	}
	
	public void destroyingEmployeeObject() {
		System.out.println("Shuting down the application context hence cleaning up the employee object");
	}

}
