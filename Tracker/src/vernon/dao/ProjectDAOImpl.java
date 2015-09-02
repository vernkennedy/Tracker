package vernon.dao;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.sql.DataSource;

import vernon.model.Project;

import org.springframework.dao.DataAccessException;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.RowMapper;

/*
 * ProjectDAO interface implementation
 * @author Vernon Zidana
 */

public class ProjectDAOImpl implements ProjectDAO {

	private JdbcTemplate jdbcTemplate;
	
	public ProjectDAOImpl(DataSource dataSource) {
		jdbcTemplate = new JdbcTemplate(dataSource);
	}

	@Override
	public void saveOrUpdate(Project project) {
		if (project.getId() > 0) {
			// Update
			String sql = "UPDATE projectportfolio SET name=?, cost=?, duration=?, "
						+ "issues=?,type=?,completed=?,businessobjective=?, description=? WHERE project_id=?";
			jdbcTemplate.update(sql, project.getName(), project.getCost(),
					project.getDuration(), project.getIssues(),project.getType(),project.getCompleted(),project.getBusinessobjective(),project.getDescription(), project.getId());
		} else {
			// Save
			String sql = "INSERT INTO projectportfolio (name, cost, duration, issues,type,completed,businessobjective,description)"
						+ " VALUES (?, ?, ?, ?,?,?,?,?)";
			jdbcTemplate.update(sql, project.getName(), project.getCost(),
					project.getDuration(), project.getIssues(),project.getType(),project.getCompleted(),project.getBusinessobjective(), project.getDescription());
		}
		
	}

	@Override
	public void delete(int projectId) {
		String sql = "DELETE FROM projectportfolio WHERE project_id=?";
		jdbcTemplate.update(sql, projectId);
	}

	@Override
	public List<Project> list() {
		String sql = "SELECT * FROM projectportfolio";
		List<Project> listProjects = jdbcTemplate.query(sql, new RowMapper<Project>() {

			@Override
			public Project mapRow(ResultSet rs, int rowNum) throws SQLException {
				Project oneProject = new Project();
	
				oneProject.setId(rs.getInt("project_id"));
				oneProject.setName(rs.getString("name"));
				oneProject.setCost(rs.getInt("cost"));
				oneProject.setDuration(rs.getInt("duration"));
				oneProject.setIssues(rs.getInt("issues"));
				oneProject.setType(rs.getString("type"));
				oneProject.setCompleted(rs.getString("completed"));
				oneProject.setBusinessobjective(rs.getString("businessobjective"));
				oneProject.setDescription(rs.getString("description"));
				
				return oneProject;
			}
			
		});
		
		return listProjects;
	}

	@Override
	public Project get(int projectId) {
		String sql = "SELECT * FROM projectportfolio WHERE project_id=" + projectId;
		return jdbcTemplate.query(sql, new ResultSetExtractor<Project>() {

			@Override
			public Project extractData(ResultSet rs) throws SQLException,
					DataAccessException {
				if (rs.next()) {
					Project project = new Project();
										
					project.setId(rs.getInt("project_id"));
					project.setName(rs.getString("name"));
					project.setCost(rs.getInt("cost"));
					project.setDuration(rs.getInt("duration"));
					project.setIssues(rs.getInt("issues"));
					project.setType(rs.getString("type"));
					project.setCompleted(rs.getString("completed"));
					project.setBusinessobjective(rs.getString("businessobjective"));
					project.setDescription(rs.getString("description"));
					return project;
				}
				
				return null; 
			}
			
		});
	}

}
