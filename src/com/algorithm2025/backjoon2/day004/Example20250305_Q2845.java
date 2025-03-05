import java.util.Scanner;

public class Example20250305_Q2845 { // 파티가 끝나고 난 뒤
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int L = sc.nextInt();
        int P = sc.nextInt();
        int totalPeople = L * P;

        for (int i = 0; i < 5; i++) {
            System.out.print(sc.nextInt() - totalPeople + " ");
        }
    }
}
