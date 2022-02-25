import java.io.Serializable;
import java.util.ArrayList;
/**
 * The FundList class for the Budget Tracker program.
 * It is made of a list of all of a user's different Funds that they have created 
 * @author Cole Zandbergen
 * @version 12/1/20
 *
 */
public class FundList implements Serializable {
	/*
	 * Field for the main list of funds
	 */
	
	ArrayList<Fund> funds;
	
	/**
	 * Constructor Method for the FundList class
	 * @param loadData a string containing data from the save file relating to Funds
	 * 
	 */
	FundList()
	{
		funds = new ArrayList<Fund>();
	}
	
	/**
	 * method to move money from one fund to another 
	 * @param to the fund where the money will be moved to
	 * @param from the fund where the money will be taken from
	 * @param amount the amount of money to be moved
	 */
	public void moveMoney(Fund to, Fund from, double amount)
	{
		to.addMoney(amount); //add the amount to the fund that is receiving the money
		from.addMoney(-amount); //subtract the amount from the fund that is giving the money 
	}
	
	/**
	 * Adds a fund into the FundList
	 * @param newFund to add to funds
	 * @return whether adding the fund to the list was successful.  will not work if there are more than 20 funds
	 */
	public boolean addFund(Fund newFund)
	{
		if(funds.size() <= 20)
		{	
			funds.add(newFund);
			return true;
		}
		else
			return false;
	}
	
	/**
	 * Removes a specific fund from the fundList
	 * @param fundToRemove the Fund that will be removed from the list
	 */
	public void removeFund(Fund fundToRemove)
	{
		funds.remove(fundToRemove);
	}
	
	/**
	 * get function for the size of this list
	 * @return the size of this list
	 */
	public int getSize()
	{
		return funds.size();
	}
	
	/**
	 * this function returns the name of a fund at a specific location in the list
	 * @param i the index of the fund we are looking for
	 * @return the name of the fund at index i
	 */
	public String getName(int i)
	{
		if(i > -1 && i < funds.size())
		{
			return funds.get(i).getFundName();
		}
		else
		{
			return "Undefined fund";
		}
	}
        
        /**
         * this function returns what the save function needs to save.
         * @return a string with the information needed to save the state of the funds 
         */
	public String getFundString(){
            StringBuilder fundInfo = new StringBuilder();
        
            //loop for funds
            for(int i = 0; i < funds.size();i++){
                fundInfo.append(funds.get(i).getFundName()+";"+(funds.get(i).getTotal()*100));
                
                //for loop for purchases
                for(int j = 0; j < funds.get(i).getHistorySize();j++){
                    Purchase tempPur = funds.get(i).getPurchase(j);
                    fundInfo.append("|" + tempPur.getMemo()+";"+(tempPur.getAmount()*100));
                }
                
                if(i != funds.size()-1){
                    fundInfo.append("~");
                }
            }
        
            return fundInfo.toString();
        }
	
	
	/**
	 * returns the fund at the specified index in the fundlist
	 * @param index the index of the fund to be returned
	 * @return the fund at said index
	 */
	public Fund getFundFromIndex(int index)
	{
		return funds.get(index);
	}
	/**
	 * 
	 * @param fund
	 * @return
	 */
	public int getIndexFromFund(Fund fund)
	   {
	      for (int i = 0; i < funds.size(); i++) {
	         if (fund.getFundName().equals(funds.get(i).getFundName())) {
	            return i;
	         }
	         
	      }
	      return -1;
	   }

}