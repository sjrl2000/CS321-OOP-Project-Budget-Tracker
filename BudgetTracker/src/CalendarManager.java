import java.io.Serializable;
import java.time.LocalDate;
import java.util.*;

/**
 * This class is the CalendarManager() that modifies and keep track of the Future Purchases of the Budget Tracker program.
 * @author Janilou Sy
 * 
 * Additional comments(delete when submitting):
 * 1) You can only run updateFuturePurchase if there are stuff inside the upcoming array list (stored in a file).
 * 		Else, it will throw an exception. 
 * 		Don't update it AGAIN if you just added a new purchase. addFuturePurchase() will trigger that purchase itself.	
 * 2) I added 3 new methods: setCurrentDate(), setLastChecked(), updateFuturePurchase(), and printAll().
 */

public class CalendarManager implements Serializable {

	//Instance Variables
	private LocalDate lastDateChecked;					 //Must be stored in a file.
	private LocalDate currentDate;
	private ArrayList <FuturePurchase> upcoming;		 //Must be stored in a file.
	
	/**
	 * This is a constructor for the CalendarManager.
	 * @param lastDateChecked the LocalDate variable that has the last date when it was checked. 
	 * @param currentDate the LocalDate variable that has the current date.
	 * @param upcoming the array list of future purchases.
	 */
	public CalendarManager(LocalDate lastDateChecked, LocalDate currentDate,
			ArrayList <FuturePurchase> upcoming){
		this.lastDateChecked = lastDateChecked;						//Must be stored in a file.
		this.currentDate = currentDate;
		this.upcoming = new ArrayList <FuturePurchase>(upcoming);	//Must be stored in a file.
	}
        
        public CalendarManager(){
        this.upcoming=new ArrayList<FuturePurchase>();
        }
	
	/**
	 * This is the method for getCurrentDate().
	 * @return currentDate which is the current date when opened.
	 */
	public LocalDate getCurrentDate(){
		return currentDate;
	}
	/**
	 * This is the method for setCurrentDate(LocalDate currentDate) that sets the current date to the given value in the parameter.
	 */
	public void setCurrentDate(LocalDate currentDate){
		this.currentDate = currentDate;
	}
	
	/**
	 * This is the method for delCurrentDate() that sets the current date to null.
	 */
	public void delCurrentDate(){
		currentDate = null;
	}
	
	/**
	 * This is the method for getLastCheck().
	 * @return lastDateChecked which is the last date when it was checked.
	 */
	public LocalDate getLastChecked(){
		return lastDateChecked;
	}
	
	/**
	 * This is the method for setLastChecked(LocalDate lastDateChecked) that sets the lastDateChecked to the given value in the parameter.
	 */
	public void setLastChecked(LocalDate lastDateChecked){
		this.lastDateChecked = lastDateChecked;
	}
	
	/**
	 * This is the method for changeLastChecked() which changes the last date checked by incrementing a day.
	 */
	public void changeLastChecked(){
		LocalDate nextDate = lastDateChecked.plusDays(1);
		
		//Checks if the nextLastDate is less than or equal to current date.
		if (nextDate.isBefore(currentDate) == true || nextDate.isEqual(currentDate) == true){
			lastDateChecked = nextDate;					//Set the lastDateChecked to the nextLastDate.
		}
	}
	
	/**
	 * This is the method for deleteFutPurchase() which will read through the future purchase array list
	 * and remove non-repeating Future purchase.
	 */
	public void delFuturePurchase(){
		FuturePurchase toCheck;									//The FuturePurchase to be deleted.
		int lastIndex = upcoming.size() - 1;					//The index of the last element.
		int elementIndex = 0;									//The index to iterate.
		
		//While it still has not reached the end of the array list
		while (elementIndex <= lastIndex){	
			toCheck = upcoming.get(elementIndex);		//Sets the an element from upcoming to toCheck	
			
			//Checks if the toCheck is a non-repeating purchase
			if(toCheck.getRepeated() == false){
				upcoming.remove(elementIndex); 			//Remove it from the array list
			
				lastIndex = upcoming.size() - 1; 		//Changes to the new size.
			} else elementIndex++;						//Moves to the next index of the array list.
		}		
	}
	
	/**
	 * This is the method for cancelFuturePurchase(FuturePurchase cancelPurchase) which removes 
	 * a future purchase from the future purchase array list.
	 */
	public void cancelFuturePurchase(FuturePurchase cancelPurchase){
		//Check if cancelPurchase is within upcoming
		if (upcoming.contains(cancelPurchase) == true){
			upcoming.remove(cancelPurchase);			//Remove cancelPurchase from the array list
		}
		
	}
	
	/**
	 * This is the method for addFuturePurchase(FuturePurchase newPurchase) which updates the future purchases array list
	 * and make changes to its fund if applicable.
	 * @param newPurchase which is the repeating purchase to add to the array list.
	 */
	public void addFuturePurchase(FuturePurchase newPurchase){
		LocalDate newPurchDate = newPurchase.getDateForPurchase();		//The date of the newPurchase.
	
		//Check if repeated is true and interval not equal to zero; If its a repeating purchase.
		if ((newPurchase.getRepeated() == true) && (newPurchase.getInterval() != 0) ){
			upcoming.add(newPurchase);					//Adds new FuturePurchase to the array list
			newPurchase.triggerPurchase(newPurchDate);	//Checks for trigger purchase 
		}
	}
	
	/**
	 * This is the method for updateFuturePurchase() that updates the future purchases if there is a transaction to be made.
	 * This checks it from the day after the lastDateChecked until current date.
	 */
	public void updateFuturePurchase(){
		FuturePurchase toCheck = upcoming.get(0);				//The FuturePurchase to be checked.
		lastDateChecked = lastDateChecked.plusDays(1);			//Increments the lastDateChecked to the next day.
		int lastIndex = upcoming.size() - 1;					//The index of the last element.
		int nextIndex = 0;										//The index to increment.
		
		
		//While the next date to check is before the current, or is equal to the current
		while (lastDateChecked.isBefore(currentDate) == true||lastDateChecked.isEqual(currentDate) == true){
			toCheck.triggerPurchase(lastDateChecked);			//Checks for trigger purchase
			
			//Check if toCheck is the last element array list			
			if(nextIndex == lastIndex){
				lastDateChecked = lastDateChecked.plusDays(1);		//Move on to the next day
				toCheck = upcoming.get(0);							//Go back to the top of the list
				nextIndex = 0;
			}		
			else{
				nextIndex++;						//Move on to the next repeating purchase
				toCheck = upcoming.get(nextIndex);
			}
		}
		//At this point all has been checked until the current date
		lastDateChecked = currentDate;		//Updates the lastDateChecked; Must be stored in a file.
		
	}
	/**
	 * This is the printAll() method that prints all information stored by the object. This is for debugging purposes only.
	 */
	public void printAll(){
		System.out.println("---------------------------------------");
		System.out.println("Last Date Checked: " + lastDateChecked);
		System.out.println("Current Date: " + currentDate);
		System.out.println("These are the contents of Future Purchase:");
		for (int i = 0 ; i < upcoming.size() - 1; i++){
			System.out.println(upcoming.get(i).toString());
			System.out.println("This is total of fund: $" + upcoming.get(i).getFund().getTotal() +"\n");
		}
		System.out.println("Size of array: " + upcoming.size() + "\n");
		System.out.println("---------------------------------------");
	}
	
        String getCalString (){
            StringBuilder calInfo = new StringBuilder();
            
            for (int i = 0; i < upcoming.size();i++){
                if(i!=0){
                    calInfo.append("|");  
                }
                calInfo.append(upcoming.get(i).getAmount()*100+";");
                calInfo.append(upcoming.get(i).getMemo()+";");
                calInfo.append(upcoming.get(i).getFund().getFundName()+";");
                int binaryAnswer = upcoming.get(i).getRepeated()?1:0;
                
                calInfo.append(binaryAnswer+";");
                calInfo.append(upcoming.get(i).getInterval() +";");
                calInfo.append(upcoming.get(i).getDateForPurchase().toString());
                
            }
            
            
            return calInfo.toString();
        }
}
