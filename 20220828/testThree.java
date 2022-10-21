public class testThree {

    public static void main(String[] args) {
        /*["G","P","GP","GG"]
            [2,4,3] */
        String[] garbage = {"G","P","GP","GG"};
        int[] travel = {2,4,3};
        int res = garbageCollection(garbage, travel);
        System.out.println(res);
    }

    public static int garbageCollection(String[] garbage, int[] travel) {
        int[][] temp = new int[garbage.length][26];
        for(int i = 0;i < garbage.length;i++){
            for(char c : garbage[i].toCharArray()){
                temp[i][c - 'A']++;
            }
        }
        char[] gg = {'M','P','G'};
        int res = 0;
        for(char g : gg){
            res += search(temp,travel,g - 'A');
        }
        return res;
    }
    
    private static int search(int[][] temp, int[] travel,int num){
        int res = 0;
        for(int i = 0;i<temp.length;i++){
            // System.out.println("i : "+ i +",num : "+num+",result : "+temp[i][num]);
            if(i == 0 && temp[i][num] != 0){
                res += temp[i][num];
            }else if(temp[i][num] != 0){
                res += temp[i][num];
                res += travel[i - 1];
            }
            System.out.println("i : "+ i +",num : "+num+",res :" + res);
        }
        return res;
    }
}
