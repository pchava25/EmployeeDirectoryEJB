package EmployeeAssign.EJBs.Session;
import javax.ejb.Remote;

@Remote
public interface ApplicationPropertiesRemote {
	public String get(String key);

	public void put(String key, String value);

}
