package com.hometask.testpr;

import com.hometask.precords.*;
import org.junit.Assert;
import org.junit.Test;

/**
 *
 * Created by Alex on 22.03.14.
 */
public class TestInitializer {

    @Test
    public void testEmployeeNumberIsNullOfEmpFixed(){
        String employeeNumber = null;
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double fixedPayment = 1000;
        try{
            Initializer.createEmpFixed(employeeNumber,
                    surname, dateOfBirth, fixedPayment);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testEmployeeNumberIsEmptyOfEmpHourly(){
        String employeeNumber = "";
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double hourlyRate = 10;
        try{
            Initializer.createEmpFixed( employeeNumber,
                    surname,dateOfBirth,hourlyRate);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testFixedPaymentOutBounds(){
        String employeeNumber = "number";
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double fixedPayment = 200;
        try{
            Initializer.createEmpFixed(employeeNumber,
                    surname, dateOfBirth, fixedPayment);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testHourlyRateOutBounds(){
        String employeeNumber = "number";
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double hourlyRate = 200;
        try{
            Initializer.createEmpHourly(employeeNumber,
                    surname, dateOfBirth, hourlyRate);
            Assert.fail("The input argument is invalid.\nShould have thrown a InvalidArgumentException");
        }catch (InvalidArgumentException iae){
            Assert.assertEquals("The input argument is invalid.",iae.getMessage());
        }
    }

    @Test
    public void testCreateEmpFixed() throws InvalidArgumentException {
        String employeeNumber = "num";
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double fixedPayment = 1000;
        EmployeeFixedSalary empActual = new EmployeeFixedSalary();
        Employee empExpected = Initializer.createEmpFixed(employeeNumber,
                surname, dateOfBirth, fixedPayment);
        Assert.assertSame(empExpected.getClass(), empActual.getClass());
    }

    @Test
    public void testCreateEmpHourly() throws InvalidArgumentException {
        String employeeNumber = "num";
        String surname = "Name";
        String dateOfBirth = "dateOfBirth";
        double hourlyRate = 10;
        EmployeeHourlyWages empActual = new EmployeeHourlyWages();
        Employee empExpected = Initializer.createEmpHourly(employeeNumber,
                surname, dateOfBirth, hourlyRate);
        Assert.assertSame(empExpected.getClass(), empActual.getClass());
    }
}




