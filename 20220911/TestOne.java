import java.util.PriorityQueue;

public class TestOne {
    
    public static void main(String[] args) {
        int[] nums = {0,1,2,2,4,4,1};
        int res = test(nums);
        System.out.println(res);

    }

    private static  int test(int[] nums){
        PriorityQueue<Integer> pq = new PriorityQueue<>();

        for(int num : nums){
            pq.offer(num);
        }  
        int res = -1;
        int[] temp = new int[10];
        for(int i = 0;i < temp.length; i= i + 2){
            
        }
        
       

        return res;
    }


}
