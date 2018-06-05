package EmployeeAssign.EJBs.Session;

import java.util.Collection;

import java.util.Hashtable;
import java.util.Set;
import javax.ejb.Remote;
import javax.jws.WebService;

import EmployeeAssign.EJBs.Entity.*;

import javax.jws.WebMethod;

@WebService
@Remote

public interface EmployeeListEJBRemote {
	
	public Employee getEmployee(String id);	
	//public void updateEmployee(Employee E);
	public void removeEmployee(String id);
	
	public Employee createEmployee(Employee E);
	public Phonenumber getOfficeNumber(Employee e);
	public Location getOfficeLocation(Employee e);
	public Set<Employee> getAllEmployees();
	//public Set<Employee> searchEmployee(Hashtable<String, String> searchCriteria);
	public boolean emailExists(String email);
	public boolean employeeExists(String id);
	public Supervisor createSupervisor(Supervisor E);
	public Supervisor getSupervisor(String str);
	public Set<Phonenumber> getPhonenumbers(String id);
	public Set<Location> getLocations(String id);
	public boolean noSupervisors(String id);
	public Phonenumber createPhonenumber(Phonenumber P);
	public Location createLocation(Location L);
	public void updateEmployee(Employee e);
	
	public void updatePhonenumber(Phonenumber p) ;
	public void updateLocation(Location l) ;	
	public Set<Employee> searchEmployee(String type,String term);
}