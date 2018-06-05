package EmployeeAssign.EJBs.Entity;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Set;


/**
 * The persistent class for the supervisor database table.
 * 
 */
@Entity
@Table(name="supervisor")
@NamedQuery(name="Supervisor.findAll", query="SELECT s FROM Supervisor s")
public class Supervisor implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	private String sid;

	//bi-directional many-to-one association to Employee
	@OneToMany(mappedBy="supervisor1", fetch=FetchType.EAGER)
	private Set<Employee> employees;

	//bi-directional one-to-one association to Employee
	@OneToOne
	@JoinColumn(name="sid")
	private Employee employee;

	public Supervisor() {
	}

	public String getSid() {
		return this.sid;
	}

	public void setSid(String sid) {
		this.sid = sid;
	}

	public Set<Employee> getEmployees() {
		return this.employees;
	}

	public void setEmployees(Set<Employee> employees) {
		this.employees = employees;
	}

	public Employee addEmployee(Employee employee) {
		getEmployees().add(employee);
		employee.setSupervisor1(this);

		return employee;
	}

	public Employee removeEmployee(Employee employee) {
		getEmployees().remove(employee);
		employee.setSupervisor1(null);

		return employee;
	}

	public Employee getEmployee() {
		return this.employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

}