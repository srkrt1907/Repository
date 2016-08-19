package deneme;
import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student2 {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int studentId;
	
	//  Normalde b�yle bir kullan�m olmaz ama ben sadece burada nas�l bir class'� ba�ka bir class'a 
	//g�mebilece�imiz g�stermek istedim
	
	@Embedded // embeddable edilen bir tabloyu kullan�yoruz.
	private person person;

	@Column(name = "SCHOOL")
	private String schoolName;

	public Student2() {
		// TODO Auto-generated constructor stub
	}
	public Student2(person person, String schoolName) {
		this.person = person;
		this.schoolName = schoolName;
	}
	public int getStudentId() {
		return studentId;
	}
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	public person getperson() {
		return person;
	}
	public void setperson(person person) {
		this.person = person;
	}
	public String getSchoolName() {
		return schoolName;
	}
	public void setSchoolName(String schoolName) {
		this.schoolName = schoolName;
	}
}