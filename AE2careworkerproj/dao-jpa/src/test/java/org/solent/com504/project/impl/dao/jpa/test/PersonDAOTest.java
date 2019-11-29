/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.solent.com504.project.impl.dao.jpa.test;

import java.util.List;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;
import org.solent.com504.project.impl.dao.jpa.DAOFactoryJPAImpl;
import org.solent.com504.project.model.dao.PersonDAO;
import org.solent.com504.project.model.dto.Person;
import org.solent.com504.project.model.dto.Role;

/**
 *
 * @author cgallen
 */
public class PersonDAOTest {

    final static Logger LOG = LogManager.getLogger(PersonDAOTest.class);

    private PersonDAO personDao = null;

    private DAOFactoryJPAImpl daoFactory = new DAOFactoryJPAImpl();

    @Before
    public void before() {
        personDao = daoFactory.getPersonDAO();
        assertNotNull(personDao);
    }

    // initialises database for each test
    private void init() {
        // delete all in database
        personDao.deleteAll();
        // add 5 patients
        for (int i = 1; i < 6; i++) {
            Person p = new Person();
            p.setAddress("address_" + i);
            p.setFirstName("firstName_" + i);
            p.setSecondName("secondName_" + i);
            p.setRole(Role.PATIENT);
            personDao.save(p);
        }
    }

    @Test
    public void createPersonDAOTest() {
        LOG.debug("start of createPersonDAOTest");
        personDao = daoFactory.getPersonDAO();
        assertNotNull(personDao);
        LOG.debug("end of createPersonDAOTest");
    }

    @Test
    public void findByIdTest() {
        LOG.debug("start of findByIdTest()");
        assertNotNull(personDao);
        init();

        Person p = new Person();
        p.setAddress("123 street road");
        p.setFirstName("John");
        p.setSecondName("Doe");
        p.setRole(Role.PATIENT);
        personDao.save(p);
        assertNotNull(p);

        Long foundId = p.getId();
        Person foundPerson = personDao.findById(foundId);
        assertEquals("John", foundPerson.getFirstName());

        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void saveTest() {
        LOG.debug("start of saveTest()");
        assertNotNull(personDao);
        personDao.deleteAll();

        Person p = new Person();
        p.setAddress("123 street road");
        p.setFirstName("John");
        p.setSecondName("Doe");
        p.setRole(Role.PATIENT);
        personDao.save(p);
        assertNotNull(p);

        Long foundId = p.getId();
        Person foundPerson = personDao.findById(foundId);
        assertEquals("John", foundPerson.getFirstName());
        LOG.debug("end of saveTest()");
    }

    @Test
    public void findAllTest() {
        LOG.debug("start of findAllTest()");

        init();
        List<Person> personList = personDao.findAll();
        assertNotNull(personList);
        
        assertEquals(5, personList.size());

        String msg = "";
        for (Person person : personList) {
            msg = msg +"\n   " +  person.toString();
        }
        LOG.debug("findAllTest() retrieved:" + msg);
        
        List<Person> retrievedPersons = personDao.findAll();
        LOG.debug(retrievedPersons.size() + " People found");
        assertEquals(5, retrievedPersons.size());
        LOG.debug("end of findAllTest()");
    }

    @Test
    public void deleteByIdTest() {
        LOG.debug("start of deleteByIdTest()");
        assertNotNull(personDao);
        init(); 
        Person p = new Person();
        p.setAddress("123 street road");
        p.setFirstName("John");
        p.setSecondName("Doe");
        p.setRole(Role.PATIENT);
        personDao.save(p);
        assertNotNull(p);

        Long foundId = p.getId();
        Person foundPerson = personDao.findById(foundId);
        assertEquals("John", foundPerson.getFirstName());
        personDao.deleteById(foundId);
        assertNull(personDao.findById(foundId));

        LOG.debug("end of deleteByIdTest()");
    }

    @Test
    public void deleteTest() {
        LOG.debug("start of deleteTest()");
        assertNotNull(personDao);
        init(); 
        
        Person p = new Person();
        p.setAddress("123 street road");
        p.setFirstName("John");
        p.setSecondName("Doe");
        p.setRole(Role.PATIENT);
        personDao.save(p);
        assertNotNull(p);
        
        Long foundId = p.getId();
        personDao.delete(p);
        assertNull(personDao.findById(foundId));

        LOG.debug("end ofdeleteTest()");
    }

    @Test
    public void deleteAllTest() {
        LOG.debug("start of deleteAllTest())");
        assertNotNull(personDao);
        init(); 
        
        List<Person> personsRetrieved = personDao.findAll();
        
        personDao.deleteAll();
        LOG.debug(personsRetrieved.size() + " personsRetrieved:");
        for (Person p : personsRetrieved) {
            LOG.debug("\n   " + p);
        }
        
        LOG.debug("end of deleteAllTest()");
    }

    @Test
    public void findByRoleTest() {
        LOG.debug("start of findByIdTest()");
        assertNotNull(personDao);
        init(); 
       
        List<Person> peopleFound = personDao.findByRole(Role.PATIENT);
        for (Person p : peopleFound) {
            LOG.debug("\n  " + p);
        }
        LOG.debug("end of findByIdTest()");
    }

    @Test
    public void findByNameTest() {
        LOG.debug("start of findByNameTest()");
        assertNotNull(personDao);
        init(); 
        
        Person p = new Person();
        p.setAddress("123 street road");
        p.setFirstName("John");
        p.setSecondName("Doe");
        p.setRole(Role.PATIENT);
        personDao.save(p);
        assertNotNull(p);
        
        List<Person> person = personDao.findByName("John", "Doe");
        assertNotNull(person);
        for (Person per : person) {
            assertEquals("John", per.getFirstName());
        }
        LOG.debug("end of findByNameTest())");

    }
}
