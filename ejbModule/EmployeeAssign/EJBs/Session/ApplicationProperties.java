package EmployeeAssign.EJBs.Session;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.ejb.ConcurrencyManagement;
import javax.ejb.Lock;
import javax.ejb.ConcurrencyManagementType;
import javax.ejb.LockType;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class ApplicationProperties
 */
@Singleton
@ConcurrencyManagement(ConcurrencyManagementType.CONTAINER)
public class ApplicationProperties implements ApplicationPropertiesRemote {

	private Map<String, String> properties;

	@PostConstruct
	public void initCache() {
		this.properties = new HashMap<String, String>();
	}

	@Lock(LockType.READ)
	public String get(String key) {
		return this.properties.get(key);
	}

	@Lock(LockType.WRITE)
	public void put(String key, String value) {
		this.properties.put(key, value);
	}
}
