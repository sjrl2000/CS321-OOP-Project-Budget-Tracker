/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
//package TesterForSaveManager;

import java.io.*;
import java.nio.file.Files;
import java.time.LocalDate;
import java.lang.Double;
import java.lang.Integer;
import java.lang.StringBuilder;
import java.time.Month;
//import java.io.

/**
 * The object responsible for saving and restoring the files used by the application
 * It does this through the use of the serialize function.
 * 
 * @author Joseph Cherry
 */
public class SaveManager {
    
	static String listFileName = "fileList.ser";
	static String calFileName = "calendarfile.ser";
    /**
     * A function to load fundList from a file.
     * @return Either the loaded fundList, if it was successfully loaded, or an empty one.
     */
    public FundList loadFund() {
    	FundList list = new FundList();
    	try
        {    
            // Reading list from a file 
            FileInputStream file = new FileInputStream(listFileName); 
            ObjectInputStream fileIn = new ObjectInputStream(file); 
            list = (FundList)fileIn.readObject(); 
            fileIn.close(); 
            file.close();  
            
            /*
            // Reading the calendar from a file 
            FileInputStream calFile = new FileInputStream(calFileName);; 
            ObjectInputStream calIn = new ObjectInputStream(calFile); 
            cal = (CalendarManager)calIn.readObject();               
            calIn.close(); 
            file.close(); 
            */
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught");
            
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
            
        }
    	return list;
    	
    }
    

    /**
     * A function to load calendar from a file.
     * @return Either the loaded calendar, if it was successfully loaded, or an empty one.
     */
    public CalendarManager loadCal() {
    	CalendarManager cal = new CalendarManager();
    	try
        {    
            
            // Reading the calendar from a file 
            FileInputStream calFile = new FileInputStream(calFileName);; 
            ObjectInputStream calIn = new ObjectInputStream(calFile); 
            cal = (CalendarManager)calIn.readObject();               
            calIn.close(); 
            calFile.close(); 
            
        } 
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught");
            
        } 
          
        catch(ClassNotFoundException ex) 
        { 
            System.out.println("ClassNotFoundException is caught"); 
            
        }
    	return cal;
    	
    }
    
    
    
    /**
     * Saves the fundList object and the CalendarManager Object
     * 
     * @param list the fundlist object you want to save.
     * @param cal the CalendarManager object you want to save.
     */
    void save (FundList list, CalendarManager cal){
    	try
        {    
            //Saving of fundList in a file 
            FileOutputStream listFile = new FileOutputStream(listFileName); 
            ObjectOutputStream fileOut = new ObjectOutputStream(listFile); 
              
            // Method for serialization of object 
            fileOut.writeObject(list); 
              
            fileOut.close(); 
            listFile.close(); 
            
          //Saving of calendar in a file 
            listFile = new FileOutputStream(calFileName); 
            fileOut = new ObjectOutputStream(listFile); 
              
            // Method for serialization of object 
            fileOut.writeObject(cal); 
              
            fileOut.close(); 
            listFile.close(); 
            
  
        } catch (NotSerializableException e) {
        	System.out.println("Not Serializable"); 
        }
          
        catch(IOException ex) 
        { 
            System.out.println("IOException is caught"); 
        } 
    	
    	
    	
    }
    
    
}
