package studentCoursesBackup.util;
import java.io.FileReader;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class FileProcessor {

	private Scanner scrObj = null;
	
	/**
	 * constructor to initialize inputfile value
	 * @param inputfile a name of input file to be read
	 * @throws Exception
	 */
	public FileProcessor(String inputFile)throws Exception
	{
		scrObj = new Scanner(new FileReader(inputFile));
	}
	
	/**
	 * readLine method used to read a text file line by line
	 * @return string a line in a text file
	 * @throws FileNotFoundException
	 */
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
