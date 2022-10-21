public class TestFour {

    public static void main(String[] args) {
        int[] A = {1,3,5,2,7,2,1,3,5,2,2};
        long res = countSubArrays(A,1,5);
        // int[] A = {1,1,1,1};
        // long res = countSubArrays(A,1,1);
        // System.out.println(res);
    }


    public static long countSubArrays(int[] A, int minK , int maxK ){
        long res = 0, jbad = -1, jmin = -1, jmax = -1, n = A.length;
        for(int i = 0; i < n ;++i){
            if(A[i] < minK || A[i] > maxK) jbad = i;
            if(A[i] == minK) jmin = i;
            if(A[i] == maxK) jmax = i;
            res += Math.max(0, Math.min(jmin, jmax) - jbad);
            System.out.println("jbad = " + jbad);
            System.out.println("jmin = " + jmin);
            System.out.println("jmax = " + jmax);
            System.out.println("res  = "+ res);
            System.out.println("-----------------------");
        }
        return res;
    }

}
