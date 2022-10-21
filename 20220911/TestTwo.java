import java.util.Arrays;
import java.util.Comparator;

public class TestTwo {
    

    public int minGroups(int[][] intervals) {
        Arrays.sort(intervals,new Comparator<int[]>() {
            public int compare(int[] a, int[] b) {
                return a[0] - b[0];
            }
        });
        
        int count = 0;
        for(int[] interval : intervals){
            int last = interval[1];
            if(interval[0] == 0)  continue;
            for(int[] interval2 : intervals){
                if(interval[0] == 0)  continue;
                if(last < interval2[0]){
                    interval2[0] = 0;
                    last = interval2[1];
                }
            }
        }

        for(int[] interval : intervals){
            if(interval[0] > 0) count++;
        }

        return count;
    }

}
