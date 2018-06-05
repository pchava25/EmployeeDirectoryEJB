package EmployeeAssign.EJBs.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the employee database table.
 * 
 */
@Entity
@Table(name="employee")
@NamedQuery(name="Employee.findAll", query="SELECT e FROM Employee e")
public class Employee implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String id;

	private String email;

	private String firstname;

	private String jobtitle;

	private String lastname;

	private String middlename;

	//bi-directional many-to-one association to Supervisor
	@ManyToOne
	@JoinColumn(name="sid")
	private Supervisor supervisor1;

	//bi-directional many-to-one association to Location
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private Set<Location> locations;

	//bi-directional many-to-one association to Phonenumber
	@OneToMany(mappedBy="employee", fetch=FetchType.EAGER)
	private Set<Phonenumber> phonenumbers;

	//bi-directional one-to-one association to Supervisor
	@OneToOne(mappedBy="employee")
	private Supervisor supervisor2;

	public Employee() {
	}

	public String getId() {
		return this.id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getFirstname() {
		return this.firstname;
	}

	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getJobtitle() {
		return this.jobtitle;
	}

	public void setJobtitle(String jobtitle) {
		this.jobtitle = jobtitle;
	}

	public String getLastname() {
		return this.lastname;
	}

	public void setLastname(String lastname) {
		this.lastname = lastname;
	}

	public String getMiddlename() {
		return this.middlename;
	}

	public void setMiddlename(String middlename) {
		this.middlename = middlename;
	}

	public Supervisor getSupervisor1() {
		return this.supervisor1;
	}

	public void setSupervisor1(Supervisor supervisor1) {
		this.supervisor1 = supervisor1;
	}

	public Set<Location> getLocations() {
		return this.locations;
	}

	public void setLocations(Set<Location> locations) {
		this.locations = locations;
	}

	public Location addLocation(Location location) {
		getLocations().add(location);
		location.setEmployee(this);

		return location;
	}

	public Location removeLocation(Location location) {
		getLocations().remove(location);
		location.setEmployee(null);

		return location;
	}

	public Set<Phonenumber> getPhonenumbers() {
		return this.phonenumbers;
	}

	public void setPhonenumbers(Set<Phonenumber> phonenumbers) {
		this.phonenumbers = phonenumbers;
	}

	public Phonenumber addPhonenumber(Phonenumber phonenumber) {
		getPhonenumbers().add(phonenumber);
		phonenumber.setEmployee(this);

		return phonenumber;
	}

	public Phonenumber removePhonenumber(Phonenumber phonenumber) {
		getPhonenumbers().remove(phonenumber);
		phonenumber.setEmployee(null);

		return phonenumber;
	}

	public Supervisor getSupervisor2() {
		return this.supervisor2;
	}

	public void setSupervisor2(Supervisor supervisor2) {
		this.supervisor2 = supervisor2;
	}

}