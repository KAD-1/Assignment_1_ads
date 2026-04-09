import java.util.*;

public class Main {

    static LinkedList<BankAccount> list = new LinkedList<>();
    static Stack<String> stack = new Stack<>();
    static Queue<String> bills = new LinkedList<>();
    static Queue<BankAccount> requests = new LinkedList<>();

    static Scanner sc = new Scanner(System.in);
    static int id = 4;

    public static void main(String[] args) {

        BankAccount[] arr = new BankAccount[3];
        arr[0] = new BankAccount(1, "Ali", 150000);
        arr[1] = new BankAccount(2, "Sara", 220000);
        arr[2] = new BankAccount(3, "Dina", 100000);

        for (int i = 0; i < 3; i++) {
            list.add(arr[i]);
        }

        System.out.println("=== Predefined Accounts ===");
        for (int i = 0; i < 3; i++) {
            System.out.println((i + 1) + ". " + arr[i].username + " – Balance: " + arr[i].balance);
        }

        while (true) {
            System.out.println("\n=== Main Menu ===");
            System.out.println("1 – Bank");
            System.out.println("2 – ATM");
            System.out.println("3 – Admin");
            System.out.println("4 – Exit");

            int x = sc.nextInt();

            if (x == 1) bank();
            else if (x == 2) atm();
            else if (x == 3) admin();
            else if (x == 4) break;
            else System.out.println("Invalid option");
        }
    }

    static void bank() {
        while (true) {
            System.out.println("\n=== Bank Menu ===");
            System.out.println("1 – Add Account");
            System.out.println("2 – Deposit");
            System.out.println("3 – Withdraw");
            System.out.println("4 – Show Accounts");
            System.out.println("5 – Add Bill");
            System.out.println("6 – Back");

            int x = sc.nextInt();

            if (x == 1) {
                System.out.print("Enter username: ");
                String n = sc.next();
                requests.add(new BankAccount(id++, n, 0));
                System.out.println("Request added successfully");
            }

            else if (x == 2) {
                System.out.print("Enter username: ");
                String n = sc.next();
                BankAccount a = find(n);

                if (a != null) {
                    System.out.print("Deposit: ");
                    int d = sc.nextInt();
                    a.balance += d;
                    stack.push("Deposit " + d + " to " + n);
                    System.out.println("New balance: " + a.balance);
                }
            }

            else if (x == 3) {
                System.out.print("Enter username: ");
                String n = sc.next();
                BankAccount a = find(n);

                if (a != null) {
                    System.out.print("Withdraw: ");
                    int w = sc.nextInt();

                    if (a.balance >= w) {
                        a.balance -= w;
                        stack.push("Withdraw " + w + " from " + n);
                        System.out.println("New balance: " + a.balance);
                    } else {
                        System.out.println("Not enough money");
                    }
                }
            }

            else if (x == 4) {
                System.out.println("=== Accounts List ===");
                int i = 1;

                for (BankAccount a : list) {
                    System.out.println(i + ". " + a.username + " – Balance: " + a.balance);
                    i++;
                }
            }

            else if (x == 5) {
                System.out.print("Enter bill: ");
                String b = sc.next();
                bills.add(b);
                System.out.println("Added: " + b);
            }

            else if (x == 6) break;
            else System.out.println("Invalid option");
        }
    }

    static void atm() {
        System.out.print("Enter username: ");
        String n = sc.next();

        BankAccount a = find(n);

        if (a == null) {
            System.out.println("Account not found");
            return;
        }

        while (true) {
            System.out.println("\n=== ATM Menu ===");
            System.out.println("1 – Balance");
            System.out.println("2 – Withdraw");
            System.out.println("3 – Back");

            int x = sc.nextInt();

            if (x == 1) {
                System.out.println("Balance: " + a.balance);
            }

            else if (x == 2) {
                System.out.print("Withdraw: ");
                int w = sc.nextInt();

                if (a.balance >= w) {
                    a.balance -= w;
                    stack.push("ATM Withdraw " + w + " from " + n);
                    System.out.println("New balance: " + a.balance);
                } else {
                    System.out.println("Not enough money");
                }
            }

            else if (x == 3) break;
            else System.out.println("Invalid option");
        }
    }

    static void admin() {
        while (true) {
            System.out.println("\n=== Admin Menu ===");
            System.out.println("1 – Process Account Request");
            System.out.println("2 – Show Requests");
            System.out.println("3 – Process Bill");
            System.out.println("4 – Show Bills");
            System.out.println("5 – Transaction History");
            System.out.println("6 – Back");

            int x = sc.nextInt();

            if (x == 1) {
                if (!requests.isEmpty()) {
                    BankAccount a = requests.poll();
                    list.add(a);
                    System.out.println("Account created: " + a.username);
                } else {
                    System.out.println("No requests");
                }
            }

            else if (x == 2) {
                System.out.println("=== Requests ===");
                for (BankAccount a : requests) {
                    System.out.println(a.username);
                }
            }

            else if (x == 3) {
                if (!bills.isEmpty()) {
                    String bill = bills.poll();
                    System.out.println("Processing: " + bill);
                    stack.push("Bill paid: " + bill);
                } else {
                    System.out.println("No bills");
                }
            }

            else if (x == 4) {
                System.out.println("=== Bills ===");
                for (String b : bills) {
                    System.out.println(b);
                }
            }

            else if (x == 5) {
                if (!stack.isEmpty()) {
                    System.out.println("Last transaction: " + stack.peek());
                    System.out.println("Undo → " + stack.pop());
                } else {
                    System.out.println("No history");
                }
            }

            else if (x == 6) break;
            else System.out.println("Invalid option");
        }
    }

    static BankAccount find(String n) {
        for (BankAccount a : list) {
            if (a.username.equals(n)) return a;
        }
        System.out.println("Account not found");
        return null;
    }
}