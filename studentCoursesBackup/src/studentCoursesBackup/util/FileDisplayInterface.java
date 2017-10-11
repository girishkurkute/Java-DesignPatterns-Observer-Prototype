package studentCoursesBackup.util;

import java.io.FileNotFoundException;
import java.io.IOException;

import studentCoursesBackup.myTree.Node;
import studentCoursesBackup.util.Results;

public interface FileDisplayInterface {

	/**
	 * printNodes method used to retrieve the nodes values
	 * @param r a object of Result
	 * @param root a root node of a tree
	 * @throws FileNotFoundException
	 * @throws IOException 
	 */
	public void printNodes(Results r, Node root) throws FileNotFoundException, IOException;
}
