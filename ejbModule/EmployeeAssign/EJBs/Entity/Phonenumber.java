package EmployeeAssign.EJBs.Entity;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the phonenumber database table.
 * 
 */
@Entity
@Table(name="phonenumber")
@NamedQuery(name="Phonenumber.findAll", query="SELECT p FROM Phonenumber p")
public class Phonenumber implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private int phoneid;

	private String number;

	private String phonetype;

	//bi-directional many-to-one association to Employee
	@ManyToOne
	@JoinColumn(name="id")
	private Employee employee;

	public Phonenumber() {
	}

	public int getPhoneid() {
		return this.phoneid;
	}

	public void setPhoneid(int phoneid) {
		this.phoneid = phoneid;
	}

	public String getNumber() {
		return this.number;
	}

	public void setNumber(String number) {
		this.number = number;
	}

	public String getPhonetype() {
		return this.phonetype;
	}

	public void setPhonetype(String phonetype) {
		this.phonetype = phonetype;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}