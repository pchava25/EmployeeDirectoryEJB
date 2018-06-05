package EmployeeAssign.EJBs.Session;


import java.util.Set;
import java.util.HashSet;

import javax.ejb.Stateless;
import javax.ejb.EJB;
import javax.jws.WebService;

import EmployeeAssign.EJBs.Entity.*;
import EmployeeAssign.EJBs.Object.EmployeeBean;
import EmployeeAssign.EJBs.Object.LocationBean;
import EmployeeAssign.EJBs.Object.PhonenumberBean;


@Stateless
@WebService(endpointInterface = "EmployeeAssign.EJBs.Session.EmployeeListProxy", serviceName = "EmployeeDirectoryProxyWS")

public class EmployeeListProxyImp implements EmployeeListProxy {

	@EJB
	EmployeeListEJBRemote dao;
	@Override
	public Set<EmployeeBean> search(String type,String term)
	{		
		Set<Employee> e=dao.searchEmployee(type, term);
		Set<EmployeeBean> eb=new HashSet<EmployeeBean>();
		
		
		try{
		for(Employee e1:e)
		{				
			
			EmployeeBean eb1=new EmployeeBean();
			eb1.setEmail(e1.getEmail());
			eb1.setFirstname(e1.getFirstname());
			eb1.setId(e1.getId());
			eb1.setJobtitle(e1.getJobtitle());
			eb1.setLastname(e1.getLastname());
			eb1.setMiddlename(e1.getMiddlename());
			
			eb.add(eb1);			
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return eb;
	}
	@Override
	public Set<PhonenumberBean> getPhonenumbersList(String id)
	{
	
		Set<PhonenumberBean> pb=new HashSet<PhonenumberBean>();
		Set<Phonenumber> p=dao.getPhonenumbers(id);		
		
		try 
		{
		for(Phonenumber p1:p)
		{	
			PhonenumberBean pb1=new PhonenumberBean();	
			pb1.setNumber(p1.getNumber());
			pb1.setPhoneid(p1.getPhoneid());
			pb1.setPhonetype(p1.getPhonetype());
			
			pb.add(pb1);			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return pb;
		
	}
	@Override
	public Set<LocationBean> getLocationsList(String id)
	{
		
		Set <Location> l=dao.getLocations(id);
		Set <LocationBean> lb=new HashSet<LocationBean>();
		
		
		try
		{
		for(Location l1:l)			
		{			
			LocationBean lb1=new LocationBean();
			lb1.setCity(l1.getCity());
			lb1.setCounty(l1.getCounty());
			lb1.setLocationid(l1.getLocationid());
			lb1.setLocationtype(l1.getLocationtype());
			lb1.setState(l1.getState());
			lb1.setStreet(l1.getStreet());
			lb1.setZip(l1.getZip());
			
			lb.add(lb1);
			
		}
		}
		catch(Exception e)
		{
			e.printStackTrace();
		}
		return lb;
	}	
	@Override
	public LocationBean getOfficeLocation(String id)
	{
		LocationBean lb=new LocationBean();
		Employee e=dao.getEmployee(id);
		Location l=dao.getOfficeLocation(e);
		lb.setCity(l.getCity());
		lb.setCounty(l.getCounty());
		lb.setLocationid(l.getLocationid());
		lb.setLocationtype(l.getLocationtype());
		lb.setState(l.getState());
		lb.setStreet(l.getStreet());
		lb.setZip(l.getZip());
		return lb;
	}
	@Override
	public PhonenumberBean getOfficePhonenumber(String id)
	{
		PhonenumberBean pb=new PhonenumberBean();
		Employee e=dao.getEmployee(id);
		Phonenumber p=dao.getOfficeNumber(e);
		pb.setNumber(p.getNumber());
		pb.setPhoneid(p.getPhoneid());
		pb.setPhonetype(p.getPhonetype());
		return pb;
	}
	@Override
	public EmployeeBean getSupervisorDetails(String id)
	{
	EmployeeBean eb=new EmployeeBean();
	//Supervisor s=dao.getSupervisor(id);
	Employee es=dao.getEmployee(id);
	Employee e=dao.getEmployee(es.getSupervisor1().getSid());
	eb.setEmail(e.getEmail());
	eb.setFirstname(e.getFirstname());
	eb.setId(e.getId());
	eb.setJobtitle(e.getJobtitle());
	eb.setLastname(e.getLastname());
	eb.setMiddlename(e.getMiddlename());
	return eb;
	}
	@Override
	public EmployeeBean getEmployee(String id)
	{
	EmployeeBean eb=new EmployeeBean();
	Employee e=dao.getEmployee(id);
	eb.setEmail(e.getEmail());
	eb.setFirstname(e.getFirstname());
	eb.setId(e.getId());
	eb.setJobtitle(e.getJobtitle());
	eb.setLastname(e.getLastname());
	eb.setMiddlename(e.getMiddlename());
	return eb;
	}
	@Override
	public Set<EmployeeBean> getAllEmployees()
	{
		Set<Employee> e=dao.getAllEmployees();
		Set<EmployeeBean> eb=new HashSet<EmployeeBean>();
		
		
		try
		{
		for(Employee e1:e)
		{		
			EmployeeBean eb1=new EmployeeBean();
			eb1.setEmail(e1.getEmail());
			eb1.setFirstname(e1.getFirstname());
			eb1.setId(e1.getId());
			eb1.setJobtitle(e1.getJobtitle());
			eb1.setLastname(e1.getLastname());
			eb1.setMiddlename(e1.getMiddlename());
			
			eb.add(eb1);		
		}
		}
		catch(Exception ex)
		{
			ex.printStackTrace();
		}
		return eb;
	}
}
