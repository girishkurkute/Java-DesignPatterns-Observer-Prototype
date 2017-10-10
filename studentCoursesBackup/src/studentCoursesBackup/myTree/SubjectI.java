package studentCoursesBackup.myTree;

public interface SubjectI {
	
	public void registerObserver(Node o1 , Node o2); 
	
	public void removeObserver(Node o);
	public void notifyObservers(String temp);
	
	

}
