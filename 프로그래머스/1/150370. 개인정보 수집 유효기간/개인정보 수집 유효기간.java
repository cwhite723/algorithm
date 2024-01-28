import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

class Solution {
    LocalDate today;
    Map<String, Integer> terms;
    
    public int[] solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy.MM.dd");
        this.today = LocalDate.parse(today, formatter);
        this.terms = new HashMap<>();
        
        for (int i = 0; i < terms.length; i++) {
            String[] tokens = terms[i].split(" ");
            this.terms.put(tokens[0], Integer.valueOf(tokens[1]));
        }
        
        for (int i = 0; i < privacies.length; i++) {
            String[] tokens = privacies[i].split(" ");
            LocalDate collectDate = LocalDate.parse(tokens[0], formatter);
            LocalDate destroyDate = calculateDate(collectDate, tokens[1]);
            if (destroyDate.isAfter(this.today)) continue;
            answer.add(i + 1);
        }
        
        return answer.stream()
            .mapToInt(Integer::intValue)
            .toArray();
    }
    
    private LocalDate calculateDate(LocalDate collectDate, String type) {
        Integer term = terms.get(type);
        return collectDate.plusMonths(term);
    }
}