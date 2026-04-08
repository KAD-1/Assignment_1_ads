import java.util.*;
public class Main {

    static LinkedList<BankAccount> list = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> bills = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);
    static int id = 1;

    public static void main(String args[]) {

        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount(1, "Ali", 150000);
        arr[1] = new BankAccount(2, "Dina", 220000);
        arr[2] = new BankAccount(3, "Pudge", 100000);
        for (int i = 0; i < 3; i++) {
            System.out.println(arr[i].username + " " + arr[i].balance);
        }
        while (true) {
            System.out.println("1 Bank");
            System.out.println("2 ATM");
            System.out.println("3 Admin");
            System.out.println("4 Exit");
            int x = sc.nextInt();
            if (x == 1) bank();
            if (x == 2) atm();
            if (x == 3) admin();
            if (x == 4) break;
        }
    }

    static void bank() {
        while (true) {
            System.out.println("1 add");
            System.out.println("2 deposit");
            System.out.println("3 withdraw");
            System.out.println("4 show");
            System.out.println("5 bill");
            System.out.println("6 back");

            int x = sc.nextInt();

            if (x == 1) {
                String n = sc.next();
                requests.add(new BankAccount(id++, n, 0));
            }

            if (x == 2) {
                String n = sc.next();
                BankAccount a = find(n);
                if (a != null) {
                    int d = sc.nextInt();
                    a.balance += d;
                    stack.push("dep " + d + " " + n);
                }
            }

            if (x == 3) {
                String n = sc.next();
                BankAccount a = find(n);
                if (a != null) {
                    int w = sc.nextInt();
                    if (a.balance >= w) {
                        a.balance -= w;
                        stack.push("with " + w + " " + n);
                    }
                }
            }

            if (x == 4) {
                for (BankAccount a : list) {
                    System.out.println(a.username + " " + a.balance);
                }
            }

            if (x == 5) {
                String b = sc.next();
                bills.add(b);
            }

            if (x == 6) break;
        }
    }

    static void atm() {
        String n = sc.next();
        BankAccount a = find(n);

        if (a == null) return;

        while (true) {
            System.out.println("1 bal");
            System.out.println("2 with");
            System.out.println("3 back");

            int x = sc.nextInt();

            if (x == 1) {
                System.out.println(a.balance);
            }

            if (x == 2) {
                int w = sc.nextInt();
                if (a.balance >= w) {
                    a.balance -= w;
                    stack.push("atm " + w + " " + n);
                }
            }

            if (x == 3) break;
        }
    }

    static void admin() {
        while (true) {
            System.out.println("1 ok acc");
            System.out.println("2 show req");
            System.out.println("3 pay bill");
            System.out.println("4 show bills");
            System.out.println("5 stack");
            System.out.println("6 back");

            int x = sc.nextInt();

            if (x == 1) {
                if (!requests.isEmpty()) {
                    BankAccount a = requests.poll();
                    list.add(a);
                }
            }

            if (x == 2) {
                for (BankAccount a : requests) {
                    System.out.println(a.username);
                }
            }

            if (x == 3) {
                if (!bills.isEmpty()) {
                    System.out.println(bills.poll());
                }
            }

            if (x == 4) {
                for (String b : bills) {
                    System.out.println(b);
                }
            }

            if (x == 5) {
                if (!stack.isEmpty()) {
                    System.out.println(stack.peek());
                    System.out.println(stack.pop());
                }
            }

            if (x == 6) break;
        }
    }

    static BankAccount find(String n) {
        for (BankAccount a : list) {
            if (a.username.equals(n)) return a;
        }
        return null;
    }

}