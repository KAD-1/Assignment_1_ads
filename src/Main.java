import java.util.Scanner;
public class Main {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        task1(a);

    }

    public static void task1(int a) {
        if (a < 10) System.out.println(a);
        else {
            task1(a / 10);
            System.out.println(a % 10);
        }
    }
    //test
}