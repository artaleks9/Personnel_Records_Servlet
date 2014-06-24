package com.hometask.testpr;

import com.hometask.precords.Company;
import com.hometask.precords.Employee;
import com.hometask.precords.InvalidArgumentException;
import com.hometask.precords.PersonIO;
import org.junit.Assert;
import org.junit.Test;
import java.util.List;

/**
 *
 * Created by Alex on 25.03.14.
 */
public class TestPersonIO {

    Company c = Company.getInstance();

    @Test
    public void testSaveListIsNull() throws InvalidArgumentException {
        List<Employee> listOfEmp = null;
        String s = "d:\\Company\\Personnel.txt";
        try{
            PersonIO.save(listOfEmp, s);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testSaveFileIsNull() throws InvalidArgumentException {
        List<Employee> listOfEmp = c.createListEmpl();
        String s = null;
        try{
            PersonIO.save(listOfEmp,s);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testSaveReturnFalse() throws InvalidArgumentException {
        List<Employee> listOfEmp = c.createListEmpl();
        String s = "d:\\Company\\Personnel";
        Assert.assertFalse(PersonIO.save(listOfEmp, s));
    }

    @Test
    public void testSaveReturnTrue() throws InvalidArgumentException {
        List<Employee> listOfEmp = c.createListEmpl();
        String s = "d:\\Company\\Personnel.txt";
        Assert.assertTrue(PersonIO.save(listOfEmp, s));
    }

    @Test
    public void testLoadFileIsNull() throws InvalidArgumentException,ClassNotFoundException {
        String s = null;
        try {
            PersonIO.load(s);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testLoadReturnNull() throws InvalidArgumentException,ClassNotFoundException {
        String s = "d:\\Company\\Personnel";
        Assert.assertNull(PersonIO.load(s));
    }

    @Test
    public void testLoadReturnList() throws InvalidArgumentException,ClassNotFoundException {
        List<Employee> listActual = c.createListEmpl();
        String s = "d:\\Company\\Personnel.txt";
        List<Employee> listExpected = PersonIO.load(s);
        Assert.assertEquals(listExpected.getClass(),listActual.getClass());
    }
}
