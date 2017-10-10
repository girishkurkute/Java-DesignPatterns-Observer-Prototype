package studentCoursesBackup.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

public class TreeBuilder {

	public Node root;
	public Node currNode;
	public Node currentDeleteNode;
	public ArrayList<String> originalTreeDataValues = new ArrayList<String>();
	
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
	
	public Node delete(int key, String value)
	{		
		root = deleteNodeValue(root, key , value);
		return currentDeleteNode;
		
	}
	
	
	private Node deleteNodeValue(Node root, int key, String value) {
		// TODO Auto-generated method stub
		
		Node tempRoot;		
		//check if tree is empty
		if(root == null)
		{
			return root;
		}

		if(key < root.key)
		{
			
			root.left = deleteNodeValue(root.left, key , value);
		}
		else if(root.key < key)
		{
			root.right = deleteNodeValue(root.right, key , value);
		}
		else
		{

			
			if(root.left == null)
			{
				if (root.right != null)
				{

					String temp = root.value;
					if(!temp.isEmpty())
					{
						temp = temp.replace(value, "");
						root.value = temp;
					}

					currentDeleteNode=root;
					return root;
				}

				else
				{

					String temp = root.value;
					if(!temp.isEmpty())
					{
						temp = temp.replace(value, "");
						root.value = temp;
					}
					
					currentDeleteNode=root;
					return root;

				}	
			}
			else if (root.right == null)
			{

				if (root.left == null)
				{
		
					String temp = root.value;
					if(!temp.isEmpty())
					{
						temp = temp.replace(value, "");
					
						root.value = temp;
					}
					
					currentDeleteNode=root;
					return root;
				}
				
				else
				{					
					String temp = root.value;
					if(!temp.isEmpty())
					{
						
						temp = temp.replace(value, "");
						root.value = temp;
					}
					currentDeleteNode=root;
					return root;										
				}	
			}
				
		}		
		
		return root;
	}
	
	public void printNodes(Results relt,Node root) throws IOException {
		// TODO Auto-generated method stub
		getTreeValues(root);
		relt.writeToFile(originalTreeDataValues);
	}

	public void getTreeValues(Node root)
	{
		int tempKey;
		String tempCourseValue,temp;
		
		if(root != null)
		{
			getTreeValues(root.left);
			tempKey = root.key;
			tempCourseValue=root.value.toString();
			temp = Integer.toString(tempKey) +":"+ tempCourseValue;
			
			originalTreeDataValues.add(temp);
			getTreeValues(root.right);
		}		
	}
}
