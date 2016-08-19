package deneme;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
public class Adress {

	@Id
	@SequenceGenerator(name = "ADRESS_SEQUENCE_GENERATOR", sequenceName = "ADRESS_SEQUENCE", initialValue = 100)
	@GeneratedValue(generator = "ADRESS_SEQUENCE_GENERATOR")
	@Column(name = "ADRESS_ID")
	private int adressId;
	private String street;
	private String city;
	
	public Adress() {
		// TODO Auto-generated constructor stub
	}

	public int getAdressId() {
		return adressId;
	}

	public void setAdressId(int adressId) {
		this.adressId = adressId;
	}

	public String getStreet() {
		return street;
	}

	public void setStreet(String street) {
		this.street = street;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Adress(String street, String city) {
		this.street = street;
		this.city = city;
	}
	
}