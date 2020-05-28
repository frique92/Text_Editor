import java.util.Arrays;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int sum = 0;
        int count = scanner.nextInt();

        for (int i = 0; i < count; i++) {
            int num = scanner.nextInt();
            if (num % 6 == 0)
                sum += num;
        }

        System.out.println(sum);
    }
}