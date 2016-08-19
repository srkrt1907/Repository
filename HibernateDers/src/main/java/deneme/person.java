package deneme;

import javax.persistence.Embeddable;

@Embeddable
public class person {
 
	private String name;
	private String surname;
	private int year;
	
	public person() {
 
	}
	public person(String name, String surname, int year) {
		this.name = name;
		this.surname = surname;
		this.year = year;
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
}
