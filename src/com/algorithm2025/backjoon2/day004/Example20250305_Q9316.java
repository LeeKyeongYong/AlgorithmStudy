import java.util.Scanner;

public class Example20250305_Q9316 { // Hello Judge
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= N; i++) {
            sb.append("Heelo World, Judge ").append(i).append("!\n");
        }
        System.out.print(sb);
    }
}
