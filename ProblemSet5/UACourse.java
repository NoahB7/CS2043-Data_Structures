
/********************************
Name: Noah Buchanan
Username: ua203
Problem Set: PS5
Due Date: July 7, 2020
********************************/

public class UACourse {
	
	private int courseId;
	private String courseName;
	private String courseDescription;
	UACourse next;
	UACourse prev;
	private int accessCount = 0;
	
	public UACourse(int courseId, String courseName, String courseDescription) {
		this.courseId = courseId;
		this.courseName = courseName;
		this.courseDescription = courseDescription;
	}
	
	public String toString() {
		return getCourseId() + " " + getCourseName() + " " + getAccessCount();
	}
	
	
	public int getCourseId() {
		return courseId;
	}
	public void setCourseId(int courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getCourseDescription() {
		return courseDescription;
	}
	public void setCourseDescription(String courseDescription) {
		this.courseDescription = courseDescription;
	}
	public int getAccessCount() {
		return accessCount;
	}
	public void setAccessCount(int accessCount) {
		this.accessCount = accessCount;
	}
	

}
