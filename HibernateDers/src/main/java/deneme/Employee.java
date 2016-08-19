package deneme;

import java.util.ArrayList;
import java.util.List;
 

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
 
@Entity
public class Employee {
 
	@Id
	@SequenceGenerator(name = "EMPLOYEE_SEQUENCE_GENERATOR", sequenceName = "EMPLOYEE_SEQUENCE", initialValue = 100)
	@GeneratedValue(generator = "EMPLOYEE_SEQUENCE_GENERATOR")
	@Column(name = "EMPLOYEE_ID")
	private int employeeId;
	private String name;
	private String surname;
	
	@OneToMany
	@JoinTable(name = "EMPLOYEE_ADRESS" , joinColumns = @JoinColumn(name = "EMPLOYEE_ID"), 
	inverseJoinColumns = @JoinColumn(name = "ADRESS_ID"))
	private List<Adress> adresses = new ArrayList<Adress>();
	
	public Employee() {
		// TODO Auto-generated constructor stub
	}
 
	public Employee(String name, String surname) {
		this.name = name;
		this.surname = surname;
	}

	public int getEmployeeId() {
		return employeeId;
	}

	public void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSurname() {
		return surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public List<Adress> getAdresses() {
		return adresses;
	}

	public void setAdresses(List<Adress> adresses) {
		this.adresses = adresses;
	}
 
}