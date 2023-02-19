public class Main {
    static boolean[] check = new boolean[10001];
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();

        for(int i=1; i<10001; i++) {
            if(!check[i]) {
                creator(i);
            }
        }

        for(int i=1; i<10001; i++) {
            if(!check[i]) {
                sb.append(i).append("\n");
            }
        }

        System.out.println(sb.toString());
    }

    static void creator(int number) {
        int sum = number;
        while(number!=0) {
            sum += number%10;
            number /= 10;
        }

        if(sum<10001) {
            check[sum] = true;
            creator(sum);
        }
    }
}