package EmployeeAssign.EJBs.Object;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import EmployeeAssign.EJBs.Entity.Employee;

public class PhonenumberBean {
	private int phoneid;

	private String number;

	private String phonetype;

	//bi-directional many-to-one association to Employee
    
    public PhonenumberBean() {
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

	
}
