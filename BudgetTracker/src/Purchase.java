import java.io.Serializable;

/**
 * Purchases class defines the characteristics of a purchase in the
 * budget tracker. 
 * Purchase objects can also be created by the subclasses FuturePurchase
 * and ImmediatePurchase.
 * CS321 project
 *@author Dylan Maurel
 *@version 11/22/2020 - edited 11/25/20 by Cole Z.
 *                    - edited 11/26/20 by Dylan M.
 */
public class Purchase implements Serializable {
   
   
   //Fields
   private double amount;
   private String memo;
   private Fund fund; //added 11/25/20
   
   /**
    * Contructor for Purchase.
    *@param amountIn for amount
    *@param memoIn for memo
    *@param fund for the fund that this purchase will be taken out of -Cole Z. 11/25/20
    */
   public Purchase(double amountIn, String memoIn, Fund fund) {
      this.fund = fund; //added 11/25/20
      this.amount = amountIn;
      this.memo = memoIn;
   }
   
   /**
    * Getter for amount.
    *@return the value of amount
    */
   public double getAmount() {
      return amount;
   }
    
   /**
    * Setter for amount.
    *@param newAmount to replace amount
    */
   public void setAmount(double newAmount) {
      this.amount = newAmount;
   }

   /**
    * Getter for memo.
    *@return the String memo
    */
   public String getMemo() {
      return memo;
   }

   /**
    * Setter for memo.
    *@param newMemo to replace memo
    */
   public void setMemo(String newMemo) {
      this.memo = newMemo;
   }
   
   /**
    * Getter for fund.
    *@return the fund that the purchase belongs to.
    */
   public Fund getFund() {
      return fund;
   }
   
   /**
    * Setter for fund.
    *@param newFund for the new fund that the purchase belong to.
    */
   public void setFund(Fund newFund) {
      this.fund = newFund;
   }
    

   /**
    * This method is just used for testing purposes, not for
    * use within the budget tracker.
    *@return summary of object.
    */
   public String toString() {
      return "Amount: $" + amount + "\n" + "Memo: " + memo;
   }
   
   /**
	* This function will push a purchase into a fund's history.
   * This function will also update the fund's current total.
	* added 11/25/20 -Cole Z.
	*/
   public void execute()
   {
      fund.updateHistory(this);
   }
   
}