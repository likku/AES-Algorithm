import java.awt.FileDialog;
import java.awt.Frame;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
public class application  
{
  String input,outdir;
  File fin,fout;
  FileInputStream fins;
  FileOutputStream fouts;
  byte []b=new byte[16];
  public String browse()
  {
	  
	  Frame f=new Frame();
      FileDialog fd = new FileDialog( f, "File Dialog");
      fd.setVisible(true);
      outdir = fd.getDirectory();
      input=fd.getDirectory()+fd.getFile();
      return(input);
  }
  public void encrypt(String output)
  { 
	  String s;
	   fin=new File(input);
      if(fin.exists())
      {
    	   s=this.get();
    	   //to cancle the opretion
    	   if(s=="return")
  		      return;
           
       }
       else
       {
       	JOptionPane.showMessageDialog(null, "plese enter valid input file name");
        //setting to null
		   this.setnull();
		   return;
       }
               encrypt.main(b,input,outdir+output);
		  //setting to null
		   this.setnull();
 		  JOptionPane.showMessageDialog(null, "finished");
  }
  public void decrypt(String output)  
  {  
	  
	  String s,type="";
	  fin=new File(input);
	  //to get extenssion
	  s = fin.getName();
	  int i = s.lastIndexOf('.');
      if (i > 0 && i < s.length() - 1)
      type = s.substring(i+1).toLowerCase();
      if(fin.exists()&&type.equalsIgnoreCase("sns"))
      {
       
    	 s=this.get();
    	 //to cancle the opretion
  	    if(s=="return")
  	    {
  		   //settin all to null 
  		   this.setnull();
		   return;
  	     }
      }
      else
      {
      	JOptionPane.showMessageDialog(null, "plese enter valid input file name");
      	this.setnull();
      	return;
      }
        decrypt.main(b,input,outdir+output);
      //setting to null
	   this.setnull();
		JOptionPane.showMessageDialog(null, "finished");
		 
	}
  public static void main(String args[])
  {
	  new gui();
  }
  public  String  get()
  {
	  int result;
	  JPasswordField pField = new JPasswordField(10);
	  JPanel pPanel = new JPanel();
	 pPanel.add(new JLabel("Please Enter Password: "));
	  pPanel.add(pField);
	   do
    {

	   result = JOptionPane.showConfirmDialog(null, pPanel);
	   if(result == JOptionPane.CANCEL_OPTION || result<0||result == JOptionPane.NO_OPTION)
	   {
		   this.setnull();
		  return( "return");
	   }
	}while( (result != JOptionPane.OK_OPTION));
	   String password=String.valueOf(pField.getPassword());
	   if(password.length()==0)
	      {
	    	 JOptionPane.showMessageDialog(null, "plese enter valid password ");
	    	 password=this.get();
	      }
	 // return(password);
	   if(password.length()>16)
       {
           password=password.substring(0,16);
       }
       else
       {
           do
           {
           password+=password;
           }while(password.length()<=16);
           password=password.substring(0,16);       
       }
	      for(int i = 0;i<16;i++)
		  b[i]=(byte) password.charAt(i);
		return password;
	    	
  }
  public void setnull()
  {
	   input=null;
	   outdir=null;
	   fin=null;
	   fout=null;
	   fouts=null;
	   fins=null;
	   System.gc();

  }
}
