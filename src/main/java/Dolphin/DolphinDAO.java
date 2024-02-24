package Dolphin;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;

public class DolphinDAO {

    private EntityManagerFactory emf = HibernateConfig.getEntityManagerFactoryConfig();

    public Person create(Person p ) {
       EntityManager em = emf.createEntityManager();
         em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
            em.close();
return p;
    }

    public Person read(int id) {
        EntityManager em = emf.createEntityManager();
        Person foundPerson = em.find(Person.class, id);
        em.close();
        return foundPerson;
    }

    public Person update(Person p) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person updatedPerson = em.merge(p);
        em.getTransaction().commit();
        em.close();
        return updatedPerson;
    }

    public void delete(int id) {
        EntityManager em = emf.createEntityManager();
        em.getTransaction().begin();
        Person person = read(id);
        if (person != null) {
            em.remove(person);
        }
        em.getTransaction().commit();
        em.close();
    }
}
