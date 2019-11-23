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
        Query q = entityManager.createQuery("DELETE FROM Animal a WHERE a.id=:id");
        q.setParameter("id", id);
        q.executeUpdate();
        entityManager.getTransaction().commit();
    }

    @Override
    public Person delete(Person person) {
        entityManager.getTransaction().begin();
        entityManager.createQuery("DELETE FROM Person p WHERE p=person").setParameter("person", person).executeUpdate();  //possible error
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
//        Map<String, String> paramMap = new HashMap<String, String>();
//   
//        String queryString = "select a from Animal a WHERE TRUE=TRUE  "; // WHERE TRUE=TRUE masn WHERE always has a predicate ";
//        if (animalTemplate.getName() != null) {
//            queryString = queryString + "AND a.name LIKE :name "; //':name' ";
//            paramMap.put("name", animalTemplate.getName());
//        }
//        if (animalTemplate.getAddress() != null) {
//            queryString = queryString + "AND a.address LIKE :address ";
//            paramMap.put("address", animalTemplate.getAddress());
//        }
//        if (animalTemplate.getAnimalType()!=null && animalTemplate.getAnimalType().getType() != null) {
//            queryString = queryString + "AND a.animalType.type LIKE :type ";
//            paramMap.put("type", animalTemplate.getAnimalType().getType());
//        }
//        
//        // prevents running this section if not printing debug log
//        if (LOG.isDebugEnabled()) {
//            LOG.debug("queryString string built: " + queryString + "using parameters: ");
//            for (String key : paramMap.keySet()) {
//                LOG.debug("key: "+key + " value:"+paramMap.get(key));
//            }
//        }
//
//        TypedQuery<Animal> query = entityManager.createQuery(queryString, Animal.class);
//        for (String key : paramMap.keySet()) {
//            query.setParameter(key, paramMap.get(key));
//        }
//
//        List<Animal> animalList = query.getResultList();
//        return animalList;
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Person> findByName(String firstName, String secondName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
