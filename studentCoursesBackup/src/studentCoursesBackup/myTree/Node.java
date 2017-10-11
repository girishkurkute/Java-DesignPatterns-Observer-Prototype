package studentCoursesBackup.myTree;

public class Node implements Cloneable,SubjectI,ObserverI {

	 public int key;
	 public String value;
	 public Node left, right;
	 public Node refrArrayList[] = null;
	 
	 /**
	  * constructor to initialize data members
	  * @param key A Bnumber
	  * @param value A course values
	  */
	public Node(int key, String value)
	{
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		this.refrArrayList = new Node[2];
	}
	
	/**
	 * clone method used to create clone of original node
	 * @return Node object 
	 */
public Node clone() throws CloneNotSupportedException 
{
		
		Node cloneObj = (Node) super.clone();
		cloneObj.key = key;
		cloneObj.value = value;
		cloneObj.left = left;
		cloneObj.right = right;
		cloneObj.refrArrayList = new Node[2];
		return cloneObj;
}

/**
 * Method used to register the observers
 * @param b1 backup object 1 of type Node 
 * * @param  b2 backup object 2 of type Node 
 * @returns nothing
 */
public void registerObserver(Node b1, Node b2) {
	// TODO Auto-generated method stub
	refrArrayList[0]=b1;
	refrArrayList[1]=b2;
}

/**
 * Method used to de-register the observers
 * @param o backup object which you want to delete 	
 * @returns nothing
 */
public void removeObserver(Node o) {
	// TODO Auto-generated method stub
	refrArrayList[0]=null;
	refrArrayList[1]=null;

}

/**
 * notifyObservers Method used to notify the observers when changes are made into original node.This method calls update() method to make changes into backup objects
 * @param course is a updated course value which has to be change in backup nodes  
 * @returns nothing
 */
public void notifyObservers(String course) {
	// TODO Auto-generated method stub
	Node T1;
	for (Node fs : refrArrayList)
	{
		T1 = fs;
		T1.update(course);
	}
	
}

/**
 * update Method used to change the backup nodes as per the original nodes
 * @param updateCourse is a course value needs to be updated in backup node
 * @returns nothing
 */
public void update(String updateCourse) {
	// TODO Auto-generated method stub
	this.value = updateCourse;
}

}
