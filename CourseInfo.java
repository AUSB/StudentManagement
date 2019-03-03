package sms;

public class CourseInfo {
	private String name;
	private String instructor;

	public CourseInfo(String name, String instructor) {
		this.name = name;
		this.instructor = instructor;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getInstructor() {
		return instructor;
	}

	public void setInstructor(String instructor) {
		this.instructor = instructor;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof CourseInfo) {
			// o is a SimplePoint2; cast and compare it
			CourseInfo other = (CourseInfo) obj;
			return this.getName().equals(other.getName()) && this.getInstructor().equals(other.getInstructor());
		} else {
			// o is not a SimplePoint2; cannot be equal
			return false;
		}
	}

}
