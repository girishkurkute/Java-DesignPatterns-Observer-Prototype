package studentCoursesBackup.myTree;

public class Node {

	 public int key;
	 public String value;
	 public Node left, right;
	 public Node refArrayList[] = null;
	 
	public Node(int key, String value)
	{
		this.key = key;
		this.value = value;
		this.left = null;
		this.right = null;
		//this.refArrayList = new ArrayList<Node>();
		this.refArrayList = new Node[2];
	}
}
