package graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Stack;

public class TopologicalSort {
	Stack<Course> stack = new Stack<>();

	public static void main(String[] args) {
		TopologicalSort tSort = new TopologicalSort();

		Course ssdi = tSort.createCourse(1, "Software System Design and Implementation");
		Course db = tSort.createCourse(2, "Database Systems");
		Course algos = tSort.createCourse(3, "Algorithms and Datastructures");
		Course kdd = tSort.createCourse(4, "Knowledge Discovery in Databases");
		Course cloud = tSort.createCourse(5, "Cloud Computing");
		Course advanceCloud = tSort.createCourse(6, "Advanced Cloud Computing");
		Course graduation = tSort.createCourse(7, "Graduation");

		Schedule sc = tSort.createSchedule();
		tSort.createDependency(sc, ssdi, graduation);
		tSort.createDependency(sc, db, kdd);
		tSort.createDependency(sc, algos, cloud);
		tSort.createDependency(sc, kdd, graduation);
		tSort.createDependency(sc, cloud, advanceCloud);
		tSort.createDependency(sc, advanceCloud, graduation);
		tSort.printSchedule(sc);
	}

	class Course {
		Integer id;
		String name;
		Course nextCourse;
		boolean completed;

		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((name == null) ? 0 : name.hashCode());
			return result;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Course other = (Course) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (name == null) {
				if (other.name != null)
					return false;
			} else if (!name.equals(other.name))
				return false;
			return true;
		}

		private TopologicalSort getOuterType() {
			return TopologicalSort.this;
		}
	}

	class Schedule {
		Map<Course, LinkedList<Course>> classSchedule = new HashMap<>();
	}

	Schedule createSchedule() {
		Schedule schedule = new Schedule();
		return schedule;
	}

	Course createCourse(int id, String name) {
		Course newCourse = new Course();
		newCourse.id = id;
		newCourse.name = name;
		return newCourse;
	}

	void createDependency(Schedule sc, Course courseToTake, Course nextCourse) {
		LinkedList<Course> listOfNextCourses = sc.classSchedule.getOrDefault(courseToTake, null);
		if (listOfNextCourses == null) {
			listOfNextCourses = new LinkedList<>();
			listOfNextCourses.addFirst(nextCourse);
		} else {
			listOfNextCourses.addFirst(nextCourse);
		}
		sc.classSchedule.put(courseToTake, listOfNextCourses);
	}

	void printSchedule(Schedule sc) {
		for (Course course : sc.classSchedule.keySet()) {
			topologicalSort(sc, course);
		}

		while (!stack.isEmpty()) {
			System.out.print(stack.pop().name + " => ");
		}
	}

	void topologicalSort(Schedule schedule, Course course) {
		if (!course.completed) {
			course.completed = true;
			Course neighbour = null;
			while((neighbour = findNextUnvisitedNeighbour(schedule, course))!=null){
				topologicalSort(schedule, neighbour);
			}
			stack.push(course);
		}
	}

	private Course findNextUnvisitedNeighbour(Schedule schedule, Course course) {
		LinkedList<Course> linkedList = schedule.classSchedule.get(course);
		if (linkedList == null || linkedList.size() == 0) {
			return null;
		}
		for (Course thisCourse : linkedList) {
			if (thisCourse.completed == false) {
				return thisCourse;
			}
		}
		return null;
	}
}
