import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Example20250306_Q5596 { // 시험점수
    public static void main(String[] args) throws IOException {
        // BufferedReader로 변경하여 입력 속도 향상
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 민국이의 점수 입력 및 합계 계산
        StringTokenizer st = new StringTokenizer(br.readLine());
        int mingukScore = calculateSum(st);

        // 만세의 점수 입력 및 합계 계산
        st = new StringTokenizer(br.readLine());
        int manseScore = calculateSum(st);

        // 두 점수 중 큰 값 출력
        System.out.println(Math.max(mingukScore, manseScore));

        // 리소스 정리
        br.close();
    }

    // 점수 합계를 계산하는 메소드
    private static int calculateSum(StringTokenizer st) {
        int sum = 0;
        for (int i = 0; i < 4; i++) {
            sum += Integer.parseInt(st.nextToken());
        }
        return sum;
    }
}