import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
public class decrypt {
	@SuppressWarnings("resource")
	public static void main(byte b[],String input,String output) 
	{
		String type,str;
		int i;
		File fin=new File(input);
		File fout;
		try
		{
		FileInputStream fins=new FileInputStream(fin);
		 int len1=fins.read();//extenssion length
	      //getting extenssion
	      type="";
	      for(i=0;i<len1;i++)
	      	type+=(char)fins.read();
	      //end
	      fout = new File(output+"."+type);//create output file
	      fout.createNewFile();
		FileOutputStream fos=new FileOutputStream(fout);
		int r,c=0;
		int v,p,j=0,len;
		StringBuffer sb=new StringBuffer();
		String in = null;
		StringBuffer ssb=new StringBuffer();
		while(((r=fins.read())!=-1)||c<=130)
		{ 
        	c++;
			if(r!=-1)
			{
				ssb.append((char)r);
			}
			if(c==130)
			{
				in="";
				c=0;
				str=Aes.decrypt(ssb.toString(),b);
				ssb.delete(0, ssb.length());
				///////////////////////////////
				len=str.length();
		        for( i=0;i<len;i++)
		        {
					sb.append(str.charAt(i));
					j++;
					if(j==2)
					{
					   v=0;p=1;
						for(int t=0;t<2;t++)
						{
							char ch = sb.charAt(t);
							if(ch>=97&&ch<=102)
							{
								switch(ch)
								{
								case 'a':v+=10*p; break;
								case 'b':v+=11*p; break;
								case 'c':v+=12*p; break;
								case 'd':v+=13*p; break;
								case 'e':v+=14*p; break;
								case 'f':v+=15*p; break;
								}
								p*=16;
							}
							else
							{
								v+=p*Integer.parseInt(ch+"");
								p*=16;
							}
						}
						j=0;
						sb.delete(0, 2);
					  in+=(char)v;
					}
		        }
				///////////////////////////////////
		        len1=in.length();
				 for(i=0;i<len1;i++)
				       fos.write((int)in.charAt(i));
			}
			if(r==-1)
			{
				in="";
				c=0;
				str=Aes.decrypt(ssb.toString(),b);
				ssb.delete(0, ssb.length());
				//////////////////////
				len=str.length();
			     for( i=0;i<len;i++)
			        {
						sb.append(str.charAt(i));
						j++;
						if(j==2)
						{
						   v=0;p=1;
							for(int t=0;t<2;t++)
							{
								char ch = sb.charAt(t);
								if(ch>=97&&ch<=102)
								{
									switch(ch)
									{
									case 'a':v+=10*p; break;
									case 'b':v+=11*p; break;
									case 'c':v+=12*p; break;
									case 'd':v+=13*p; break;
									case 'e':v+=14*p; break;
									case 'f':v+=15*p; break;
									}
									p*=16;
								}
								else
								{
									v+=p*Integer.parseInt(ch+"");
									p*=16;
								}
							}
							j=0;
							sb.delete(0, 2);
						  in+=(char)v;
						}
			        }
				////////////////////////
			     len1=in.length();
				 for(i=0;i<len1;i++)
				       fos.write((int)in.charAt(i));
				break;
			}
		}
		}
		catch(Exception e)
		{}
	}
}
	