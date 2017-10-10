package studentCoursesBackup.myTree;

public class Node implements Cloneable,SubjectI {

	 public int key;
	 public String value;
	 public Node left, right;
	 public Node refrArrayList[] = null;
	 
	public Node(int key, String value)
	{
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		//this.refArrayList = new ArrayList<Node>();
		this.refrArrayList = new Node[2];
	}
	
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

public void registerObserver(Node o1, Node o2) {
	// TODO Auto-generated method stub
	refrArrayList[0]=o1;
	refrArrayList[1]=o2;
}
}
