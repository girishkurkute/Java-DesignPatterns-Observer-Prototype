package studentCoursesBackup.util;
import java.io.*;
import java.util.Scanner;

public class FileProcessor {

	private Scanner scrObj = null;
	
	public FileProcessor(String inputFile)throws Exception
	{
		scrObj = new Scanner(new FileReader(inputFile));
	}
	
	public String readLine() throws FileNotFoundException
	{
		String currLine=null;
		try
		{
			
			if(scrObj == null)
			{
				
				throw new RuntimeException("File closed");				
			}
			 while(scrObj.hasNext())
			{
				currLine = scrObj.next();
				return currLine;
			}
			currLine = null;
			if(scrObj != null)
			{
				scrObj.close();
				scrObj = null;
			}
			return currLine;
		}
		catch(Exception e)
		{
			System.out.println("Error in reading file"); 
			if(scrObj != null)
			{
				scrObj.close();
				scrObj = null;
			}
			e.printStackTrace();
		}
		return currLine;
	}
}
