import java.util.Scanner;

public class Example20250305_Q10797 { // 10부제
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int check = sc.nextInt();
        int count = 0;

        // 입력 받은 5개의 값 중 check와 동일한 값의 개수를 센다
        for (int i = 0; i < 5; i++) {
            if (check == sc.nextInt()) {
                count++;
            }
        }

        // count 출력
        System.out.println(count);
    }
}
