public class Homework6 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
        task9();
        task10();
    }
    public static void task1() {
        System.out.println("\nЗадание 1");
        for (int i = 1; i <= 10; i++){
            System.out.print(i + " ");
        }
    }
    public static void task2() {
        System.out.println("\n\nЗадание 2");
        for (int i = 10; i >= 1; i--){
            System.out.print(i + " ");
        }
    }
    public static void task3() {
        System.out.println("\n\nЗадание 3");
        for (int i = 0; i <= 17; i = i + 2){
            System.out.print(i + " ");
        }
    }
    public static void task4() {
        System.out.println("\n\nЗадание 4");
        for (int i = 10; i >= -10; i--){
            System.out.print(i + " ");
        }
    }
    public static void task5() {
        System.out.println("\n\nЗадание 5");
        for (int i = 1904; i <= 2096; i = i + 4){
            if (i % 400 == 0 || i % 100!= 0){
                System.out.println(i + " год является високосным");
            }
        }
    }
    public static void task6() {
        System.out.println("\nЗадание 6");
        for (int i = 7; i <= 98; i = i + 7){
            System.out.print(i + " ");
        }
    }
    public static void task7() {
        System.out.println("\n\nЗадание 7");
        for (int i = 1; i <= 512; i = i * 2){
            System.out.print(i + " ");
        }
    }
    public static void task8() {
        System.out.println("\n\nЗадание 8");
        int value = 29000;
        int total = 0;
        for (int i = 1; i <= 12; i++){
            total += value;
            System.out.println("Месяц " + i + ", сумма накоплений равна " + total + " рублей");
        }
    }
    public static void task9() {
        System.out.println("\nЗадание 9");
        int value = 29000;
        int total = 0;
        for (int i = 1; i <= 12; i++){
            total = (total/100) * 112;
            total += value;
            System.out.println("Месяц " + i + ", сумма накоплений равна " + total + " рублей");
        }
    }
    public static void task10() {
        System.out.println("\nЗадание 10");
        int total;
        for (int i = 1; i <= 10; i++) {
            total = 2 * i;
            System.out.println("2*" + i + "=" + total);
        }
        System.out.println("\nЗадание 10.1");
        int fromOneToTen = 1;
        for (int s = 2; s <= 20; s = 2 * fromOneToTen){
            System.out.println("2*" + fromOneToTen + "=" + s);
            fromOneToTen++;
        }
    }
}