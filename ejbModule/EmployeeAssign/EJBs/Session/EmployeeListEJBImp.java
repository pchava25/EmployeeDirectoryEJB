package EmployeeAssign.EJBs.Session;

import java.util.ArrayList;
import java.util.Hashtable;
import java.util.Set;
import java.util.List;
import java.util.HashSet;

import javax.persistence.NoResultException;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;
import javax.persistence.PersistenceContext;
import javax.persistence.PersistenceContextType;
import javax.persistence.Query;

import EmployeeAssign.EJBs.Entity.*;


@Stateless
@WebService(endpointInterface = "EmployeeAssign.EJBs.Session.EmployeeListEJBRemote", serviceName = "EmployeeDirectoryWS")
public class EmployeeListEJBImp implements EmployeeListEJBRemote {
	 
	@PersistenceContext(unitName="EmployeeDirectoryPersistence")
	private EntityManager entitymanager;
	
	public Employee getEmployee(String id)
	{
		return entitymanager.find(Employee.class, id);
		
	}
	
	public void updateEmployee(Employee e) {
		entitymanager.merge(e);
		entitymanager.flush();
	}
	
	public void updatePhonenumber(Phonenumber p) {
		entitymanager.merge(p);		
	}
	public void updateLocation(Location l) {
		entitymanager.merge(l);
		entitymanager.flush();			
	}
	
	public void removeEmployee(String id)
	{
		Employee E=entitymanager.find(Employee.class, id);
		entitymanager.remove(E);
	}
	public Employee createEmployee(Employee E)
	{	
		entitymanager.persist(E);
		return E;		
	}
	public Supervisor createSupervisor(Supervisor E)
	{	
		entitymanager.persist(E);
		return E;		
	}

	
	public Phonenumber createPhonenumber(Phonenumber P)
	{	
		entitymanager.persist(P);	
		return P;		
	}
	public Location createLocation(Location L)
	{

		entitymanager.persist(L);
		return L;		
	}
	
	/*public void addPhoneNumber(String eid, Phonenumber p)
	{		
		Employee E=entitymanager.find(Employee.class, eid);
		E.getPhonenumbers().add(p);
	}
	public void addLocation(String eid, Location l)
	{
		Employee E=entitymanager.find(Employee.class, eid);
		E.getLocations().add(l);
	}*/
	public Set<Employee> getAllEmployees()
	{
		Query q = entitymanager.createQuery(" from Employee e ");
	    Set<Employee> e= new HashSet<Employee>(q.getResultList());
		return e ;
	}
	public boolean emailExists(String email)
	{
		boolean exists=true;
		Query q = entitymanager.createQuery("select email from Employee e where email=:email ");
		q.setParameter("email", email);
	    		
		if(q.getResultList().isEmpty())
		{
			exists=false;
		}
		return exists;		
	}
	public boolean employeeExists(String id)
	{
		boolean exists=true;
		Employee E=entitymanager.find(Employee.class, id);
		if(E==null)
		{
			exists=false;
		}
		return exists;
	}/*
	public boolean locationtypeExists(String locationtype)
	{
		boolean exists=true;
		Query q = entitymanager.createQuery("select l.locationtype from Location l where :employee member of l.employees and l.locationtype=:locationtype ");
		q.setParameter("locationtype", locationtype);
	    		
		if(q.getResultList().isEmpty())
		{
			exists=false;
		}
		return exists;	
	}
	public boolean phonetypeExists(String phonetype)
	{
		boolean exists=true;
		Query q = entitymanager.createQuery("select p.phonetype from Phonenumber p where p.employee=:employee and phonetype=:phonetype ");
		q.setParameter("phonetype", phonetype);
	    		
		if(q.getResultList().isEmpty())
		{
			exists=false;
		}
		return exists;	
	}
	*/
	public Phonenumber getOfficeNumber(Employee employee)
	{
		Phonenumber p=null;
		Query q = entitymanager.createQuery(" from Phonenumber p where p.employee=:employee and phonetype=:office");
		q.setParameter("employee", employee);
		q.setParameter("office", "Office");
		List<Phonenumber> results = q.getResultList();		
		if(!results.isEmpty()){
		    // ignores multiple results
		    p =results.get(0);
		}
		return p;		
		}
	
	public Location getOfficeLocation(Employee employee)
	{
		Location l=null;
		Query q = entitymanager.createQuery("from Location l where l.employee=:employee and locationtype=:office");
		q.setParameter("employee", employee);
		q.setParameter("office", "Office");
		List<Location> results = q.getResultList();		
		if(!results.isEmpty()){
		    // ignores multiple results
		   l = results.get(0);
		}
		return l;
	}
	/*
	public Employee getSupervisorDetails(Supervisor s)
	{
		String id=s.getSid();
		Employee e=null;
		e=entitymanager.find(Employee.class, id);
		return e;			
	}*/
	
	/*public List<Supervisor> getSupervisorList()
	{
		Query q = entitymanager.createQuery("from Supervisor s");
		List<Supervisor> s=null;
		s=q.getResultList();		
	    return s;		
	}*/
	public boolean noSupervisors(String sid)
	{
		boolean empty=false;
		Supervisor s=entitymanager.find(Supervisor.class,sid);
	     if(s==null)
	     {
	    	 empty=true;
	     }
	return empty;
		
	}
	public Supervisor getSupervisor(String sid)
	{
		 
		//String sid=str;
		//Employee employee=entitymanager.find(Employee.class, id);
		Supervisor s=entitymanager.find(Supervisor.class, sid);
		 return s;			
	}
	public Set<Phonenumber> getPhonenumbers(String id)
	{
		Employee e=entitymanager.find(Employee.class, id);
		Query q = entitymanager.createQuery(" from Phonenumber p where p.employee=:e");
		q.setParameter("e", e);
	    return (new HashSet(q.getResultList()));
		
	}
	public Set<Location> getLocations(String id)
	{
		Employee employee=entitymanager.find(Employee.class, id);
		Query q = entitymanager.createQuery("from Location l where l.employee=:employee");
		q.setParameter("employee", employee);
	    return (new HashSet(q.getResultList() ));		
	}
	

	public Set<Employee> searchEmployee(String type,String term)
	{		
		Hashtable<String,String> searchCriteria=new Hashtable<String,String>();
		searchCriteria.put(type, term);
		StringBuffer sbQL = new StringBuffer(" from Employee e ");
		StringBuffer sbQL1 = new StringBuffer(" select p.employee from Phonenumber p ");
		Query q=null;
		List<String> criteriaList = new ArrayList<String>();
		int iParamCount = 1;
		
		if (searchCriteria != null && searchCriteria.size()>0) {
			sbQL.append(" WHERE ");
			sbQL1.append(" WHERE  ");
			if (searchCriteria.containsKey("lastname")|| (searchCriteria.containsKey("firstname")) )
			{
			
			sbQL1.append(" WHERE  ");
			
			if (searchCriteria.containsKey("lastname")) {
				sbQL.append(" lastname LIKE ?" + (iParamCount++));
				criteriaList.add(searchCriteria.get("lastname"));
			}
			if (searchCriteria.containsKey("firstname")) {
				//if (!criteriaList.isEmpty())  sbQL.append(" AND ");
				sbQL.append(" firstname LIKE ?" + (iParamCount++));
				criteriaList.add(searchCriteria.get("firstname"));
			}
			
			q = entitymanager.createQuery(sbQL.toString());
			
			}
			else if (searchCriteria.containsKey("phonenumbers")) {
				//if (!criteriaList.isEmpty())  sbQL.append(" AND ");
				sbQL1.append("p.number LIKE ?)" + (iParamCount++));
				criteriaList.add(searchCriteria.get("phonenumbers"));
				q = entitymanager.createQuery(sbQL1.toString());
			}				
				
		}
		System.out.println(sbQL);
		
		iParamCount = 1;
		for (String c : criteriaList)
			q.setParameter(iParamCount++, "%" + c + "%");
		 
	    return new HashSet(q.getResultList());	
	}
	

}
