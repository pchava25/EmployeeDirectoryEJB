package EmployeeAssign.EJBs.Object;

import java.util.Set;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;

import EmployeeAssign.EJBs.Entity.Employee;

public class SupervisorBean {
	private String sid;

	
    public SupervisorBean() {
    }

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}
	
}
