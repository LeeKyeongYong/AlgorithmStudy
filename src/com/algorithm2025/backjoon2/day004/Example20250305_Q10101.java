import java.util.Scanner;

public class Example20250305_Q10101 { // 삼각형 외우기
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // 삼각형의 내각 합이 180이 아니면 Error 출력
        if (A + B + C != 180) {
            System.out.println("Error");
            return;
        }

        // 모든 각이 60이면 Equilateral (정삼각형)
        if (A == 60 && B == 60 && C == 60) {
            System.out.println("Equilateral");
        }
        // 두 각이라도 같으면 Isosceles (이등변삼각형)
        else if (A == B || B == C || A == C) {
            System.out.println("Isosceles");
        }
        // 나머지 경우 Scalene (부등변삼각형)
        else {
            System.out.println("Scalene");
        }
    }
}
