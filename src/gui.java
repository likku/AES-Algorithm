import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
@SuppressWarnings("serial")
public class gui extends JFrame implements ActionListener
{
	static int i;
	JLabel ifn,ofn;
	JTextField itf,otf;
	JButton browse,enc,dec;
	application a;
	public gui()
	{
		a=new application();
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		ifn = new JLabel("Input File Name");
		ofn = new JLabel("Output File Name");
		itf = new JTextField(20);
		otf = new JTextField(20);
		browse = new JButton("Browse");
		enc = new JButton("Encrypt");
		dec = new JButton("Decrypt");
		browse.addActionListener
		(
			new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				      String s=a.browse();
				      itf.setText(s);
			    }
			 }
		);
		dec.addActionListener
		(
			new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				      String s=otf.getText();
				      String i=itf.getText();
				      if(s.length()!=0&&i.length()!=0)
				      {
				      a.decrypt(s);
				      itf.setText("");
				      otf.setText("");
				      }
				      else
				      {
				    	  if(s.length()==0&&i.length()==0)
				    	  JOptionPane.showMessageDialog(null, "plese enter input and output  file names");
				    	  else if(i.length()==0)
				    	  JOptionPane.showMessageDialog(null, "plese enter valid input file name");
				    	  else
				    	  JOptionPane.showMessageDialog(null, "plese enter valid output file name");  
				      }
			    }
			 }
		);
		enc.addActionListener
		(
			new ActionListener() {
			   public void actionPerformed(ActionEvent e) {
				   String s=otf.getText();
				      String i=itf.getText();
				      if(s.length()!=0&&i.length()!=0)
				      {
				      a.encrypt(s);
				      itf.setText("");
				      otf.setText("");
				      }
				      else
				      {
				    	  if(s.length()==0&&i.length()==0)
				    	  JOptionPane.showMessageDialog(null, "plese enter input and output  file names");
				    	  else if(i.length()==0)
				    	  JOptionPane.showMessageDialog(null, "plese enter valid input file name");
				    	  else
				    	  JOptionPane.showMessageDialog(null, "plese enter valid output file name"); 
				      }			
				      }
			 }
		);
		add(ifn);
		ifn.setBounds(50,90,90,10);
		add(itf);
		itf.setBounds(180,86,200,25);
		add(browse);
		browse.setBounds(420,86,90,25);
		add(ofn);
		ofn.setBounds(50,170,110,10);
		add(otf);
		otf.setBounds(180,166,200,25);
		add(enc);
		enc.setBounds(180,236,80,25);
		add(dec);
		dec.setBounds(300,236,80,25);
		setTitle("Application");
		setSize(550,400);
		show();
	}
	public void actionPerformed(ActionEvent ae){	}
}