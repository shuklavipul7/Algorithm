import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;

class Solution {
	
	public static void main(String[] args) {
		int[][]arr = {{1,0}};
		Solution sol = new Solution();
		sol.canFinish(2, arr);
	}
	
    Map<Course, List<Course>>map = new HashMap<>();
    Stack<Course>stack = new Stack<>();
    
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i=0;i<prerequisites.length;i++){
            createCourseEntry(prerequisites[i]);
        }
        
        Course firstCourse = new Course();
        firstCourse.val = prerequisites[0][0];
        List<Course>l = map.get(firstCourse);
        
        stack.push(firstCourse);
        while(!stack.isEmpty()){
        	Course cTemp = stack.peek();
        	cTemp.visited = true;
        	List<Course> unvisitedNeighbours = getUnvisitedNodes(cTemp);
        	if(unvisitedNeighbours.size()==0){
        		System.out.print(stack.pop()+" ");
        	}else{
        		stack.push(unvisitedNeighbours.get(0));
        	}
        }
        
        return true;
    }
    
    private List<Course> getUnvisitedNodes(Course cTemp) {
		List<Course>neighbours=map.get(cTemp);
		List<Course>toReturn = new ArrayList<>();
		for(Course neighbour : neighbours){
			if(neighbour.visited==false){
				toReturn.add(neighbour);
			}
		}
		return toReturn;
	}


	class Course{
        int val;
        boolean visited;
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + val;
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
			if (val != other.val)
				return false;
			return true;
		}
		private Solution getOuterType() {
			return Solution.this;
		}
        
        
    }
        
    void createCourseEntry(int[]arr){
        Course c = new Course();
        c.val = arr[0];
        List<Course>preReqList = map.getOrDefault(c,null);
        if(preReqList==null){
            preReqList = new ArrayList<>();
            for(int i=1;i<arr.length;i++){
                Course course = new Course();
                course.visited = false;
                course.val = arr[i];
                preReqList.add(course);
            }
        }else{
            for(int i=1;i<arr.length;i++){
                Course course = new Course();
                course.visited = false;
                course.val = arr[i];
                preReqList.add(course);
                }
            }
        map.put(c,preReqList);
        }
}