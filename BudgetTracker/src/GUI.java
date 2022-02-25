//Imports required
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.lang.Double;
import java.lang.Integer;
import java.time.LocalDate;
//import java.time.temporal.ChronoUnit;  
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;

/**
 * The GUI Class for the Budget Tracker Program
 * Implements Class Fund, FundList, Purchase, ImmediatePurchase, FuturePurchase, Calendar & SaveManager
 * for all of them to work together and output for a User
 * @author Sebastian Rivera
 * @version 12/02/2020
 */

public class GUI implements ActionListener {
	
	//Variables
	//Frames
	private JFrame frame;//Main Window
	private JFrame frame2;//Add Funds Window
	private JFrame frame3;//View Funds Window
	private JFrame frame4;//Information Window
	private JFrame frame5;//Add Purchase Window
	private JFrame frames[];//Multiple frames for 20 funds
	//private JFrame historyData;//Displays history of Funds/Purchases
	
	
	//Panels
	private JPanel panel;//Main Panel 1st Window
	private JPanel panel2;//Add Funds Panel 2nd Window
	private JPanel panel3;//View Funds Panel 3rd Window
	private JPanel panel4;//Information Panel 4th Window
	private JPanel panel5;//Add Purchase Panel 5th Window
	private JPanel panels[];//Panels for the frames 20 panels
	//private JPanel historyDisplay;//Panel that displays History
	
	//Labels
	private JLabel label;//First Greeter
	private JLabel label2;//Second Greeter
	private JLabel label3;//Third Greeter
	private JLabel label4;//Fourth Greeter
	private JLabel label5;//Fifth Greeter
	private JLabel userin;//User Input-1 (Name Fund)
	private JLabel userin2;//User Input-2 (Recurring Purchase)
	private JLabel userin3;//User Input-3 (IF Recurring Enter Date)
	private JLabel userin4;//User Input-4 (Amount)
	private JLabel userin5;//User Input-5 (Select Fund to Add Purchase)
	private JLabel userin6;//User Input-6 (Enter Purchase Amount)
	private JLabel userin7;//User Input-7 (Interval Option)
	private JLabel labels[];//LABELS FOR FUNDS
	private JLabel amountOfMoney[];//Amount of Money
	private JLabel changeName[];//Change Name of Selected Fund
	private JLabel transferMoneyName[];//Transfer Money to Selected Fund
	private JLabel transferMoneyAmount[];//Transfer Money to Selected Fund
	private JLabel addMoneyFund[];//Add Money Label
	//private JLabel historyInfo;
	
	
	//Buttons
	private JButton button;//Add Funds
	private JButton button2;//Manage Funds
	private JButton button3;//Information
	private JButton button4;//Save Button For Add Funds Page
	private JButton button5;//Save Button For Manage Funds Page
	private JButton button6;//Exit/Go Back for INFOMATION PAGE
	private JButton button7;//Add Purchase(s)
	private JButton button8;//Save Button for Add Purchase Page
	private JButton[] buttons;//View Funds Page <20
	//private JButton[] buttonsFunds;//Add Money Button
	private JButton[] buttonsExit;//Exit Button
	private JButton[] buttonsSave;//Save Buttons
	private JButton[] buttonsUpdateHistory;//Updates Fund History
	//private JButton historyGo;//Opens History Page
	//private JButton historyExit;//Exits History Page
	
	//TextFields
	private JTextField userText;//Name Fund
	private JTextField userText2;//Enter IF Recurring
	private JTextField userText3;//Enter Date
	private JTextField userText4;//Enter Amount
	private JTextField userText5;//Enter Fund Name
	private JTextField userText6;//Enter Purchase Amount
	private JTextField userText7;//Interval Option (Days)
	private JTextField[] userTextsNewName;//Input For a New Name
	private JTextField[] userTextsAddMoney;//Input For Adding Money
	private JTextField[] transferFundName;//Enter Fund Name to begin money transfer
	private JTextField[] transferFundAmount;//Enter Fund amount for transfer
	
	//FundList
	private FundList fundList;
	
	//Calendar
	private CalendarManager calendarManager;
	
	//SaveManager
	private SaveManager saveManager;
	
	
	//Method that makes new GUI object
public GUI(){
	
	/**
	 * Initialization of all required variables for
	 * Frames
	 * Panels
	 * Labels
	 * Buttons
	 * TextFields
	 * 
	 */

	//FundList
    saveManager = new SaveManager();
    fundList = saveManager.loadFund();
    calendarManager = saveManager.loadCal();
    System.out.print(fundList.getName(0));
	
	//Frames up the window of application
	frame = new JFrame();//Main Page
	frame2= new JFrame();//Add Funds Page
	frame3= new JFrame();//Manage Funds Page
	frame4= new JFrame();//Information Page
	frame5 = new JFrame();//Add Purchase Page
	frames = new JFrame[20];//Frames that Build Funds Pages
	//historyData = new JFrame();//History 
	
	//Text Fields
	userText = new JTextField();//Name Fund
	userText2 = new JTextField();//Enter IF Recurring
	userText3 = new JTextField();//Enter Date
	userText4 = new JTextField();//Enter Amount
	userText5 = new JTextField();//Enter Fund Name
	userText6 = new JTextField();//Enter Purchase Amount
	userText7 = new JTextField();//Enter Interval
	userTextsNewName = new JTextField[20];//Enter New Name For A Fund
	userTextsAddMoney = new JTextField[20];//Add Money to Fund
	transferFundName = new JTextField[20];//Enter Fund Name to transfer to
	transferFundAmount = new JTextField[20];//Enter Transfer Amount
	
	//Button(s) for the panel
	//Button-1 (Opens - Add Funds)
	button = new JButton("Add New Fund");
	button.addActionListener(this);
	
	//Button-2 (Opens - Manage Funds)
	button2 = new JButton("View Funds");
	button2.addActionListener(this);
	
	//Button-3 (Opens - Information)
	button3 = new JButton("Save");
	button3.addActionListener(this);
	
	//Button-4 Save (FOR ADD FUNDS PAGE)
	button4 = new JButton("Confirm");
	button4.addActionListener(this);
	
	//Button-5 Save (FOR MANAGE FUNDS PAGE)
	button5 = new JButton("Confirm");
	button5.addActionListener(this);
	
	//Button-6 Exit/Go Back (FOR INFORMATION PAGE)
	button6 = new JButton("Exit");
	button6.addActionListener(this);
	
	//Button-7 (Opens - Add Purchase)
	button7 = new JButton("Add Purchase");
	button7.addActionListener(this);
	
	//Button-8 Confirm (FOR ADD PURCHASE PAGE)
	button8 = new JButton("Confirm");
	button8.addActionListener(this);
	
	//Buttons (Populates View Funds Page)
	buttons = new JButton[20];
	
	//ButtonsFunds (Populates Funds)
	//buttonsFunds = new JButton[20];
	
	//ButtonsSave (Populates Save Buttons in Funds Page)
	buttonsSave = new JButton[20];
	
	//ButtonsExit (Populates Exit Buttons in Funds Page)
	buttonsExit = new JButton[20];
	
	//Buttons Update History (Populates with Update History Buttons)
	buttonsUpdateHistory = new JButton[20];
	
	//HistoryGo/HistoryExit
	//historyGo = new JButton("History");
	//historyExit = new JButton("Exit");
	
	//Label(s) for the panels
	label = new JLabel("Hello! Welcome to your Budget Tracker: Click Add Funds to add a Fund; Click Add Purchase to add a purchase to an already existing Fund.");//Main Label
	JLabel info = new JLabel("Click View Funds to view created funds; Click Save to save current fund information.");
	label2 = new JLabel("You may add new funds here!");//Frame 2 ADD FUNDS
	label3 = new JLabel("You may manage your funds here!");//Frame 3 MANAGE FUNDS
	label4 = new JLabel("You may view your information here!");//Frame 4 INFORMATION
	label5 = new JLabel("You may add a purchase here!");//Frame 5 Add Purchase
	userin = new JLabel("Name Fund: ");
	userin2 = new JLabel("Enter Memo For Purchase: ");
	userin3 = new JLabel("if Recurring, Select Starting Date (MM/DD/YYYY): ");
	userin4 = new JLabel("Enter Fund Amount: ");
	userin5 = new JLabel("Enter Fund Name to Add a Purchase: ");
	userin6 = new JLabel("Enter Purchase Amount: ");
	userin7 = new JLabel("IF Recurring enter the Interval for a Purchase (Days): ");
	labels = new JLabel[20];//Labels that populate and Display Fund Name:
	amountOfMoney = new JLabel[20];//Populates and displays Fund Amount
	changeName = new JLabel[20];//Populates with Change Name and Below a Text Box
	transferMoneyName = new JLabel[20];//Populates with Transfer Money Name label
	transferMoneyAmount = new JLabel[20];//Populates with Transfer Money Amount
	addMoneyFund = new JLabel[20];//Populates with Add Money Labels
	//historyInfo = new JLabel(" ");
	
	
	//Panel for the window application
	//Panel-1
	panel = new JPanel();
	panel.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
	panel.setLayout(new GridLayout(0,1));
	panel.add(label);
	panel.add(info);
	panel.add(button);
	panel.add(button2);
	panel.add(button7);
	//panel.add(historyGo);
	panel.add(button3);
	
	//Panel-2 - ADD FUNDS
	panel2 = new JPanel();
	panel2.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
	panel2.setLayout(new GridLayout(0,1));
	panel2.add(label2);
	panel2.add(userin);
	panel2.add(userText);
	panel2.add(userin4);
	panel2.add(userText4);
	panel2.add(button4);
	
	//Panel-3 - VIEW FUNDS
	panel3 = new JPanel();
	panel3.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
	panel3.setLayout(new GridLayout(0,1));
	panel3.add(label3);
	//FundList fundList = new FundList();
	//FOR LOOP THAT ADDS TWENTY BUTTONS TO VIEW FUNDS PAGE
	for(int i = 0; i < 20; i++) 
		{
         buttons[i] = new JButton(String.valueOf(""));//Creates an empty space in each button 
         buttons[i].addActionListener(this);//Adds functionality to the button
         panel3.add(buttons[i]); 
         buttons[i].setVisible(true);
		}
	panel3.add(button5);
	
	//Panel-4 - INFORMATION
	panel4 = new JPanel();
	panel4.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
	panel4.setLayout(new GridLayout(0,1));
	panel4.add(label4);
	panel4.add(button6);
	
	//Panel-5 - ADD PURCHASE
	panel5 = new JPanel();
	panel5.setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
	panel5.setLayout(new GridLayout(0,1));
	panel5.add(label5);
	panel5.add(userin5);
	panel5.add(userText5);
	panel5.add(userin6);
	panel5.add(userText6);
	panel5.add(userin2);
	panel5.add(userText2);
	panel5.add(userin3);
	panel5.add(userText3);
	panel5.add(userin7);
	panel5.add(userText7);
	
	panel5.add(button8);
	
	//Panels - For View Funds Page
	panels = new JPanel[20];
	for (int i = 0; i < 20; i++) {
		labels[i]= new JLabel("Fund Name: ");
		amountOfMoney[i] = new JLabel("Amount of Money: ");
		changeName[i] = new JLabel("Change Name: ");
		transferMoneyName[i] = new JLabel("Enter Fund Name to Transfer Money to:");
		transferMoneyAmount[i] = new JLabel("Enter Amount of Money to transfer: ");
		addMoneyFund[i] = new JLabel("Enter Amount of money to Add to current Fund: ");
	    panels[i]= new JPanel();
		panels[i].setBorder(BorderFactory.createEmptyBorder(100,100,50,100));
		panels[i].setLayout(new GridLayout(0,1));
		panels[i].add(labels[i]);
		panels[i].add(amountOfMoney[i]);
		panels[i].add(changeName[i]);
		
			userTextsNewName[i] = new JTextField ("");
			panels[i].add(userTextsNewName[i]);
		
		panels[i].add(transferMoneyName[i]);
		
			transferFundName[i] = new JTextField ("");
			panels[i].add(transferFundName[i]);
			
		
		panels[i].add(transferMoneyAmount[i]);
		
			transferFundAmount[i] = new JTextField("");
			panels[i].add(transferFundAmount[i]);
		
		panels[i].add(addMoneyFund[i]);
		
			userTextsAddMoney[i] = new JTextField ("");
			panels[i].add(userTextsAddMoney[i]);
		
		//buttonsFunds[i] = new JButton(String.valueOf("Add Money"));//Creates an empty space in each button 
        //buttonsFunds[i].addActionListener(this);//Adds functionality to the button
        buttonsUpdateHistory[i] = new JButton(String.valueOf("Update History after Save"));//Creates an empty space in each button 
        buttonsUpdateHistory[i].addActionListener(this);//Adds functionality to the button
        buttonsSave[i] = new JButton(String.valueOf("Confirm"));//Creates an empty space in each button 
        buttonsSave[i].addActionListener(this);//Adds functionality to the button
        buttonsExit[i] = new JButton(String.valueOf("Exit"));//Creates an empty space in each button 
        buttonsExit[i].addActionListener(this);//Adds functionality to the button
        //panels[i].add(buttonsFunds[i]); 
        panels[i].add(buttonsUpdateHistory[i]);
        panels[i].add(buttonsSave[i]);
        panels[i].add(buttonsExit[i]);
	}
	
	//HistoryDisplay
	//historyDisplay = new JPanel();
	//historyDisplay.add(historyInfo);
	//historyDisplay.add(historyExit);
	
	
	
	//Frame-1 (Main Page/Greeting Page)
	frame.add(panel, BorderLayout.CENTER);//adds panel to frame
	frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
	frame.setTitle("Budget Tracker 1.0");//sets the title for the frame
	frame.pack();//sets window to match a certain size
	frame.setVisible(true);//sets the window to be visible and in focus
	
	//Frame-2 (Add Funds Page)
	frame2.add(panel2, BorderLayout.CENTER);//adds panel to frame
	//frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
	frame2.setTitle("Add New Funds");//sets the title for the frame
	frame2.pack();//sets window to match a certain size
	frame2.setVisible(false);//sets the window to be visible and in focus
	
	//Frame-3 (View Funds Page)
	frame3.add(panel3, BorderLayout.CENTER);//adds panel to frame
	//frame3.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
	frame3.setTitle("View Funds");//sets the title for the frame
	frame3.pack();//sets window to match a certain size
	frame3.setVisible(false);//sets the window to be visible and in focus
	
	//Frame-4 (Information)
	frame4.add(panel4, BorderLayout.CENTER);//adds panel to frame
	//frame4.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
	frame4.setTitle("Information");//sets the title for the frame
	frame4.pack();//sets window to match a certain size
	frame4.setVisible(false);//sets the window to be visible and in focus
	
	//Frame-5 (Add Purchase Page)
	frame5.add(panel5, BorderLayout.CENTER);//adds panel to frame
	//frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
	frame5.setTitle("Add Purchase");//sets the title for the frame
	frame5.pack();//sets window to match a certain size
	frame5.setVisible(false);//sets the window to be visible and in focus

	//Frames (Manage Funds Frames)
	 for(int i = 0; i < 20; i++) { 
		 frames[i] = new JFrame();
         frames[i].add(panels[i],BorderLayout.CENTER);//adds panel to frame
         frames[i].setTitle("Fund Manager");//sets the title for the frame
     	 frames[i].pack();//sets window to match a certain size
     	 frames[i].setVisible(false);//sets the window to be visible and in focus
     }
	/*History
		historyData.add(historyDisplay, BorderLayout.CENTER);//adds panel to frame
		//frame5.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//sets what happens once frame is closed
		historyData.setTitle("History");//sets the title for the frame
		historyData.pack();//sets window to match a certain size
		historyData.setVisible(false);//sets the window to be visible and in focus
	 */
}
	public static void main(String[] args) {
		//Sets up new constructor for GUI/ brings up the window
		new GUI();
	}
	/**
	 * Function for multiple buttons to be clicked and open new tabs/change information/exit
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()== button)
		{
			frame2.setVisible(true);//SETS ADD FUNDS PAGE VISIBLE
		}
		if(e.getSource()== button2)
		{
			frame3.setVisible(true);//SETS MANAGE FUNDS PAGE VISIBLE
		}
		if(e.getSource()== button3)
		{
			saveManager = new SaveManager();
			
			saveManager.save(fundList, calendarManager);
			
			frame4.setVisible(false);//SETS Save page invisible
		}
		if(e.getSource()== button4)
		{
			
			if(!userText.getText().isBlank() && !userText4.getText().isBlank()){
				Fund fund = new Fund();
				fund.setFundName(userText.getText());
				fund.setTotal(Double.parseDouble(userText4.getText()));
				fundList.addFund(fund);
				buttons[fundList.getSize()-1].setText(fund.getFundName());
				labels[fundList.getSize()-1].setText(fund.getFundName());
				amountOfMoney[fundList.getSize()-1].setText(String.valueOf("$ "+fund.getTotal()));
				frame2.setVisible(false);
				userText.setText("");
				userText4.setText("");
			}
		}
		if(e.getSource()== button5)
		{
			frame3.setVisible(false);
		}
		if(e.getSource()== button6)
		{
			frame4.setVisible(false);//CLOSES/HIDES INFORMATION TAB
		}
		if(e.getSource()== button7)
		{
			frame5.setVisible(true);//SETS ADD PURCHASE PAGE VISIBLE
		}
		
		//CreatePurchase
		if(e.getSource()== button8)
		{
			
			//Check if it has enough to do any kind of purchase
	         if(!userText5.getText().equals("") && !userText6.getText().equals("") && !userText2.getText().equals("") ) {
	            Fund found = null;
	            for (int f = 0; f<fundList.getSize();f++){
	               if (fundList.getName(f).equals(userText5.getText())){
	                  found = fundList.getFundFromIndex(f);
	               }
	            }
	            double amount =0;
	         	
	            try {
	               amount = Double.parseDouble(userText6.getText());
	               	 
	            }catch(NumberFormatException n) {
	               	 
	            }
	            if(found != null) {
	            	
	            	//If Repeating
	               if(!userText3.getText().equals("") && !userText7.getText().equals("")) {
	               	
	                  int interval =0;
	                  try {
	                     amount = Double.parseDouble(userText6.getText()); 
	                  }catch(NumberFormatException n) {
	                        	 
	                  }
	               	
	                  LocalDate date = LocalDate.now();
	                  try {
	                     date = LocalDate.parse(userText3.getText(), DateTimeFormatter.ofPattern("MM/dd/yyyy"));
	                  }catch(DateTimeParseException p) {
	                  	
	                  }
	                  interval = Integer.parseInt(userText7.getText());
	                  calendarManager.addFuturePurchase(new FuturePurchase(amount, userText2.getText(),found,true,interval,date));
	               	
	               //One time
	               }else {
	                  new ImmediatePurchase(amount, userText2.getText(),found);
	               }
	               amountOfMoney[fundList.getSize()-1].setText(String.valueOf("$"+found.getTotal()));
	               frame5.setVisible(false);
	            }
	            userText5.setText("");
	            userText6.setText("");
	            userText2.setText("");
	            userText3.setText("");
	            userText7.setText("");
	         }
	      	


			
			//TODO Save Function AFTER View FUND
			
			
		}
		for(int i = 0; i < 20; i++)
		{
			if(e.getSource() == buttons[i] )
			{
				frames[i].setVisible(true);//SETS VIEW FUNDS PAGE VISIBLE
			}
		}
		for(int i = 0; i < 20; i++)
		{
			if(e.getSource() == buttonsExit[i] )
			{
				frames[i].setVisible(false);//SETS VIEW FUNDS PAGE NONVISIBLE
			}
		}
		for(int i = 0; i < 20; i++)
		{
			if(e.getSource() == buttonsSave[i] )//Confirm Button in Fund Manager Page
			{
				if(!userTextsNewName[i].getText().isBlank())
				{
					Fund fund = fundList.getFundFromIndex(i);
				    fund.setFundName(userTextsNewName[i].getText());
				    buttons[i].setText(fund.getFundName());
				    labels[i].setText(fund.getFundName());
					userTextsNewName[i].setText("");
				}
				if(!transferFundName[i].getText().isBlank() && !transferFundAmount[i].getText().isBlank()){
					Fund fund = fundList.getFundFromIndex(i);
					Fund found = null;
                     for (int f = 0; f<fundList.getSize();f++){
                         if (fundList.getName(f).equals(transferFundName[i].getText())){
                             found = fundList.getFundFromIndex(f);
                         }
                     }
                     
                     double amount = 0;
                     try {
                    	 amount = Double.parseDouble(transferFundAmount[i].getText());
                    	 
                     }catch(NumberFormatException n) {
                    	 
                     }

                    if(found!=null && amount != 0)
                    {	
                    fundList.moveMoney(found, fund, amount);                    
                    try {
                    	amountOfMoney[fundList.getIndexFromFund(found)].setText(String.valueOf("$"+found.getTotal()));
                    	}
                    	catch (IndexOutOfBoundsException a) {

                    	}
					amountOfMoney[i++].setText(String.valueOf("$ "+fund.getTotal()));
					transferFundName[i].setText("");
					transferFundAmount[i].setText("");
                    }
				}
				
				
				//TODO Add Money to Selected Fund
				if(!userTextsAddMoney[i].getText().isBlank())
				{
				Fund fund = fundList.getFundFromIndex(i);
				fund.addMoney(Double.parseDouble(userTextsAddMoney[i].getText()));
				amountOfMoney[i].setText(String.valueOf("$ "+fund.getTotal()));
				userTextsAddMoney[i].setText("");
				}
				
		}
	}
		for(int i = 0; i < 20; i++)
		{
			if(e.getSource() == buttonsUpdateHistory[i] )
			{
				Fund fund = fundList.getFundFromIndex(i);
				buttons[i].setText(fund.getFundName());
				labels[i].setText(fund.getFundName());
				amountOfMoney[fundList.getSize()-1].setText(String.valueOf("$ "+fund.getTotal()));
			}
		}
		/*if (e.getSource()==historyGo)
		{
			historyData.setVisible(true);
		}*/
	    
	}
}