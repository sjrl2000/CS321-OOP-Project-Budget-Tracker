import java.io.Serializable;

/**
 * ImmediatePurchase class defines the characteristics of a purchase that needs
 * to automatically be executed during the moment it is created.
 *
 * CS321 project
 *@author Dylan Maurel
 *@version 11/26/2020
 *                   
 */
public class ImmediatePurchase extends Purchase implements Serializable {

   ImmediatePurchase(double amountIn, String memoIn, Fund fund) {
      super(amountIn, memoIn, fund);
      this.execute(); 
   }
}