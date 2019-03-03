package sms;

public class StudentInfo implements Comparable<StudentInfo> {
	private String name;
	private double percentage;
	private Integer Id;

	public StudentInfo(String name, double percentage, Integer Id) {
		this.name = name;
		this.percentage = percentage;
		this.Id = Id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public double getPercentage() {
		return percentage;
	}

	public void setPercentage(double percentage) {
		this.percentage = percentage;
	}

	public Integer getId() {
		return Id;
	}

	public void setId(Integer id) {
		Id = id;
	}

	public int compareTo(StudentInfo other) {
		if (this.getPercentage() > other.getPercentage()) {
			return -1;
		} else if (this.getPercentage() < other.getPercentage()) {
			return 1;
		} else {
			return other.getId() - this.getId();
		}

	}

	@Override
	public boolean equals(Object obj) {
		if (obj instanceof StudentInfo) {
			StudentInfo other = (StudentInfo) obj;
			return this.getName().equals(other.getName()) && this.getId().equals(other.getId())
				&& Double.doubleToLongBits(this.getPercentage()) == Double.doubleToLongBits(other.getPercentage());
		}
		return false;
	}
}
