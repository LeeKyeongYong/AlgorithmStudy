import java.util.Scanner;

public class Example20250305_Q10156 { // 과자
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int K = sc.nextInt();
        int N = sc.nextInt();
        int M = sc.nextInt();

        // 과자 가격이 부족한 경우 0을 출력하도록 함
        System.out.println(Math.max(K * N - M, 0));
    }
}
