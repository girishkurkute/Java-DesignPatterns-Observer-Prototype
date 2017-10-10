package studentCoursesBackup.driver;

import java.util.Enumeration;
import java.util.Hashtable;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String inputfile,deletefile;
		String currLine,currdelLine;
		
		if(args.length !=2)
		{			
			throw new RuntimeException("Please provide all arguments");
		}
		else
		{
			inputfile = args[0];
			deletefile = args[1];
			
		}

		
		FileProcessor fprObj = new FileProcessor(inputfile);
		FileProcessor fpDelObj = new FileProcessor(deletefile);
		TreeBuilder trbObj = new TreeBuilder();
		
		Hashtable ht = new Hashtable();
		Node orig_node = null;
		
		Enumeration collection;
		
		while((currLine = fprObj.readLine())!= null)
		{
			int bnumber;
			String num, course;
			boolean check= false;
			String [] arrayInfo = currLine.split(":");
			//System.out.println(arrayInfo[0]);
			//System.out.println(arrayInfo[1]);
			num = arrayInfo[0];
			bnumber = Integer.parseInt(num);
			course = arrayInfo[1];
			check = ht.containsKey(bnumber);
			if(check == false)
			{
				ht.put(bnumber, course);
			}
			else
			{
				String temp = (String) ht.get(bnumber);
				temp  = temp + course;
				ht.put(bnumber, temp);
			}
			
		}
		
		//get all keys in hashtable
		collection = ht.keys();
		int number;
		String courseValue;
		while(collection.hasMoreElements()) {
			number = (int) collection.nextElement();
			courseValue=(String) ht.get(number);
			orig_node = trbObj.insert(number, courseValue);
	      }        
		
		trbObj.Display();
		
		
		while((currdelLine = fpDelObj.readLine())!= null)
		{
			int bnumber;
			String num, course;
			String [] arrayInfo = currdelLine.split(":");
			//System.out.println(arrayInfo[0]);
			//System.out.println(arrayInfo[1]);
			num = arrayInfo[0];
			bnumber = Integer.parseInt(num);
			course = arrayInfo[1];
			orig_node=trbObj.delete(bnumber, course);
			
		}
		trbObj.Display();
	}

}
