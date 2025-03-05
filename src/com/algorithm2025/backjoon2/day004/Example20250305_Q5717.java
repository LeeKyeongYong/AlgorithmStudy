import java.util.Scanner;

public class Example20250305_Q5717 { // 상근이의 친구들
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // M과 F가 모두 0이면 종료
        while (true) {
            int M = sc.nextInt();
            int F = sc.nextInt();

            if (M == 0 && F == 0) {
                break; // 종료 조건
            }
            System.out.println(M + F); // 합 출력
        }
    }
}
