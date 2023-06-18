public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
    }
    public static int[] generateRandomArray() {
        int[] array = new int[30];
        java.util.Random randomNumber = new java.util.Random();
        for (int i = 0; i < array.length; i++) {
            array[i] = randomNumber.nextInt(100_000) + 100_000;
        }
        return array;
    }
    public static void task1() {
        System.out.println("Задание 1");
        int sum = 0;
        int[] array = generateRandomArray();
        for (int j : array) {
            sum += j;
        }
        System.out.println("Сумма трат за месяц составила " + sum + " рублей");
    }
    public static void task2() {
        System.out.println("\nЗадание 2");
        int[] array = generateRandomArray();
        int min = 200_000, max = 100_000;
        for (int j : array) {
            if (j > max) {
                max = j;
            } else if (min > j) {
                min = j;
            }
        }
        System.out.println("Минимальная сумма трат за день составила " + min + " рублей. Максимальная сумма трат за день составила " + max + " рублей");
    }
    public static void task3() {
        System.out.println("\nЗадание 3");
        int[] array = generateRandomArray();
        float middle = 0;
        for (int elements : array) {
            middle += elements;
        }
        middle /= array.length;
        System.out.println("Средняя сумма трат за месяц составила " + middle + " рублей");
    }
    public static void task4() {
        System.out.println("\nЗадание 4");
        char[] reverseFullName = { 'n', 'a', 'v', 'I', ' ', 'v', 'o', 'n', 'a', 'v', 'I'};
        for (int i = reverseFullName.length - 1; 0 <= i; i--) {
            System.out.print(reverseFullName[i]);
        }
    }
}