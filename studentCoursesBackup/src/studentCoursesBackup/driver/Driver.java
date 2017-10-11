package studentCoursesBackup.driver;

import java.util.Enumeration;
import java.util.Hashtable;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;

public class Driver {
	/**
	 * Execution of program starts with Main.Input and delete file reading and call to insert or delete node to/from tree is done in this function 
	 * @param args
	 * @throws Exception
	 * returns nothing
	 */
	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String inputfile,deletefile,outputfile_1,outputfile_2,outputfile_3;
		String currLine,currdelLine;
		
		if(args.length !=5)
		{			
			throw new RuntimeException("Please provide 5 arguments");
		}
		else
		{
			////Assigning text file names
			inputfile = args[0];
			deletefile = args[1];
			outputfile_1 = args[2];
			outputfile_2 = args[3];
			outputfile_3 = args[4];
		}

		//Object creation
		FileProcessor fprObj = new FileProcessor(inputfile);
		FileProcessor fpDelObj = new FileProcessor(deletefile);
		TreeBuilder trbObj = new TreeBuilder();
		TreeBuilder backup1trbObj = new TreeBuilder();
		TreeBuilder backup2trbObj = new TreeBuilder();
		Results reslt1Obj = new Results(outputfile_1);
		Results reslt2Obj = new Results(outputfile_2);
		Results reslt3Obj = new Results(outputfile_3);
		
		Hashtable ht = new Hashtable();
		Node orig_node = null;
		Node backup_Node_1 = null;
		Node backup_Node_2 = null;
		
		Enumeration collection;
		
		//reading input file
		while((currLine = fprObj.readLine())!= null)
		{
			int bnumber,bnumberLength,length;
			String num, course;
			boolean check= false;
			String [] arrayInfo = currLine.split(":");
			//System.out.println(arrayInfo[0]);
			//System.out.println(arrayInfo[1]);
			num = arrayInfo[0];
			bnumber = Integer.parseInt(num);
			course = arrayInfo[1];
			bnumberLength = num.length();

			//checking number of digits in bnumber
			if(bnumberLength==4)
			{
			course = arrayInfo[1].toUpperCase();
			length = course.length();
			//only single course can be added at once
			if(length==1)
			{

				//course value should be within 'A' to 'K'
				if(course.charAt(0) >= 'A' && course.charAt(0) <= 'K')
				{
					//storing all bnumbers and courses into hashtable
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
			}
		}
		}
		//get all keys in hashtable
		collection = ht.keys();
		int number;
		String courseValue;
		while(collection.hasMoreElements()) {
			number = (int) collection.nextElement();
			courseValue=(String) ht.get(number);
			//inserting Bnumber and course into BST
			orig_node = trbObj.insert(number, courseValue);
			
			//creating clone of node of original tree 
			backup_Node_1 = orig_node.clone();
			backup_Node_2 = orig_node.clone();
			
			//creating tree for backup nodes
			backup_Node_1 = backup1trbObj.insert(number, courseValue);
			backup_Node_2 = backup2trbObj.insert(number, courseValue);
			
			//registering backup nodes as a observer
			orig_node.registerObserver(backup_Node_1,backup_Node_2);
	      }        
		
		
		
		
		
		//reading delete file
		while((currdelLine = fpDelObj.readLine())!= null)
		{
			int bnumber,bnumberLength,length;
			String num, course;
			String [] arrayInfo = currdelLine.split(":");

			num = arrayInfo[0];
			
			bnumber = Integer.parseInt(num);
			course = arrayInfo[1];
			bnumberLength = num.length();

			//checking number of digits in bnumber
			if(bnumberLength==4)
			{
			course = arrayInfo[1].toUpperCase();
			length = course.length();
			//only single course can be added at once
			if(length==1)
			{
				//course value should be within 'A' to 'K'
				if(course.charAt(0) >= 'A' && course.charAt(0) <= 'K')
				{						
					//deleting Bnumber and course into tree
					orig_node=trbObj.delete(bnumber, course);
					if(orig_node!=null)
					{
						orig_node.notifyObservers(orig_node.value);
					}
				}
			 }
			}
		}
		
		//calling method to print tree values in ascending order into output file
		trbObj.printNodes(reslt1Obj,trbObj.root);
		backup1trbObj.printNodes(reslt2Obj,backup1trbObj.root);
		backup2trbObj.printNodes(reslt3Obj,backup2trbObj.root);
		
		
	}

}
