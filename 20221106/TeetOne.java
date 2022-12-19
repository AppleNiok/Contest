import java.util.Stack;

public class TeetOne {
    
    public static void main(String[] args) {
        // int[] nums = {1,2,2,1,1,0};
        // int[] res = applyOperations(nums);
        // for(int r : res){
        //     System.out.println(r);   
        // }
        System.out.println('E' - 'e');
        System.out.println('A' - 'a');
        
    }

    public static int[] applyOperations(int[] nums) {
        Stack<Integer> stack = new Stack();
        for(int num : nums){
            if(stack.isEmpty()){
                stack.push(num);
            }else{
                int temp = stack.pop();
                System.out.println(temp);
                System.out.println(num);
                if(temp == num){
                    temp = num * 2;
                    stack.push(temp);
                }else{
                    stack.push(temp);
                    stack.push(num);
                }
            }
        }
        
        Stack<Integer> stack2 = new Stack();
        while(!stack.isEmpty()){
            stack2.push(stack.pop());
        }
        int[] res = new int[nums.length];
        int count = 0;
        while(!stack2.isEmpty()){
            res[count] = stack2.pop();
            count++;
        }
        return res;
    }
}
