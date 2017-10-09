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

	Node insertData(Node root, int key, String value)
	{
		//when tree is empty first node created
		if(root == null)
		{
			root = new Node(key,value);
			currNode = root;
			return root;
		}
		
		//when Bnumber is present in tree.Addding course values into it
		/*if(key == root.key)
		{
			String temp = (String) root.value;
			int indexOfChar = temp.indexOf(value.toString());
			if(indexOfChar == -1)
			{
			temp = temp + value;
			root.value = temp;
			currentNode = root;
			}
		}*/
		//checking left child of root
		 if(key< root.key)
		{
			
			if(root.left != null)
			{
				root.left = insertData(root.left, key , value);
			}
			//creating left child
			else
			{
				root.left = new Node(key,value);
				currNode = root.left;
			}
		}
		//checking right child of root
		else if(key>root.key)
		{
			
			if(root.right != null)
			{
				root.right = insertData(root.right, key , value);
			}
			//creating right child
			else
			{
				root.right = new Node(key,value);
				currNode = root.right;
			}
		}
		return root;
		
	}
	
	public void Display()
	{
		System.out.println("Displaying tree values ");
		
		DisplayTreeValues(root);
	}
	
	public void DisplayTreeValues(Node root)
	{
		if(root != null)
		{
			DisplayTreeValues(root.left);
			System.out.println(root.key);
			System.out.println(root.value);
			
			DisplayTreeValues(root.right);
		}
	}
}
