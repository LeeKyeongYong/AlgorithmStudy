import java.util.Scanner;

public class Example20250305_Q2530 { // 인공지능 시계
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int h = sc.nextInt();
        int m = sc.nextInt();
        int s = sc.nextInt();
        int time = sc.nextInt();

        // 초 계산
        s += time;

        // 분으로 변환
        m += s / 60;
        s %= 60;  // 나머지 초

        // 시간으로 변환
        h += m / 60;
        m %= 60;  // 나머지 분

        // 24시간제로 맞추기
        h %= 24;

        // 결과 출력
        System.out.println(h + " " + m + " " + s);
    }
}
