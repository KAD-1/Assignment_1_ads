//import java.awt.*;
//import java.util.Scanner;
//public class Main {
//    public static void main(String args[]) {
//        Scanner sc = new Scanner(System.in);
//        String a=sc.nextLine();
//        System.out.println(task8(a,0));
//        String b=sc.nextLine();
//        System.out.println(task8(b,0));
//    }
//
//    public static void task1(int a) {
//        if (a < 10) System.out.println(a);
//        else {
//            task1(a / 10);
//            System.out.println(a % 10);
//        }
//    }
////    int a = sc.nextInt();
////    System.out.println(task1(a));
//
//    public static void task2a(int[] n,int a,Scanner sc){
//        if(a==n.length)return;
//        n[a]=sc.nextInt();
//        task2a(n,a+1,sc);
//    }
//
//    public static int task2b(int[] n,int a){
//        if(a==0)return 0;
//        return n[a-1]+task2b(n,a-1);
//    }
//    //    int a = sc.nextInt();
////    int[] n=new int[a];
////    task2a(n,0,sc);
////    System.out.println((double)task2b(n,a)/a);
//    public static boolean task3(int a,int b){
//        if (a<=1)return false;
//        if(b*b>a)return true;
//        if(a%b==0)return false;
//        return task3(a,b+1);
//    }
//    //    int b = sc.nextInt();
////    System.out.println(task3(b,2));
//    public static int task4(int a){
//        if(a<=1)return 1;
//        return a*task4(a-1);
//    }
//    //    int a = sc.nextInt();
////    System.out.println(task4(a));
//    public static int task5(int a){
//        if(a==0)return 0;
//        if(a==1)return 1;
//        return task5(a-1)+task5(a-2);
//    }
////    int a = sc.nextInt();
////    System.out.println(task5(a));
//
//    public static double task6(int a,int b){
//        if(b==0)return 1;
//        if(b<0)return 1/task6(a,-b);
//        return a*task6(a,b-1);
//    }
//    //    int a = sc.nextInt();
////    int b = sc.nexInt();
////    System.out.println(task6(a,b))
//    public static void task7(int a,Scanner sc){
//        if(a<=0)return;
//        int b=sc.nextInt();
//        task7(a-1,sc);
//        System.out.println(b+" ");
//    }
//    //    int a = sc.nextInt();
////    task7(a,sc)
//    public static String task8(String a,int b){
//        if(a.length()==0)return "no";
//        if(b==a.length())return "yes";
//        char c=a.charAt(b);
//        if(c<'0' || c>'9')return "no";
//        return task8(a,b+1);
//    }
//    //    String a=sc.nextLine();
////    System.out.println(task8(a,0));
////    String b=sc.nextLine();
////    System.out.println(task8(b,0));
//    public static int task9(String a,int b){
//        if (b == a.length())return b;
//        return task9(a,b+1);
//    }
//    //    String a=sc.nextLine();
////    System.out.println(task9(a,0));
//    public static int task10(int a,int b){
//        if(b==0)return a;
//        return task10(b,a%b);
//    }
////    int a=sc.nextInt();
////    int b=sc.nextInt();
////    System.out.println(task10(a,b));
//}
