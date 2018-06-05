package EmployeeAssign.EJBs.Object;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import EmployeeAssign.EJBs.Entity.Location;
import EmployeeAssign.EJBs.Entity.Phonenumber;
import EmployeeAssign.EJBs.Entity.Supervisor;

public class EmployeeBean {
private String id;
	
	private String email;

	private String firstname;

	private String jobtitle;

	private String lastname;

	private String middlename;

	//bi-directional many-to-one association to Supervisor
    
    public EmployeeBean() {
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

}
