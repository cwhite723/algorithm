import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    static String s;
    static int result = 0;
    
    public static void main(String[] args) throws IOException {
        // 문자열의 첫 문자가 아닌 것들을 바꾸는 게 최선
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        s = br.readLine();
        
        searchDifferent();
        System.out.println(result);
    }

    private static void searchDifferent() {
        // 시작 문자
        Character c = s.charAt(0);
        
        // 만약 이전 문자와 같다면 한 번에 뒤집기가 가능하기 때문에 넘긴다.
        // 이전 문자와 다르면서 첫 글자랑 다르다면 뒤집어야 하기 때문에 result++
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                continue;
            } else if (s.charAt(i) != c) {
                result++;
            }
        }
    }
}
