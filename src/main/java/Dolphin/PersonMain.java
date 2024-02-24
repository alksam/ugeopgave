package Dolphin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

import java.time.LocalDate;

public class PersonMain {

    public static void main(String[] args) {

        EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    EntityManager em = emf.createEntityManager();
    Person person = new Person("John");
    PersonDetails personDetails = new PersonDetails("123 Main St", "Anytown", 12345, 25);
    Fee fee = new Fee(100, LocalDate.now());
    Fee fee1 = new Fee(200, LocalDate.of(2023, 9, 22));
    Event event = new Event("sen", LocalDate.now());
    Event event1 = new Event("bake", LocalDate.of(2023, 8, 12));

    person.addPersonDetail(personDetails);
    person.addFee(fee);
    person.addFee(fee1);
    person.addEvent(person, event, LocalDate.now(), 100);

    person.addEvent(person, event1, LocalDate.of(2023, 8, 12), 200);



    em.getTransaction().begin();
    em.persist(person);
    em.getTransaction().commit();


    
}
    }



