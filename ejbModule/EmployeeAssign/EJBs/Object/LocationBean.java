package EmployeeAssign.EJBs.Object;

import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

import EmployeeAssign.EJBs.Entity.Employee;

public class LocationBean {
	private int locationid;

	private String city;

	private String county;

	private String locationtype;

	private String state;

	private String street;

	private String zip;

	//bi-directional many-to-one association to Employee
   
    public LocationBean() {
    }

	public int getLocationid() {
		return this.locationid;
	}

	public void setLocationid(int locationid) {
		this.locationid = locationid;
	}

	public String getCity() {
		return this.city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getCounty() {
		return this.county;
	}

	public void setCounty(String county) {
		this.county = county;
	}

	public String getLocationtype() {
		return this.locationtype;
	}

	public void setLocationtype(String locationtype) {
		this.locationtype = locationtype;
	}

	public String getState() {
		return this.state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStreet() {
		return this.street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getZip() {
		return this.zip;
	}

	public void setZip(String zip) {
		this.zip = zip;
	}

	
}
