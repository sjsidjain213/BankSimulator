import java.awt.*;

import javax.swing.*;

import java.sql.*;
import java.awt.event.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.*;
public class Bank implements ActionListener,KeyListener{
	
JInternalFrame jifopen,jifclose,jifdeposit,jifwithdraw;
JDesktopPane jdesktop;
JFrame jf;
JMenuBar jmb;
JMenu jmacc,jmtrans;
JMenuItem jmiopen,jmiclose,jmideposit,jmiwithdraw,jmiexit;

JDialog jopen;
JPanel jpo1,jpo2;
JLabel jol,jolacc,jolname,jolamount;
JButton osave,ocancel,oclose;
JTextField jtfn,jtfa;

JDialog jclose;
JPanel jpc1,jpc2;
JLabel jclaccno,jclname,jclnameauto,jclbalance,jclbalanceauto;
JButton csave,ccancel,cclose;
JTextField jtfaccc;

JDialog jdeposit;
JPanel jpd1,jpd2;
JLabel jldaccno,jldname,jldbalance,jldamount,jldnameauto,jldbalanceauto;
JTextField jtfdaccno,jtfdamount;
JButton jbdupdate,jbdcancel,jbdclose;

JDialog jwithdraw;
JPanel jpw1,jpw2;
JLabel jlwaccno,jlwname,jlwbalance,jlwamount,jlwnameauto,jlwbalanceauto;
JTextField jtfwaccno,jtfwamount;
JButton jbwwithdraw,jbwcancel,jbwclose;

Bank()  throws ClassNotFoundException,SQLException
{	Class.forName("sun.jdbc.odbc.JdbcOdbcDriver");
Connection con = DriverManager.getConnection("jdbc:odbc:bank");// here student is envirment variable 
//sqlexception
stmt = con.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
rs = stmt.executeQuery("select Account ,Name, Amount from Bank");

		
		jdesktop = new JDesktopPane();
		jf = new JFrame();
		jmb = new JMenuBar();
		jmacc = new JMenu("Account");
		jmtrans = new JMenu("Transaction");
	    jmiopen = new JMenuItem("Open"); 
	    jmiclose = new JMenuItem(" Close ");
	    jmiexit = new JMenuItem("Exit");
	    jmideposit = new JMenuItem("Deposit");
	    jmiwithdraw = new JMenuItem("Withdraw");
	    
	    jf.setJMenuBar(jmb);
	    jmb.add(jmacc);
	    jmb.add(jmtrans);
	    jmacc.add(jmiopen);
	    jmacc.add(jmiclose);
	    jmacc.addSeparator();
	    jmacc.add(jmiexit);
	    jmtrans.add(jmideposit);
	    jmtrans.add(jmiwithdraw);
	    
	    jf.setVisible(true);
	    jf.setSize(700, 500);
	    
	    jf.add(jdesktop);
	    jifopen=new JInternalFrame("New Account",true,true,true,true);
		jifopen.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		jifopen.setLocation(0,0);
		jifopen.setSize(200,200);
			  jpo1 = new JPanel();
jpo2 = new JPanel();
osave = new JButton("Save");
ocancel = new JButton("Cancel");
oclose = new JButton("Close");
jol = new JLabel();
jolacc = new JLabel("Account No.");
jolname = new JLabel("Name");
jolamount = new JLabel("Amount");
jtfn = new JTextField(20);
jtfa = new JTextField(20);
jpo1.setLayout(new GridLayout(3,2));
jifopen.add(jpo1,BorderLayout.CENTER);
jpo2.setLayout(new FlowLayout());
jifopen.add(jpo2,BorderLayout.SOUTH);
jpo1.add(jolacc);
jpo1.add(jol);
jpo1.add(jolname);
jpo1.add(jtfn);
jpo1.add(jolamount);
jpo1.add(jtfa);
jpo2.add(osave);
jpo2.add(ocancel);
jpo2.add(oclose);
jdesktop.add(jifopen);		
jifopen.setVisible(false);

jifclose=new JInternalFrame("Delete Account",true,true,true,true);//
jifclose.setLocation(0,250);
jifclose.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
jifclose.setSize(200,200);//
jpc1 = new JPanel();
jpc2 = new JPanel();
csave = new JButton("Delete");
ccancel = new JButton("Cancel ");
cclose = new JButton("Close ");
jclaccno = new JLabel("Account Number");
jclname = new JLabel("Name");
jclnameauto = new JLabel();
jclbalance = new JLabel("Balance");
jclbalanceauto = new JLabel();
jtfaccc = new JTextField("",20);

jtfaccc.addKeyListener(new Fordelete());
jpc1.setLayout(new GridLayout(3,2));
jifclose.add(jpc1,BorderLayout.CENTER);//
jpc2.setLayout(new FlowLayout());
jifclose.add(jpc2,BorderLayout.SOUTH);//
jpc1.add(jclaccno);
jpc1.add(jtfaccc);
jpc1.add(jclname);
jpc1.add(jclnameauto);
jpc1.add(jclbalance);
jpc1.add(jclbalanceauto);
jpc2.add(csave);
jpc2.add(ccancel);
jpc2.add(cclose);
jdesktop.add(jifclose);//		
jifclose.setVisible(false);// 



jifdeposit=new JInternalFrame("Deposit",true,true,true,true);//
jifdeposit.setLocation(250,0);
jifdeposit.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
jifdeposit.setSize(200,200);//
jpd1 = new JPanel();
jpd2 = new JPanel();
jbdupdate = new JButton("Update");
jbdcancel = new JButton("Cancel  ");// 2 space
jbdclose = new JButton("Close  ");
jldaccno = new JLabel("Account Number");
jtfdaccno = new JTextField("",20);
jtfdaccno.addKeyListener(new Fordeposit());
jldname = new JLabel("Name");
jldnameauto = new JLabel();
jldbalance = new JLabel("Balance");
jldbalanceauto = new JLabel();
jldamount= new JLabel("Amount");
jtfdamount = new JTextField("",20);

jpd1.setLayout(new GridLayout(4,2));
jifdeposit.add(jpd1,BorderLayout.CENTER);
jpd2.setLayout(new FlowLayout());
jifdeposit.add(jpd2,BorderLayout.SOUTH);
jpd1.add(jldaccno);
jpd1.add(jtfdaccno);
jpd1.add(jldname);
jpd1.add(jldnameauto);
jpd1.add(jldbalance);
jpd1.add(jldbalanceauto);
jpd1.add(jldamount);
jpd1.add(jtfdamount);


jpd2.add(jbdupdate);
jpd2.add(jbdcancel);
jpd2.add(jbdclose);
jdesktop.add(jifdeposit);//		
jifdeposit.setVisible(false);// 




jifwithdraw=new JInternalFrame("Withdrawl Account",true,true,true,true);
jifwithdraw.setLocation(250,250);
jifwithdraw.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
jifwithdraw.setSize(200,200);
jpw1 = new JPanel();
jpw2 = new JPanel();
jbwwithdraw = new JButton("WithdrawAmount");
jbwcancel = new JButton("Cancel   ");// 3 space
jbwclose = new JButton("Close   ");
jlwaccno = new JLabel("Account Number");
jtfwaccno = new JTextField("",20);
jtfwaccno.addKeyListener(new Forwithdraw());
jlwname = new JLabel("Name");
jlwnameauto = new JLabel();
jlwbalance = new JLabel("Balance");
jlwbalanceauto = new JLabel();
jlwamount= new JLabel("Amount");
jtfwamount = new JTextField("",20);

jpw1.setLayout(new GridLayout(4,2));
jifwithdraw.add(jpw1,BorderLayout.CENTER);
jpw2.setLayout(new FlowLayout());
jifwithdraw.add(jpw2,BorderLayout.SOUTH);
jpw1.add(jlwaccno);
jpw1.add(jtfwaccno);
jpw1.add(jlwname);
jpw1.add(jlwnameauto);
jpw1.add(jlwbalance);
jpw1.add(jlwbalanceauto);
jpw1.add(jlwamount);
jpw1.add(jtfwamount);


jpw2.add(jbwwithdraw);
jpw2.add(jbwcancel);
jpw2.add(jbwclose);
jdesktop.add(jifwithdraw);
jifwithdraw.setVisible(false); 


jmiopen.addActionListener(this);
osave.addActionListener(this);
ocancel.addActionListener(this);
oclose.addActionListener(this);
jmiclose.addActionListener(this);
csave.addActionListener(this);
ccancel.addActionListener(this);
cclose.addActionListener(this);
//jtfaccc.addKeyListener(this);
jmideposit.addActionListener(this);
//jtfdaccno.addKeyListener(this);
//jtfwaccno.addKeyListener(this);
jbdupdate.addActionListener(this);
jbdcancel.addActionListener(this);
jmiwithdraw.addActionListener(this);
jbwclose.addActionListener(this);
jbwcancel.addActionListener(this);
jbwwithdraw.addActionListener(this);

}

class Fordelete implements KeyListener
{
	

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
if(ke.getKeyChar()== ke.VK_ENTER)
{

		int bypasslabel=0;
	int bypassnoacc=0;
		int count=1;
		accnofromclose=0;
		String typenum;

		Integer typenumint=0;

	check:	if(true){
		jclnameauto.setText("");
		jclbalanceauto.setText("");
		typenum = jtfaccc.getText();
		System.out.println(typenum);
	}
			try{typenumint = Integer.valueOf(typenum);
			}
			catch(NumberFormatException nfe){
				jclnameauto.setText("");
				jclbalanceauto.setText("");
					
			}
		
	three:	try{	rs.beforeFirst();

		one : while(rs.next()){
	System.out.println(typenumint);			
				if(rs.getInt(1)==typenumint)
				{
				accnofromclose= count;
				bypassnoacc=1;
				break one;
				}
				else
				{
				count++;
				}
			}}
	catch(SQLException sqe)
	{
		
	}	try{String name;
	int acc;
	Double amt;
	int saving = accnofromclose;
	if(bypassnoacc==1)
	{rs.absolute(saving);

	name = rs.getString("Name");
		acc =rs.getInt("Account");
		amt = rs.getDouble("Amount");
		System.out.println(amt+"this is amt");
	      System.out.println(acc + "\t" + name+ "\t"+amt);
	      jclnameauto.setText(name);
	      String amts=amt+"";
	jclbalanceauto.setText(amts);
	}
	else{
		JOptionPane.showMessageDialog(jf, "Account Number Do Not Exsist ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		
	}
	}
	catch(SQLException sw)
	{
		
	}
}
if(ke.getKeyChar()==ke.VK_BACK_SPACE)
{
	jclnameauto.setText("");
	jclbalanceauto.setText("");
}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}



////FOR DEPOSIT

class Fordeposit implements KeyListener
{

	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyChar()== ke.VK_ENTER)
		{

		int bypasslabel=0;
	int bypassnoacc=0;
		int count=1;
		accnofromclose=0;
		String typenum;

		Integer typenumint=0;

	check:	if(true){
		jldnameauto.setText("");
		jldbalanceauto.setText("");
		typenum = jtfdaccno.getText();
		System.out.println(typenum);
	}
			try{typenumint = Integer.valueOf(typenum);
			}
			catch(NumberFormatException nfe){
				jldnameauto.setText("");
				jldbalanceauto.setText("");
					
			}
		
	three:	try{	rs.beforeFirst();

		one : while(rs.next()){
				
				if(rs.getInt(1)==typenumint)
				{
				accnofromclose= count;
				bypassnoacc=1;
				break one;
				}
				else
				{
				count++;
				}
			}}
	catch(SQLException sqe)
	{
		
	}	try{String name;
	int acc;
	Double amt;
	int saving = accnofromclose;
	if(bypassnoacc==1)
	{rs.absolute(saving);

	name = rs.getString("Name");
		acc =rs.getInt("Account");
		amt = rs.getDouble("Amount");
	      System.out.println(acc + "\t" + name+ "\t"+amt);
	if(jtfdaccno.getText().equals(jtfwaccno.getText()))
	{
	System.out.println("inside d");	
    jldnameauto.setText(name);
    String amts=amt+"";
jldbalanceauto.setText(amts);
jlwnameauto.setText(name);
jlwbalanceauto.setText(amts);
	}
	else {
	      jldnameauto.setText(name);
	      String amts=amt+"";
	jldbalanceauto.setText(amts);
	}
	
	}
	else{
		JOptionPane.showMessageDialog(jf, "Account Number Do Not Exsist ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		
	}
	}
	catch(SQLException sw)
	{
		
	}	}
		if(ke.getKeyChar()==ke.VK_BACK_SPACE)
		{
				}

	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}


//FORWITHDRAWL


class Forwithdraw implements KeyListener
{
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void keyReleased(KeyEvent ke) {
		if(ke.getKeyChar()== ke.VK_ENTER)
		{

		System.out.println("inside withdraw");
		int bypasslabel=0;
	int bypassnoacc=0;
		int count=1;
		accnofromclose=0;
		String typenum;

		Integer typenumint=0;

	check:	if(true){
		jlwnameauto.setText("");
		jlwbalanceauto.setText("");
		typenum = jtfwaccno.getText();
		System.out.println(typenum);
	}
			try{typenumint = Integer.valueOf(typenum);
			}
			catch(NumberFormatException nfe){
				jlwnameauto.setText("");
				jlwbalanceauto.setText("");
					
			}
		
	three:	try{	rs.beforeFirst();

		one : while(rs.next()){
				
				if(rs.getInt(1)==typenumint)
				{
				accnofromclose= count;
				bypassnoacc=1;
				break one;
				}
				else
				{
				count++;
				}
			}}
	catch(SQLException sqe)
	{
		
	}	try{String name;
	int acc;
	Double amt;
	int saving = accnofromclose;
	if(bypassnoacc==1)
	{rs.absolute(saving);

	name = rs.getString("Name");
		acc =rs.getInt("Account");
		amt = rs.getDouble("Amount");
	      System.out.println(acc + "\t" + name+ "\t"+amt);
	  	
	      jlwnameauto.setText(name);
	      String amts=amt+"";
	jlwbalanceauto.setText(amts);
	      
	}
	else{
		JOptionPane.showMessageDialog(jf, "Account Number Do Not Exsist ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		
	}
	}
	catch(SQLException sw)
	{
		
	}		
		}
		if(ke.getKeyChar()==ke.VK_BACK_SPACE)
		{
					}
	}

	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
}   
Vector <Integer>v = new Vector<Integer>();

public void actionPerformed(ActionEvent ae) {

	if(ae.getActionCommand().equals("Open"))
	{jtfn.setText("");
	jtfa.setText("");
		openactive=1;
		jifopen.setVisible(true);
      try{
        rs.beforeFirst();
        while(rs.next())
        {
        v.add(rs.getInt(1));
        }
        sizeofvector = v.size();
        System.out.println(sizeofvector);
        if(sizeofvector==0){
        	jol.setText("1");
        }else{
         lastindexvalue = v.get(sizeofvector-1);
        int acclabel = lastindexvalue+1;
        jol.setText(acclabel+"");
        }
        }
   
      catch(SQLException s){
    	  System.out.println(s.getMessage());
    	  System.out.println("keep patience problem will be resolved soon");
      }
	}
	if(ae.getActionCommand().equals("Save"))
{if(jtfn.getText().equals(""))
{	JOptionPane.showMessageDialog(jf, "Inavlid NAME ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	

	}
else{	String s = jtfn.getText();
		String amount = jtfa.getText();
		Double amou=0.0;
try{
	Double stringcheck = Double.valueOf(s);
	JOptionPane.showMessageDialog(jf, "Enter A Valid Name ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
    jtfn.setText("");
	return;

}catch(NumberFormatException nfe){
	
}

Double neg=0.0;		
		try
		{
			amou = Double.valueOf(amount);// number format exception if value is not double//have local variable
		neg=amou;
		}
		catch(NumberFormatException nfe)
		{
		
			JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Enter Numeric values ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
             jtfa.setText("");
			return;
		}
		if(neg<0)
		{
			JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Balance cannot be negative ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
            jtfa.setText("");

			return;
		}

try{if(sizeofvector==0)
{
	rs.moveToInsertRow();
	rs.updateInt("Account",1 );// column not found
	rs.updateString("Name", s);
	rs.updateDouble("Amount", amou);
	rs.insertRow();
	
}else{
	int accno=lastindexvalue+1;
		rs.moveToInsertRow();
		rs.updateInt("Account",accno );// column not found
		rs.updateString("Name", s);
		rs.updateDouble("Amount", amou);
		rs.insertRow();
}
}
catch(SQLException sd)
{
	System.out.print("inside sql exception of save");
}jtfn.setText("");
jtfa.setText("");
try{
    rs.beforeFirst();
    while(rs.next())
    {
    v.add(rs.getInt(1));
    }
    sizeofvector = v.size();
    System.out.println(sizeofvector);
    if(sizeofvector==0){
    	jol.setText("1");
    }else{
     lastindexvalue = v.get(sizeofvector-1);
    int acclabel = lastindexvalue+1;
    jol.setText(acclabel+"");
    }
    }

  catch(SQLException sq){
	  System.out.println(sq.getMessage());
	  System.out.println("keep patience problem will be resolved soon");
  }
}
//jifopen.setVisible(false);

}
	if(ae.getActionCommand().equals("Cancel"))
	{	jifopen.setVisible(false);
		
	}
	if(ae.getActionCommand().equals(" Close ")){
jclnameauto.setText("");
jclbalanceauto.setText("");
jtfaccc.setText("");
jifclose.setVisible(true);
//jclose.setSize(350,250);
fordelete=1;

	}
	if(ae.getActionCommand().equals("Delete"))
	{try{
		System.out.println("Inside delete");
		System.out.println(accnofromclose);
		rs.absolute(accnofromclose);
		rs.deleteRow();
		//jifclose.setVisible(false);		
		fordelete=0;
	     if(jtfdaccno.getText().equals(jtfaccc.getText()))
	     {
	    	 jtfdaccno.setText("");
	    	 jldbalanceauto.setText("");
	    	 jldnameauto.setText("");
	     }
	     if(jtfwaccno.getText().equals(jtfaccc.getText()))
	     {

	    	 jtfwaccno.setText("");
	    	
	    	 jlwbalanceauto.setText("");
	    	 jlwnameauto.setText("");
	    	 
	     }
	 
	}
		catch(SQLException se)
		{

			System.out.println("Inside delete catch");
		}


jtfaccc.setText("");
jclnameauto.setText("");
jclbalanceauto.setText("");
	}
	if(ae.getActionCommand().equals("Cancel "))
	{
		
		jifclose.setVisible(false);
		 fordelete=0;
	}
	if(ae.getActionCommand().equals("Close "))
	{

		
		jifclose.setVisible(false);
		 fordelete=0;
		}
	if(ae.getActionCommand().equals("Deposit"))
	{   jtfdamount.setText("");
		jldnameauto.setText("");
		jldbalanceauto.setText("");
		jtfdaccno.setText("");
		jifdeposit.setVisible(true);
		forupdate=1;
		
	}
	if(ae.getActionCommand().equals("Update"))
	{int forall=0;
		Double dam=0.0;
		String am= jtfdamount.getText();

Double neg=0.0;
		try{ dam = Double.valueOf(am);
		neg=dam;
		}
		catch(NumberFormatException nfe){

			JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Enter Numeric values ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
             jtfdamount.setText("");
			return;
		
		}
		if(neg<0)
		{
			JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Enter Positive Value ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
            jtfdamount.setText("");
			return;
			
		}
		int forrs = Integer.valueOf(jtfdaccno.getText());
		System.out.println(forrs+"this is it");
		
		//forrs--;
		int count=1;
		int abs=0;
		try{	rs.beforeFirst();

		one : while(rs.next()){
	System.out.println(forrs);			
				if(rs.getInt(1)==forrs)
				{
				accnofromclose= count;
				abs=count;
				//bypassnoacc=1;
				break one;
				}
				else
				{
				count++;
				}
			}}
	catch(SQLException sqe)
	{
		
	}
		
		try{
			System.out.println(abs);
			rs.absolute(abs);
		System.out.println(forrs+"this is it");
		//System.out.println(accnofromclose+"///////////");
		Double subtotal = rs.getDouble("Amount");
		System.out.println("////////fefeff"+subtotal);
		Double total = subtotal+dam;
		System.out.println("///////////////fefeff"+total);
		rs.updateDouble("Amount", total);
			rs.updateRow();
		}catch(SQLException sew)
		{
			
		}
		int activeboth=0;
		String totransfer="";
		if(!jtfdaccno.getText().equals(jtfaccc.getText())&&!jtfdaccno.getText().equals(jtfwaccno.getText()))
		{  	  String amts=jldbalanceauto.getText();
		  	  Double amt = Double.valueOf(amts);
		  	  Double totalam = Double.valueOf(jtfdamount.getText());
		  	  amt=amt+totalam;
		  	totransfer=amt+"";
		  //jlwnameauto.setText(jldnameauto.getText());
		  jldbalanceauto.setText(amt+"");
		  //jclbalanceauto.setText(amt+"");
		  	
		}
	     if(jtfdaccno.getText().equals(jtfaccc.getText()))
		  	{activeboth=1;
		  	  String amts=jldbalanceauto.getText();
		  	  Double amt = Double.valueOf(amts);
		  	  Double totalam = Double.valueOf(jtfdamount.getText());
		  	  amt=amt+totalam;
		  	totransfer=amt+"";
			
		  	  System.out.println(jldnameauto.getText()+"bal"+jldbalanceauto.getText());
		  jlwnameauto.setText(jldnameauto.getText());
		  jldbalanceauto.setText(amt+"");
		  jclbalanceauto.setText(amt+"");
		  	}

	     if(jtfdaccno.getText().equals(jtfwaccno.getText()))
		  	{
		  	  String amts=jldbalanceauto.getText();
		  	  Double amt = Double.valueOf(amts);
		  	  Double totalam = Double.valueOf(jtfdamount.getText());
		  	  if(activeboth!=1)
		  	  {amt=amt+totalam;
		  	  }
			totransfer=amt+"";
		  	System.out.println(jldnameauto.getText()+"bal"+jldbalanceauto.getText());
		  jlwnameauto.setText(jldnameauto.getText());
		  jldbalanceauto.setText(amt+"");
		  jlwbalanceauto.setText(amt+"");
		  	}
	     jtfdamount.setText("");
			 
		
	//	accnofromclose=0;
//jifdeposit.setVisible(false);
	    fordelete=0;
forupdate=0;
	}
	if(ae.getActionCommand().equals("Cancel  ")){

	
		jifdeposit.setVisible(false);
		 forupdate=0;
		
	}
	if(ae.getActionCommand().equals("Close  "))
{		
		jifdeposit.setVisible(false);
		 forupdate=0;

		}
	if(ae.getActionCommand().equals("Withdraw"))
	{
		jtfwamount.setText("");
		jlwnameauto.setText("");
		jlwbalanceauto.setText("");
		jtfwaccno.setText("");
		jifwithdraw.setVisible(true);
		forwithdraw=1;
		
	}
if(ae.getActionCommand().equals("WithdrawAmount"))
{

	Double dam=0.0;
	String am= jtfwamount.getText();
	Double tocheck= 0.0;
	
	try
	{
	dam = Double.valueOf(am);
	tocheck =dam;
	}
	catch(NumberFormatException nfe){

		JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Invalid Numeric values ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
         jtfdamount.setText("");
		return;
		}
	if(dam<0)
	{
		JOptionPane.showMessageDialog(jf, "Inavlid Amount :: Enter Positive Value ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
        jtfdamount.setText("");
		return;
		
	}
	try{rs.absolute(accnofromclose);
	
	Double subtotal = rs.getDouble("Amount");
	Double total = subtotal-dam;
	if(total<0.0)
	{
		JOptionPane.showMessageDialog(jf, "You Do Not Have Sufficient Amount In Your Account For Transaction ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		 jtfdamount.setText("");
			
		return;
	}
	
	rs.updateDouble("Amount", total);
		rs.updateRow();
	}catch(SQLException sew)
	{
		
	}
	int activeboth=0;
	System.out.println("on the other side");
	//accnofromclose=0;
	Double amountisneed=0.0;
	Double amountisnedd2=0.0;
	System.out.println();
	int waccno=0,acccno=0,daccno=0;
	try{
	 waccno = Integer.valueOf(jtfwaccno.getText());
	}catch(NumberFormatException nfe)
	{
	waccno=0;	
	}try{ acccno = Integer.valueOf(jtfaccc.getText());
	}catch(NumberFormatException nfe)
	{
		acccno=0;
	}
	try{daccno =Integer.valueOf(jtfdaccno.getText());
	}catch(NumberFormatException nfe)
	{daccno=0;
		
	}
	System.out.println(waccno+acccno+daccno);
	if(waccno!=acccno&&waccno!=daccno)
	{  	
		System.out.println("inside no match");
	  	  String amts=jlwbalanceauto.getText();
	  	 
	  	  Double amt = Double.valueOf(amts);
	  	  Double totalam = Double.valueOf(jtfwamount.getText());
	  	  amt=amt-totalam;
	  	if(amt<=0)
	  	  {
		JOptionPane.showMessageDialog(jf, "You Do Not Have Sufficient Amount In Your Account For Transaction ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		jtfdamount.setText("");
		return;
		}  	  System.out.println(jldnameauto.getText()+"bal"+jldbalanceauto.getText());
	  //jlwnameauto.setText(jldnameauto.getText());
	  jlwbalanceauto.setText(amt+"");
	  //jclbalanceauto.setText(amt+"");
	}
    
	if(jtfdaccno.getText().equals(jtfwaccno.getText()))
  	{activeboth=1;
  	System.out.println("inside dd");
  	  String amts=jlwbalanceauto.getText();
  	  Double amt = Double.valueOf(amts);
  	  Double totalam = Double.valueOf(jtfwamount.getText());
  	  amt=amt-totalam;
  	  amountisneed=amt;
  	  System.out.println(amt+"here");
  	  if(amt<=0)
  	  {
  		  
	JOptionPane.showMessageDialog(jf, "You Do Not Have Sufficient Amount In Your Account For Transaction ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
	jtfdamount.setText("");
	return;
	
  	  }
  	System.out.println(jlwnameauto.getText()+"bal"+jlwbalanceauto.getText());
  jldnameauto.setText(jlwnameauto.getText());
  jlwbalanceauto.setText(amt+"");
  jldbalanceauto.setText(amt+"");
	}
	if(jtfwaccno.getText().equals(jtfaccc.getText()))
	  	{	System.out.println("inside d"+"  b"+jtfdaccno.getText()+"   f"+jtfaccc.getText());
	  	  String amts=jlwbalanceauto.getText();
          System.out.println(amts);
		  Double amt = Double.valueOf(amts);
	 	  System.out.println(amt);
	  	  Double totalam = Double.valueOf(jtfwamount.getText());
	  	  if(activeboth!=1)
	  	  {amt=amt-totalam;
	  	  }
	  	  amountisneed=amt;
	  	  if(amt<=0)
	  	  {
		JOptionPane.showMessageDialog(jf, "You Do Not Have Sufficient Amount In Your Account For Transaction ", "BankEmulator",JOptionPane.PLAIN_MESSAGE);	
		jtfwamount.setText("");
		return;
		}

	  	  System.out.println(jlwnameauto.getText()+"bal"+jlwbalanceauto.getText());
	  jlwnameauto.setText(jldnameauto.getText());
	  System.out.println(amt+"this is amout");
	  jclbalanceauto.setText(amt+"");
	  jlwbalanceauto.setText(
		  	  amountisneed+"");
	  	}

	
	 
		
	 jtfwamount.setText("");

//jifwithdraw.setVisible(false);
	fordelete=0;
forupdate=0;
	forwithdraw=0;
}
if(ae.getActionCommand().equals("Cancel   "))
{
	
	
	
	jwithdraw.setVisible(false);
	 forwithdraw=0;
	
}
if(ae.getActionCommand().equals("Close   "))
{
	
	jmacc.setEnabled(true);
    jmtrans.setEnabled(true);

	jwithdraw.setVisible(false);
	 forwithdraw=0;
	
	
}
}

public static void main(String args[]) throws ClassNotFoundException,SQLException
{
Bank b = new Bank();
}
Statement stmt;
ResultSet rs;
int openactive;
int sizeofvector;
int lastindexvalue;
int accnofromclose;

@Override
public void keyPressed(KeyEvent arg0) {
	// TODO Auto-generated method stub
	
}
@Override
public void keyReleased(KeyEvent ke) {
if(fordelete==1)
{}
if(forupdate==1)
{}
if(forwithdraw==1)
{}
}
public void keyTyped(KeyEvent arg0) {
	}
int forupdate;
int fordelete;
int forwithdraw;
int amount_to_deposit;
}
