import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        tasks();
    }
    public static void tasks(){
        //task1
        System.out.println("Задание 1");
        int[] first = new int[]{1, 2, 3};
        double[] second = {1.57, 7.654, 9.986};
        double[] third = {1.111, 2.222, 3.333, 4.444, 5.555};

        //task2
        System.out.println("\nЗадание 2");
        for (int i = 0; i < first.length; i++) {
            if (i == first.length - 1){
                System.out.println(first[i]);
                continue;
            }
            System.out.print(first[i] + ", ");
        }
        for (int i = 0; i < second.length; i++) {
            if (i == second.length - 1){
                System.out.println(second[i]);
                continue;
            }
            System.out.print(second[i] + ", ");
        }
        for (int i = 0; i < third.length; i++) {
            if (i == third.length - 1){
                System.out.println(third[i]);
                continue;
            }
            System.out.print(third[i] + ", ");
        }
        //task3
        System.out.println("\nЗадание 3");
        for (int i = first.length - 1; i >= 0; i--) {
            if (i == 0){
                System.out.println(first[i]);
                break;
            }
            System.out.print(first[i] + ", ");
        }
        for (int i = second.length - 1; i >= 0; i--) {
            if (i == 0){
                System.out.println(second[i]);
                break;
            }
            System.out.print(second[i] + ", ");
        }
        for (int i = third.length - 1; i >= 0; i--) {
            if (i == 0){
                System.out.println(third[i]);
                break;
            }
            System.out.print(third[i] + ", ");
        }
        //task4
        System.out.println("\nЗадание 4");
        for (int i = 0; i < first.length; i++) {
            if (first[i] % 2 != 0){
                first[i] = first[i] + 1;
            }
        }
        System.out.println(Arrays.toString(first));
    }
}