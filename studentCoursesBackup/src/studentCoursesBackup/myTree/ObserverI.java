package studentCoursesBackup.myTree;

public interface ObserverI {
	
	/**
	 * Update method used to make changes into backup nodes as per original nodes
	 * @param updateCouse a course value need to be updated
	 * @returns nothing
	 */
	public void update(String updateCouse); 

}
