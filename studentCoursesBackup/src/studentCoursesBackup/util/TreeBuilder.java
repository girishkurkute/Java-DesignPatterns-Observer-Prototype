package studentCoursesBackup.util;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;

import studentCoursesBackup.myTree.Node;

//I referred below links for BST
//http://www.geeksforgeeks.org/binary-search-tree-set-1-search-and-insertion/
//http://www.geeksforgeeks.org/binary-search-tree-set-2-delete/
public class TreeBuilder implements FileDisplayInterface {

	public Node root;
	public Node currNode;
	public Node currentDeleteNode;
	public ArrayList<String> originalTreeDataValues = new ArrayList<String>();
	
	/**
	 * constructor to initialize data members
	 */
	public TreeBuilder()
	{
		root = null;
		currNode = null;				
	}
	
	/**
	 * insert method to call a method which search for a current Bnumber is present in tree or not.If it present then it adds the course 
	 * into existing node and if Bnumber is not present then it create a new node.
	 * @param key a Bnumber to be added
	 * @param value a course value need to be added
	 * @return a current Node object
	 */
	public Node insert(int key, String value)
	{
		root = insertData(root, key , value);
		return currNode;
	}
	
	/**
	 * function to insert data into node
	 * @param root a current root node object
	 * @param key a Bnumber to be added
	 * @param value a course value need to be added
	 * @return a current root node objectf
	 */
	Node insertData(Node root, int key, String value)
	{
		//when tree is empty first node created
		if(root == null)
		{
			root = new Node(key,value);
			currNode = root;
			return root;
		}
		

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
	
	
	
	/**
	 * delete method to call a method which search for a current Bnumber is present in tree or not.If it present then it delete the course 
	 * into existing node and if Bnumber is not present then it skip.
	 * @param key a Bnumber to be deleted
	 * @param value a course value need to be deleted
	 * @return a current Node object
	 */
	public Node delete(int key, String value)
	{		
		root = deleteNodeValue(root, key , value);
		return currentDeleteNode;
		
	}
	
	/**
	 * function to delete the course from node
	 * @param root a current root node object
	 * @param key a Bnumber to be deleted
	 * @param value a course value need to be deleted
	 * @return return a current root Node object
	 */
	private Node deleteNodeValue(Node root, int key, String value) {
		// TODO Auto-generated method stub
		
		Node tempRoot;		
		//check if tree is empty
		if(root == null)
		{
			return root;
		}
		
		//check for left node
		if(key < root.key)
		{
			
			root.left = deleteNodeValue(root.left, key , value);
		}
		//check for right node
		else if(root.key < key)
		{
			root.right = deleteNodeValue(root.right, key , value);
		}
		else
		{
			//check if node has child or not
			if(root.left == null)
			{
				//when left child is empty
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
				//when two childs
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
				//when right child is empty or not
				if (root.left == null)
				{
					//no child
					String temp = root.value;
					if(!temp.isEmpty())
					{
						temp = temp.replace(value, "");
					
						root.value = temp;
					}
					
					currentDeleteNode=root;
					return root;
				}
				//when two childs
				else
				{			
					//when node has two childs
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
	
	/**
	 * printNodes method used to retrieve the nodes values
	 * @param relt a object of Result
	 * @param root a root node of a tree
	 * @throws FileNotFoundException
	 */
	public void printNodes(Results relt,Node root) throws IOException {
		// TODO Auto-generated method stub
		getTreeValues(root);
		relt.writeToFile(originalTreeDataValues);
	}

	/**
	 * getTreeValues method used to add node values into Arraylist in ascending order
	 * @param root a root node of a tree
	 * @returns nothing
	 */
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
