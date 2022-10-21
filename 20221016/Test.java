import java.util.ArrayList;
import java.util.List;

public class Test{

    public static void main(String[] args) {
        int[] nums = {1,3,5,2,7,5};
        long res = countSubarrays(nums,1,5);
        System.out.println(res);
        int[] numss = {1,1,1,1};
        long ress = countSubarrays(numss,1,1);
        System.out.println(ress);
    }

    public static long countSubarrays(int[] nums, int minK, int maxK) {
        List<Integer> counts = new ArrayList<>();
        int count = 0;
        boolean isArrays = false;
        boolean isbot = minK == maxK ? true : false;
        for(int num : nums){
            if(num == minK){
                isArrays = true;
            }
            
            if(isArrays){
                if(num <= maxK){
                    if(num == maxK){
                        count++;
                    }else if(count > 0){
                        count++;
                    }
                }else{
                    isArrays = false;
                    counts.add(count);
                    count = 0;
                }
            }
        }
        if(count > 0){
            counts.add(count);
        }

        int res = 0;
        for(int c : counts){
            // System.out.println(c);
            res += (c + 1) * c / 2;
        }
        return res;
    }
}