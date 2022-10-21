class Solution {
    public String largestPalindromic(String num) {
        int[] f = new int[10];
        for(char c : num.toCharArray()){
            f[c-'0']++;
        }
        StringBuilder sb = new StringBuilder();
        for(int i = 9;i >= 0;i--){
            if(i == 0 && sb.length() == 0)break;
            while(f[i] > 1){
                sb.append(i);
                f[i] -= 2;
            }
        }
        String last = "";
        for(int i = 9;i >= 0;i--){
            if(f[i] > 0){
                last = "" + i;
                break;
            }
        }
        return sb.toString() + last + sb.reverse().toString();
    }
}