import java.util.*;

class Solution {
    String[] friends;
    String[] gifts;
    Map<String, Integer> friendWithIndex;
    int[][] totalGifts;
    int answer;
    int sumFieldIndex;
    
    public int solution(String[] friends, String[] gifts) {
        this.friends = friends;
        this.gifts = gifts;
        this.answer = 0;
        this.friendWithIndex = new HashMap<>();
        
        // 인덱스로 찾기 위해 Map으로 저장
        for (int i = 0; i < friends.length; i++) {
            friendWithIndex.put(friends[i], i);
        }
        
        this.totalGifts = new int[friends.length + 1][friends.length + 1];
        this.sumFieldIndex = friends.length;

        fillTotalGifts();
        checkMaxGift();
        
        return answer;
    }
    
    private void fillTotalGifts() {
        for (int i = 0; i < gifts.length; i++) {
            String[] gift = gifts[i].split(" ");
            String sender = gift[0];
            String receiver = gift[1];

            int senderIndex = (int) friendWithIndex.get(sender);
            int receiverIndex = (int) friendWithIndex.get(receiver);
            
            totalGifts[senderIndex][receiverIndex] = totalGifts[senderIndex][receiverIndex] + 1;
            totalGifts[senderIndex][sumFieldIndex] = totalGifts[senderIndex][sumFieldIndex] + 1;
            totalGifts[sumFieldIndex][receiverIndex] = totalGifts[sumFieldIndex][receiverIndex] + 1;
        }
    }
    
    private void checkMaxGift() {
        int[] nextMonthReceive = new int[friends.length];

        for (int i = 0; i < friends.length; i++) {
            for (int k = i + 1; k < friends.length; k++) {
                if (totalGifts[i][k] > totalGifts[k][i]) {
                    nextMonthReceive[i] = nextMonthReceive[i] + 1;
                } else if (totalGifts[i][k] < totalGifts[k][i]) {
                    nextMonthReceive[k] = nextMonthReceive[k] + 1;
                } else {
                    int firstScore = totalGifts[i][sumFieldIndex] - totalGifts[sumFieldIndex][i];
                    int secondScore = totalGifts[k][sumFieldIndex] - totalGifts[sumFieldIndex][k];

                    if (firstScore > secondScore) nextMonthReceive[i] = nextMonthReceive[i] + 1;
                    else if (firstScore < secondScore) nextMonthReceive[k] = nextMonthReceive[k] + 1;
                }
            }
        }
        
        this.answer = Arrays.stream(nextMonthReceive)
            .max()
            .orElse(0);
    }
}