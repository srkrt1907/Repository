package deneme;
import java.util.List;
 
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
 
@Entity
public class Student3 {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	private String name;
	private String surname;
	private int year;
	
	@ElementCollection // baska bir tabloda tutmak için kullanýlýr.
	private List<String> emails;
	
	@ElementCollection // baska bit taploda tutmak için kullanýlýr
	private List<String> phoneNumbers;
	
	public Student3() {
	}
	public Student3(String name, String surname, int year, List<String> emails, List<String> phoneNumbers) {
		this.name = name;
		this.surname = surname;
		this.year = year;
		this.emails = emails;
		this.phoneNumbers = phoneNumbers;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
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
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public List<String> getEmails() {
		return emails;
	}
	public void setEmails(List<String> emails) {
		this.emails = emails;
	}
	public List<String> getPhoneNumbers() {
		return phoneNumbers;
	}
	public void setPhoneNumbers(List<String> phoneNumbers) {
		this.phoneNumbers = phoneNumbers;
	}
}