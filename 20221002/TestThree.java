import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.PriorityQueue;

public class TestThree {
    public List<String> topKFrequent(String[] words, int k) {
        List<String> result = new LinkedList<>();
        Map<String , Integer> tempMap = new HashMap<>();
        Integer zero =0;
        for(String word : words){
            tempMap.put(word , tempMap.getOrDefault(word, 0 ) + 1);
        }
        
        PriorityQueue<Map.Entry<String, Integer>> pq = new PriorityQueue<>(
            (a , b) -> a.getValue() == b.getValue() ? b.getKey().compareTo(a.getKey()) : a.getValue() - b.getValue()
        );
        
        for(Map.Entry<String,Integer> entry : tempMap.entrySet()){
            pq.offer(entry);
            if(pq.size() > k)
                pq.poll();
        }
        
        while(!pq.isEmpty()){
            result.add(pq.poll().getKey());
        }
        
        return result;
    }
}
