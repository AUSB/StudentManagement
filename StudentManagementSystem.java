package sms;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class StudentManagementSystem {
	/*
	 * Each entry in a 'students' map contains
	 * a unique  name, course id and its associated grade.
	 */
	HashMap<Integer, CourseInfo> courses;
	/*
	 * Each entry in a 'courses' map contains
	 * a unique id and its associated information object.
	 */
	HashMap<String, StudentInfo> students;

	/* All methods must be implemented via ’courses’ and ’students’ */
	/**
	 * Initialize an empty database.
	 */
	public StudentManagementSystem() {
		this.courses = new HashMap<>();
		this.students = new HashMap<>();

	}
	/**
	 * Add a new student entry.
	 * @param id - id of the student
	 * @param info - information object of the  student
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing student id
	 */

	public void addStudent(String id, StudentInfo info) throws IdAlreadyExistsExceptoin {
		if (students.containsKey(id)) {
			throw new IdAlreadyExistsExceptoin("The student has already existed.");
		}
		students.put(id, info);
	}
	/**
	 * Remove an existing student entry.
	 * @param id - id of the student
	 * @throws IdNotFoundException if 'id' is not an existing student id
	 */
	public void removeStudent(String id) throws IdNotFoundException {
		if (!(students.containsKey(id))) {
			throw new IdNotFoundException("The student doesnt exist");
		}
		students.remove(id);
	}
	/**
	 * Add a new course entry.
	 * @param id id of the course
	 * @param info information object of the course
	 * @throws IdAlreadyExistsExceptoin if 'id' is an existing course id
	 */
	public void addCourse(int id, CourseInfo info) throws IdAlreadyExistsExceptoin {
		if (courses.containsKey(id)) {
			throw new IdAlreadyExistsExceptoin("The course has already existed.");
		}
		courses.put(id, info);

	}/**
	 * Remove an existing course entry.
	 * @param id id of some course
	 * @throws IdNotFoundException if 'id' is not an existing course
	 */

	public void removeCourse(int id) throws IdNotFoundException {
		if (!(courses.containsKey(id))) {
			throw new IdNotFoundException("The course doesnt exist");
		}
		courses.remove(id);
	}/**
	 * Change the course of student with id 'eid' to a new course with id 'did'.
	 * 
	 * You can assume that 'did' denotes a course different from
	 * the current course of the student denoted by 'eid'.
	 * @param eid id of some student
	 * @param did id of some course
	 * @throws IdNotFoundException if either eid is a non-existing student id or did is a non-existing course id.
	 */

	public void changeCourse(String eid, int did) throws IdNotFoundException {
		if (!(students.containsKey(eid)) || !(courses.containsKey(did))) {
			throw new IdNotFoundException("id doesnt exist");
		}
		students.get(eid).setId(did);
	}
	/**
	 * Retrieve the name of student with id 'id'.
	 * @param id id of some student
	 * @return name of the student with id 'id'
	 * @throws IdNotFoundException if 'id' is not an existing student id
	 */
	public String getStudentName(String id) throws IdNotFoundException {
		if (!(students.containsKey(id))) {
			throw new IdNotFoundException("id doesnt exist");
		}
		return students.get(id).getName();
	}
	/**
	 * Retrieve the names of all students of the course with id 'id'.
	 * If 'id' a non-existing course id, then return an empty list.
	 * @param id id of some course
	 * @return List of names of students whose course has id 'id'
	 */
	public ArrayList<String> getStudentNames(int id) {
		ArrayList<String> listStu = new ArrayList<String>();
		for (StudentInfo si : students.values()) {
			if (si.getId() == id) {
				listStu.add(si.getName());
			}
		}
		return listStu;
//		ArrayList<String> names = new ArrayList<>();
//		for(String eid : students.keySet()) {
//			StudentInfo einfo = students.get(eid);
//			if(einfo.getId().equals(id)) {
//				names.add(einfo.getName());
//			}
//		}
//		return names;
	}
	/**
	 * Retrieve students course information object.  
	 * @param id id of some student
	 * @return The information object of the students course
	 * @throws IdNotFoundException if 'id' is not an existing student id
	 */
	public CourseInfo getCourseInfo(String stuId) throws IdNotFoundException {
		if (!(students.containsKey(stuId))) {
			throw new IdNotFoundException("The student doesnt exist.");
		}
		return courses.get(students.get(stuId).getId());
	}
	/**
	 * Retrieve a list, sorted in increasing order, 
	 * the information objects of all stored students.
	 * 
	 * Hints: 
	 * 1. Override the 'compareTo' method in StudentInfo class. 
	 * 2. Look up the Arrays.sort method in Java API. 
	 * @return A sorted list of information objects of all students.
	 */
	

	public StudentInfo[] getSortedStudentInfo() {
//		StudentInfo[] sInfo = new StudentInfo[students.size()];
//		students.values().toArray(sInfo);
//		Arrays.sort(sInfo);
//		return sInfo;
		ArrayList<StudentInfo> list = new ArrayList<>();
		for (String eid : students.keySet()) {
			StudentInfo einfo = students.get(eid);
			list.add(einfo);
		}
		StudentInfo[] sortedList = new StudentInfo[list.size()];
		for (int i = 0; i < sortedList.length; i++) {
			sortedList[i] = list.get(i);
		}
		Arrays.sort(sortedList);
		return sortedList;
	}

	/**
	 * Retrieve the average percentage of all students in course with id 'id'.
	 * @param id id of some course
	 * @return average percentage of all students in course with id 'id'
	 * @throws IdNotFoundException if id is not an existing course id
	 */
	public double getAveragePercentage(int id) throws IdNotFoundException {
		if (!(courses.containsKey(id))) {
			throw new IdNotFoundException("The course doesnt exist");
		}
		double sum = 0;
		int count = 0;
		for (StudentInfo sinfo : students.values()) {
			if (sinfo.getId().equals(id)) {
				sum += sinfo.getPercentage();
				count++;
			}
		}
		return sum / count;
//		if(!courses.containsKey(id)) {
//			throw new IdNotFoundException("Course id " + id + " does not exist");
//		}
//		else {
//			int count = 0;
//			double total = 0;
//			for(String eid : students.keySet()) {
//				StudentInfo einfo = students.get(eid);
//				Integer did = einfo.getId();
//				if(did.equals(id)) {
//					count ++;
//					total += einfo.getPercentage();
//				}
//			}
//			return total / count;
//		}
	}

}
