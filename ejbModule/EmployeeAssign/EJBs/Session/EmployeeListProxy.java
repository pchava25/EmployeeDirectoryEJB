package EmployeeAssign.EJBs.Session;


import java.util.Set;
import javax.ejb.Remote;
import javax.jws.WebService;

import EmployeeAssign.EJBs.Entity.*;
import EmployeeAssign.EJBs.Object.*;


@WebService
@Remote
public interface EmployeeListProxy {
	public Set<EmployeeAssign.EJBs.Object.EmployeeBean> search(String type,String term);
	public Set<EmployeeAssign.EJBs.Object.PhonenumberBean> getPhonenumbersList(String id);
	public Set<EmployeeAssign.EJBs.Object.LocationBean> getLocationsList(String id);
	public EmployeeAssign.EJBs.Object.LocationBean getOfficeLocation(String id);
	public EmployeeAssign.EJBs.Object.PhonenumberBean getOfficePhonenumber(String id);
	public EmployeeAssign.EJBs.Object.EmployeeBean getSupervisorDetails(String id);
	public EmployeeAssign.EJBs.Object.EmployeeBean getEmployee(String id);
	public Set<EmployeeAssign.EJBs.Object.EmployeeBean> getAllEmployees();

}
