package studentCoursesBackup.driver;

import java.util.Hashtable;

import studentCoursesBackup.util.FileProcessor;
import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.TreeBuilder;

public class Driver {

	public static void main(String[] args)throws Exception {
		// TODO Auto-generated method stub
		
		String inputfile,deletefile;
		String currLine;
		
		if(args.length !=1)
		{			
			throw new RuntimeException("Please provide all arguments");
		}
		else
		{
			inputfile = args[0];
		}

		
		FileProcessor fprObj = new FileProcessor(inputfile);
		TreeBuilder trbObj = new TreeBuilder();
		
		Hashtable ht = new Hashtable();
		Node orig_node = null;
		
		
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
		
		
		//orig_node = trbObj.insert(bnumber, course);
	}

}
