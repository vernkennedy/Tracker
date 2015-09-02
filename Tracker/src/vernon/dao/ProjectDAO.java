package vernon.dao;

import java.util.List;

import vernon.model.Project;

/*
 * DAO operations for our Project model
 * @author Vernon Zidana
 */

public interface ProjectDAO {
	
	public void saveOrUpdate(Project project);
	
	public void delete(int projectId);
	
	public Project get(int projectId);
	
	public List<Project> list();
}
