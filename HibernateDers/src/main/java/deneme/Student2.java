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
	
	//  Normalde böyle bir kullaným olmaz ama ben sadece burada nasýl bir class'ý baþka bir class'a 
	//gömebileceðimiz göstermek istedim
	
	@Embedded // embeddable edilen bir tabloyu kullanýyoruz.
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