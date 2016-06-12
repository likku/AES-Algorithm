import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class encrypt {

@SuppressWarnings("resource")
public static void main(byte b[],String input,String output) 
{
	String type = null,str,s;
	File fin=new File(input);
	File fout=new File(output+".sns");
	try
	{
     fout.createNewFile();
	 FileInputStream fins=new FileInputStream(fin);
	 FileOutputStream fouts=new FileOutputStream(fout);
	 //to get extenssion
        s = fin.getName();
        int q = s.lastIndexOf('.');
	   if (q > 0 && q < s.length() - 1)
           type = s.substring(q+1).toLowerCase();
	   //end
	 //writing extenssion to file
       int len = type.length();
       fouts.write((int) len);
       for( q=0;q<len;q++)
       fouts.write((int)type.charAt(q));
    //end   
	StringBuffer ssb=new StringBuffer();
	int r,c=0,k,t;
	while((r=fins.read())!=-1||c<=47)
		{
		  c++;
		           if(r!=-1)
		           { 
		        	   for( t=0;t<2;t++)
		        	   {
		        		   k=r%16;
						if(k<=9)
						{
							ssb.append(k);}
						else
						{
							switch(k)
							{
							case 10:ssb.append('a');break;
							case 11:ssb.append('b');break;
							case 12:ssb.append('c');break;
							case 13:ssb.append('d');break;
							case 14:ssb.append('e');break;
							case 15:ssb.append('f');break;
						   }
						}
						r=r/16;}  
		           }
		           if(c==47)
		           {
		        	   c=0;
		        	   str=Aes.encrypt(ssb.toString(),b);
		        	   ssb.delete(0, ssb.length());
		        	   len=str.length();
		        	   for(int i=0;i<len;i++)
		        	       fouts.write((int)str.charAt(i));
		           }
		           if(r==-1)
		           {	
		        	   str=Aes.encrypt(ssb.toString(),b);
		        	    len=str.length();
		        	   for(int i=0;i<len;i++)
		        	       fouts.write((int)str.charAt(i));
		        	   break;
		           }
			}
	}
	catch(Exception e)
	{}
}
}
