package com.hometask.precords;

import java.io.*;
import java.util.*;

public class PersonIO {

/**
 * Saves a list of Employee objects to a file
 *
 * @param listOfEmp the list of Employee objects to be stored in the file
 * @param fileName the name of the file in which to store the Employee objects
 * @return true if the Employee objects were successfully written to the file, or false
 * 		if an error occurred
 * @throws InvalidArgumentException if listOfEmp and/or fileName is null
 */

    public static boolean save(List<Employee> listOfEmp,String fileName)throws InvalidArgumentException {
        boolean b = false;
        if (listOfEmp == null || fileName == null)
            throw new InvalidArgumentException();
        else{
            File myFile = new File(fileName);
            if(myFile.exists()){
                System.out.println("The last modification:\t"
                        +new Date(myFile.lastModified()));
                try{
                    FileOutputStream fos = new FileOutputStream(myFile);
                    ObjectOutputStream oos = new ObjectOutputStream(fos);
                    for(Employee e:listOfEmp){
                        oos.writeObject(e);
                    }
                    fos.close();
                    oos.close();
                    b = true;
                }catch (IOException e){
                    System.out.println("Error in the file:\t"+e.getMessage());
                }
            }
            else
                System.out.println("File "+myFile.getName()+" does not exist.");
        }
        return b;
    }

    /**
     * Loads the Employee objects stored in the specified file and returns them in an list
     *
     * @param fileName the name of the file to be loaded
     * @return a list of Employee objects in the same order that they appear in the file.
     * If the file cannot be opened or the contents of the file are invalid, null is returned
     * @throws InvalidArgumentException if fileName is null
     */

    public static List<Employee> load(String fileName) throws InvalidArgumentException, ClassNotFoundException {
        List<Employee> listOfPerson =  new ArrayList<>();
        Employee emp;
        if(fileName == null)
            throw new InvalidArgumentException();
        else{
            File myFile = new File(fileName);
            if(myFile.exists()){
                System.out.println("The last modification:\t"
                        +new Date(myFile.lastModified()));
                try {
                    FileInputStream fis = new FileInputStream(myFile);
                    ObjectInputStream ois = new ObjectInputStream(fis);
                    int count = 0;
                    while ((emp = (Employee) ois.readObject())!=null) {
                        listOfPerson.add(count,emp);
                        count++;
                    }
                    fis.close();
                    ois.close();
                }catch(IOException e){
                    System.out.println("Error in the file:\t"+e.getMessage());
                }
            }else{
                System.out.println("File "+myFile.getName()+" does not exist.");
                listOfPerson = null;
            }
        }
        return listOfPerson;
    }
}
