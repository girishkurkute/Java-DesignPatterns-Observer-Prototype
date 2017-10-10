package studentCoursesBackup.driver;

import java.util.Enumeration;
import java.util.Hashtable;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.TreeBuilder;
import studentCoursesBackup.util.Results;

public class Driver {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String inputfile,deletefile,outputfile_1,outputfile_2,outputfile_3;
		String currLine,currdelLine;
		
		if(args.length !=5)
		{			
			throw new RuntimeException("Please provide all arguments");
		}
		else
		{
			inputfile = args[0];
			deletefile = args[1];
			outputfile_1 = args[2];
			outputfile_2 = args[3];
			outputfile_3 = args[4];
		}

		
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

			
			if(bnumberLength==4)
			{
			course = arrayInfo[1].toUpperCase();
			length = course.length();
			if(length==1)
			{

	
				if(course.charAt(0) >= 'A' && course.charAt(0) <= 'K')
				{
			
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
			orig_node = trbObj.insert(number, courseValue);
			
			backup_Node_1 = orig_node.clone();
			backup_Node_2 = orig_node.clone();
			
			backup_Node_1 = backup1trbObj.insert(number, courseValue);
			backup_Node_2 = backup2trbObj.insert(number, courseValue);
			
			orig_node.registerObserver(backup_Node_1,backup_Node_2);
	      }        
		
		
		
		trbObj.Display();
		
		
		while((currdelLine = fpDelObj.readLine())!= null)
		{
			int bnumber,bnumberLength,length;
			String num, course;
			String [] arrayInfo = currdelLine.split(":");
			//System.out.println(arrayInfo[0]);
			//System.out.println(arrayInfo[1]);
			num = arrayInfo[0];
			
			bnumber = Integer.parseInt(num);
			course = arrayInfo[1];
			bnumberLength = num.length();

			
			if(bnumberLength==4)
			{
			course = arrayInfo[1].toUpperCase();
			length = course.length();
			if(length==1)
			{
	
				if(course.charAt(0) >= 'A' && course.charAt(0) <= 'K')
				{						
					orig_node=trbObj.delete(bnumber, course);
					if(orig_node!=null)
					{
						orig_node.notifyObservers(orig_node.value);
					}
				}
			 }
			}
		}
		
		trbObj.printNodes(reslt1Obj,trbObj.root);
		backup1trbObj.printNodes(reslt2Obj,backup1trbObj.root);
		backup2trbObj.printNodes(reslt3Obj,backup2trbObj.root);
		
		trbObj.Display();
		System.out.println();
		backup1trbObj.Display();
		System.out.println();
		backup2trbObj.Display();
	}

}
