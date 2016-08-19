package deneme;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SecondaryTable;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;


@Entity(name = "My_Student")
@SecondaryTable(name = "StudentDetail")
public class Student {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Student_ID")
	private int studentid;
	
	@Column(name = "Student_Name")
	private String name;
	
	@Column(name = "Student_Surname")
	private String surname;
	
	@Column(name = "EMAIL" , table = "StudentDetail")
	private String email;
	
	@Column(table = "StudentDetail")
	private String phone;
		
	@Column(table = "StudentDetail")
	private String Adress;
	
	@Temporal(value = TemporalType.DATE)
	@Column(name = "Tarih")
	private Date date;
	
	
	public Student()
	{
		
	}
	public Student(String name,String surname,String email, String phone, String adress,Date date)
	{
		super();
		this.name = name;
		this.surname = surname;
		
		this.Adress = adress;
		this.email = email;
		this.phone = phone;
		this.date = date;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getAdress() {
		return Adress;
	}
	public void setAdress(String adress) {
		Adress = adress;
	}
	public int getStudentid() {
		return studentid;
	}

	public void setStudentid(int studentid) {
		this.studentid = studentid;
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
	

	
	
	
	
}
