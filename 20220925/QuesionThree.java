import java.util.Arrays;

public class QuesionThree {
 
    public static void main(String[] args) {
        // int[] nums = {311155,311155,311155,311155,311155,311155,311155,311155,201191,311155};
        int[] nums = {1,2,3,3,2,2};
        int res = longestSubarray(nums);
        System.out.println(res);
    }

    public static int longestSubarray(int[] nums) {
        Arrays.sort(nums);
        int count = 1;
        for(int i = nums.length - 1; i > 1;i--){
            if(nums[i] == nums[i - 1]){
                count++;
                System.out.println("i = " + i + " : " + count);
            }else{
                if(count > 0 ){
                    return count;
                }
                count = 1;
            }
        }
        return count;
        
    }
}
