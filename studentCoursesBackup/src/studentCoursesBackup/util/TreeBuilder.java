package studentCoursesBackup.util;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {

	public Node root;
	public Node currNode;
	
	public TreeBuilder()
	{
		root = null;
		currNode = null;				
	}
	
	public Node insert(int key, String value)
	{
		root = insertData(root, key , value);
		return currNode;
	}

	private Node insertData(Node root2, int key, String value) {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
