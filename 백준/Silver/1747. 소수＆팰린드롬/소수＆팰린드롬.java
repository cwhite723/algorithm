import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());

        while(true) {
            if(isPrime(N)) {
                if(isPalindrome(N)) {
                    System.out.println(N);
                    break;
                }
            }
            N++;
        }
    }

    static boolean isPrime(int N) {
        if(N==1) return false;
        if(N==2||N==3) return true;
        for(int i=2; i<=Math.sqrt(N); i++) {
            if (N % i == 0) return false;
        }
        return true;
    }

    static boolean isPalindrome(int N) {
        StringBuffer sb = new StringBuffer();
        String number = String.valueOf(sb.append(N));
        String newNumber = String.valueOf(sb.reverse());
        if(number.equals(newNumber)) return true;
        else return false;
    }
}