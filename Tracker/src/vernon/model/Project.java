/*
 * Our Project Model
 * @author Vernon Zidana
 */


package vernon.model;

public class Project {
	private int id;
	private String name;
	private int cost;
	private int duration;
	private int issues;
	private String type;
	private String completed;
	private String businessobjective;
	private String description;
	

	public Project() {
	}


	@Override
	public String toString() {
		return "Project [id=" + id + ", name=" + name + ", cost=" + cost
				+ ", duration=" + duration + ", issues=" + issues + ", type="
				+ type + ", completed=" + completed + ", businessobjective="
				+ businessobjective + ", description=" + description + "]";
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public int getCost() {
		return cost;
	}


	public void setCost(int cost) {
		this.cost = cost;
	}


	public int getDuration() {
		return duration;
	}


	public void setDuration(int duration) {
		this.duration = duration;
	}


	public int getIssues() {
		return issues;
	}


	public void setIssues(int issues) {
		this.issues = issues;
	}


	public String getType() {
		return type;
	}


	public void setType(String type) {
		this.type = type;
	}


	public String getCompleted() {
		return completed;
	}


	public void setCompleted(String completed) {
		this.completed = completed;
	}


	public String getBusinessobjective() {
		return businessobjective;
	}


	public void setBusinessobjective(String businessobjective) {
		this.businessobjective = businessobjective;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	
	
}
