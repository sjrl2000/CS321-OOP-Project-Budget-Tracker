import java.io.Serializable;
import java.time.LocalDate; 
import java.time.temporal.ChronoUnit;  
import java.time.format.DateTimeFormatter;
   /**
 * FuturePurchase class defines transactions that are scheduled
 * in advance. These kinds of purchases can be repeated or for
 * a single transaction. If the purchase is not repeated, then
 * the dateForPurchase field is the scheduled date of the purchase.
 * If the purchase is repeated, then the dateForPurchase field is
 * the date of the first purchase, and the subsequent purchases will
 * occur after each interval of days.
 *
 * CS321 project
 *@author Dylan Maurel
 *@version 11/22/2020 - edited 11/25/20 by Cole Z.
 *                      edited 11/26/20 by Dylan M.
 */
public class FuturePurchase extends Purchase implements Serializable {

   //Fields
   private boolean repeated;
   private int interval;  // The number of days between repeating purchases.
   private LocalDate dateForPurchase; // The scheduled date for a purchase. Or,
                                    // the first date for a repeating purchase.
   
   /**
    * Constructor for FuturePurchase.
    *
    *@param amountIn for amount.
    *@param memoIn for memo that describes the purchase.
    *@param repeatedIn to tell if it is a repeating purchase.
    *@param datePurchaseIn is the date of the purchase. If the
    * purchase is repeating, then this is the date of the first purchase.
    *@param intervalIn is the number of days between repeating purchases.
    * If the FuturePurchase is not repeated, then interval will be -1.
    */
   public FuturePurchase(double amountIn, String memoIn, Fund fund,
         boolean repeatedIn, int intervalIn, LocalDate datePurchaseIn) {
         //added Fund fund to the line above ^^ 11/25/20 -Cole Z.
      super(amountIn, memoIn, fund);
      repeated = repeatedIn;
      if (repeatedIn == true) {
         interval = intervalIn;
      }
      else {
         interval = -1;
      }
      
      dateForPurchase = datePurchaseIn;
   }
   
   
    /**
    * This method will determine if the purchase needs to be activated for
    * the date being checked. If so, then the execute() method will be
    * called, and the fund's history and current total will be updated.
    *
    *@return true if the purchase needs to be triggered, false otherwise
    *@param dateToCheck for the date being checked
    */
   public boolean triggerPurchase(LocalDate dateToCheck) {
     // Two cases must be covered: purchase is repeated or not repeated.
     
     // If the dates are equal, then a purchase must be triggered.
      if (dateForPurchase.equals(dateToCheck))
      {
         this.execute(); // This method will update the fund's history and
                         // current total. - added 11/26/20 Dylan M.
         return true;
      }
      if (repeated == true)
      {
         // If the dateToCheck is earlier than the dateForPurchase, then
         // there is no purchase scheduled for that date.
         if (dateToCheck.compareTo(dateForPurchase) < 0)
         {
            return false;
         }
         else
         {
            // daysBetween is the number of days between the two dates, which
            // will always be positive at this point in the algorithm.
            int daysBetween = (int) ChronoUnit.DAYS.between(dateForPurchase,
                                                             dateToCheck);
            // If the interval divides the number of daysBetween, then a 
            // purchase is scheduled.
            if ((daysBetween % interval) == 0)
            {
               this.execute();
               return true;
            }
         }
      }
      return false;
   }


   /**
    * Setter for interval.
    *@param intervalIn for the new interval
    */
   public void changeInterval(int intervalIn) {
      interval = intervalIn;
   }

   /**
    * Setter for repeated.
    *@param newState for the new value of repeated
    */
   public void changeRepeated(boolean newState) {
      repeated = newState;
      // If the purchase is not repeating, change interval to -1 since
      // the interval would no longer be needed.
      if (newState == false)
      {
         interval = -1;
      }
   }
    
    /**
    * Setter for dateForPurchase.
    *@param newDate for the new scheduled purchase date
    */
   public void changeDate(LocalDate newDate) {
      dateForPurchase = newDate;
   }
   
   /**
    * Getter for interval.
    *@return interval
    */
   public int getInterval() {
      return interval;
   }

   /**
    * Getter for dateForPurchase.
    *@return interval
    */
   public LocalDate getDateForPurchase() {
      return dateForPurchase;
   }
   
   /**
    * Getter for repeated.
    *@return repeated
    */
   public boolean getRepeated() {
      return repeated;
   }
    
    /**
    * This method is just used for testing purposes, not for
    * use within the budget tracker.
    *@return summary of object
    */
   public String toString() {
      String output = super.toString() + "\n"
                    + "Repeated: " + String.valueOf(repeated) + "\n" 
                    + "Interval (Days): " + interval + "\n" 
                    + "Date for Purchase: " 
         + dateForPurchase.format(DateTimeFormatter.ofPattern("MM/dd/yyyy"));
      return output;
   }

}
