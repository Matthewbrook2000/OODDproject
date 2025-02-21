package org.solent.com504.project.impl.dao.jpa;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.persistence.EntityManager;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

public class PersonDAOJpaImpl implements PersonDAO {

    final static Logger LOG = LogManager.getLogger(PersonDAOJpaImpl.class);

    private EntityManager entityManager;

    public PersonDAOJpaImpl(EntityManager em) {
        this.entityManager = em;
    }

    @Override
    public Person findById(Long id) {
        Person person = entityManager.find(Person.class, id);
        return person;
    }

    @Override
    public Person save(Person person) {
        entityManager.getTransaction().begin();
        entityManager.persist(person);  // NOTE merge(animal) differnt semantics
        // entityManager.flush() could be used
        entityManager.getTransaction().commit();
        return person;
    }

    @Override
    public List<Person> findAll() {
        TypedQuery<Person> q = entityManager.createQuery("SELECT p FROM Person p", Person.class);
        List<Person> personList = q.getResultList();
        return personList;
    }

    @Override
    public void deleteById(long id) {
        entityManager.getTransaction().begin();
        Query q = entityManager.createQuery("DELETE FROM Person p WHERE p.id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Person delete(Person person) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Person p WHERE p=:person").setParameter("person", person).executeUpdate();  
        entityManager.getTransaction().commit();
        return person;
    }

    @Override
    public void deleteAll() {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Person ").executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public List<Person> findByRole(Role role) {
        TypedQuery<Person> q = entityManager.createQuery("SELECT p FROM Person p WHERE p.role=:role", Person.class).setParameter("role", role);
        List<Person> personList = q.getResultList();
        return personList;
    }

    @Override
    public List<Person> findByName(String firstName, String secondName) {
        TypedQuery<Person> q = entityManager.createQuery("SELECT p FROM Person p WHERE p.firstName=:firstName AND p.secondName=:secondName", Person.class).setParameter("firstName", firstName).setParameter("secondName", secondName);
        List<Person> personList = q.getResultList();
        return personList;
    }

}
