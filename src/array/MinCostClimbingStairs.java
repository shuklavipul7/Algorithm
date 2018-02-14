package array;
//Q:746
/*On a staircase, the i-th step has some non-negative cost cost[i] assigned (0 indexed).

Once you pay the cost, you can either climb one or two steps. You need to find minimum cost to reach the top of the floor, and you can either start from the step with index 0, or the step with index 1.*/

public class MinCostClimbingStairs {

	public static void main(String[] args) {
		MinCostClimbingStairs m = new MinCostClimbingStairs();
		int[]arr = {0,1,100,0};
		System.out.println(m.minCostClimbingStairs(arr));
	}
	
	public int minCostClimbingStairs(int[] cost) {
        int totalCost = 0;
        int len = cost.length;
        int i=0;
        
        if(len==4){
        	if(cost[0]<cost[1]){
        		totalCost = totalCost+cost[0];
        		totalCost = totalCost+cost[2];
        	}else{
        		totalCost = totalCost+cost[1];
        	}
        	
        	return totalCost;
        }
        
        while(i<len){
            if(i+1<len && i+2<len){
                if((cost[i]+cost[i+2])<=cost[i+1]){
                    totalCost = totalCost + cost[i]+cost[i+2];
                    i = i+3;
                }else{
                    totalCost = totalCost + cost[i+1];
                    i = i+2;
                }
            }else{
                if(i+1 < len){
                    if(cost[i]<cost[i+1]){
                        totalCost = totalCost + cost[i];
                    }else{
                        totalCost = totalCost + cost[i+1];
                    }
                }
                break;
            }
        }
        return totalCost;
    }

}
