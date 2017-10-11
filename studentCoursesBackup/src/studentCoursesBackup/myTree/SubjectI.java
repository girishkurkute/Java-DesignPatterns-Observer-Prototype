package studentCoursesBackup.myTree;

public interface SubjectI {
	
	/**
	 * Method used to register the observers
	 * @param b1 backup object 1 of type Node 
	 * * @param  b2 backup object 2 of type Node 
	 * @returns nothing
	 */
	public void registerObserver(Node b1 , Node b2); 
	
	/**
	 * Method used to de-register the observers
	 * @param o backup object which you want to delete 	
	 * @returns nothing
	 */
	public void removeObserver(Node o);
	
	/**
	 * notifyObservers Method used to notify the observers when changes are made into original node.This method calls update() method to make changes into backup objects
	 * @param temp is a updated course value which has to be change in backup nodes  
	 * @returns nothing
	 */
	public void notifyObservers(String temp);
	
	

}
