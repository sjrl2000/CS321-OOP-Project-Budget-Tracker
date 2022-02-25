import java.io.Serializable;
import java.util.ArrayList;

/**
 * Fund class defines the characteristics of a fund that the user creates in the Budget tracker app.
 * @author Cole Zandbergen
 * @version 12/1/20
 */
public class Fund implements Serializable {
	/*
	 * Fields
	 */
	private String fundName; //the name of the fund
	private double currentTotal; //total amount of money in the fund
	ArrayList<Purchase> history; //list of purchases that have been taken out of the fund, stored as an arraylist
	
	/**
	 * Constructor method for Fund class
	 * @param name the name that the user enters for the fund when they create it
	 * @param startingToal the total that the user enters when they create the Fund
	 */
	Fund(String name, double startingTotal)
	{
		if(name.contains("\n") || name.contains("~") || name.contains(";") || name.contains(",") || name.contains("|"))
			fundName = "invalid name";
		else
			fundName = name;
		currentTotal = startingTotal;
		history = new ArrayList<Purchase>(); //create the history list
	}
	
	public Fund() {
		// TODO Auto-generated constructor stub
		this.history = new ArrayList<Purchase>();
	}


	/**
	 * getTotal method for the Fund class
	 * @return the value for currentTotal
	 */
	public double getTotal()
	{
		return currentTotal;
	}
	
	/**
	 * setTotal method for the Fund class
	 * changes the value for currentTotal
	 * @param newTotal the new total to set the currentTotal variable to
	 */
	public void setTotal(double newTotal)
	{
		currentTotal = newTotal;
	}
	
	/**
	 * method to add a certain amount of money into the fund
	 * @param amount the amount of money to be added
	 */
	public void addMoney(double amount)
	{
		currentTotal += amount;
	}
	
	/**
	 * the getFundName method for the Fund class
	 * @return the name of the fund
	 */
	public String getFundName()
	{
		return fundName;
	}
	
	/**
	 * the setFundName method for the Fund class
	 * @param newName the new name to name the Fund
	 */
	public void setFundName(String newName)
	{
		if(newName.contains("\n") || newName.contains("~") || newName.contains(";") || newName.contains(",") || newName.contains("|"))
		fundName = "Invalid Name";
	else
		fundName = newName;
	}
	
	/**
	 * the updateHistory method for the Fund class
	 * adds a purchase to the list whenever the user makes a purchase
	 * @param newPurchase the new Purchase object to add to the list
	 * 
	 */
	
	public void updateHistory(Purchase newPurchase)
	{
		history.add(0, newPurchase); // add the new purchase to the front of the list
		if(history.size() > 30) //delete the last item in the list once it has 30 items in it
			history.remove(history.size()-1);
		currentTotal -= newPurchase.getAmount();//take the money for the purchase out of the fund
	}
	
	/**
	 * this method will be used by the load function to populate the fund's history upon loading
	 * it does the same thing as updateHistory() except it does not take money out of the fund
	 * @param purchase the purchase to be added to the Fund's history
	 */
	public void writeToHistory(Purchase purchase)
	{
		history.add(0, purchase); // add the new purchase to the front of the list
		if(history.size() > 30) //delete the last item in the list once it has 30 items in it
			history.remove(history.size()-1);
	}
	
	/**
	 * this method returns a purchase from the fund's history
	 * @param index the index of the purchase
	 * @return the purchase at the specified index
	 */
	public Purchase getPurchase(int index)
	{
		return history.get(index);
	}
	
	/**
	 * this method returns the size of the history ArrayList
	 * @return the size of the history ArrayList
	 */
	public int getHistorySize()
	{
		return history.size();
	}
}