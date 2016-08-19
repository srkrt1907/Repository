package deneme;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
	
	public static void main(String[] args) {
//		List<String> emails = new ArrayList<String>();
//		List<String> phoneNumbers = new ArrayList<String>();
//
//		emails.add("aykanferhat@gmail.com");
//		emails.add("aykanferhat@hotmail.com");
//		emails.add("aykan@hotmail.com");
//		
//		phoneNumbers.add("055555");
//		phoneNumbers.add("066666");
//		phoneNumbers.add("077777");
//
//		Student3 student = new Student3("Ferhat", "Aykna", 1994, emails, phoneNumbers);
//        
//        SessionFactory sessionFactory = new Configuration().configure("/deneme/hibernate.cfg.xml").buildSessionFactory();
//        Session session = sessionFactory.openSession();
//
//        session.save(student);
//        
//        session.beginTransaction().commit();
//        session.close();
		
//		Adress adress1 = new Adress("Cumhuriyet cad.", "Ankara");
//		Adress adress2 = new Adress("Çankaya cad", "Ankara");
//		
//		Adress adress3 = new Adress("Kazým Karabekir cad.", "Ankara");
//		Adress adress4 = new Adress("Seyhan cad.", "Adana");
//		
//		Employee employee1 = new Employee("Ferhat", "Aykan");
//		employee1.getAdresses().add(adress1);
//		employee1.getAdresses().add(adress2);
//		
//		Employee employee2 = new Employee("Hakan", "Yýlmaz");
//		employee2.getAdresses().add(adress3);
//		employee2.getAdresses().add(adress4);
//		
//		
//		SessionFactory sessionFactory = new Configuration().configure("/deneme/hibernate.cfg.xml").buildSessionFactory();
//		Session session = sessionFactory.openSession();
// 
//		session.save(adress1);
//		session.save(adress2);
//		session.save(adress3);
//		session.save(adress4);
//		session.save(employee1);
//		session.save(employee2);
// 
//		session.beginTransaction().commit();
//		session.close();
		
		int a = 1;
		int b = a == 1 ? 1 : 0;

		System.out.println("cevep" +  a * b);
	}
	
}
