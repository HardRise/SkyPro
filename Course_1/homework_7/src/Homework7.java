public class Homework7 {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
        task8();
    }
    public static void task1() {
        System.out.println("\nЗадание 1");
        int value = 0;
        int deposit = 15_000;
        int month = 0;
        while (value < 2_459_000){
            value += deposit;
            month++;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + value + " рублей");
        }
    }
    public static void task2() {
        System.out.println("\nЗадание 2");
        int i = 1;
        while (i <= 10){
            System.out.print(i + " ");
            i++;
        } System.out.println("\n");
        for (i = 10; i > 0; i --){
            System.out.print(i + " ");
        }
    }
    public static void task3() {
        System.out.println("\n\nЗадание 3");
        int population = 12_000_000;
        int year = 0;
        int birth;
        int death;
        while (year < 10){
            birth = (population/1000) * 17;
            death = (population/1000) * 8;
            population = population - death + birth;
            year++;
            System.out.println("Год " + year + ", численность населения составляет " + population);
        }
    }
    public static void task4() {
        System.out.println("\nЗадание 4");
        int total = 15_000;
        int month = 0;
        while (total < 12_000_000){
            total = (total/100) * 107;
            month++;
            System.out.println("Месяц " + month + ", сумма накоплений равна " + total + " рублей");
        }
    }
    public static void task5() {
        System.out.println("\nЗадание 5");
        int total = 15_000;
        int month = 0;
        while (total < 12_000_000){
            total = (total/100) * 107;
            month++;
            if (month % 6 == 0){
                System.out.println("Месяц " + month + ", сумма накоплений равна " + total + " рублей");
            }
        }
    }
    public static void task6() {
        System.out.println("\nЗадание 6");
        int investment = 15_000;
        int month = 0;
        while (month < 12*9){
            investment = (investment/100)*107;
            month++;
            if (month % 6 ==0){
                System.out.println("Месяц " + month + ", сумма накоплений равна " + investment + " рублей");
            }
        }
    }
    public static void task7() {
        System.out.println("\nЗадание 7");
        int firstFridayOfMonth = 4;
        for (; firstFridayOfMonth <= 31; firstFridayOfMonth = firstFridayOfMonth + 7){
            System.out.println("Сегодня пятница, " + firstFridayOfMonth + "-е число. Необходимо подготовить отчет");
        }
    }
    public static void task8() {
        System.out.println("\nЗадание 8");
        int yearOfPast = 2023 - 200;
        int yearOfFuture = 2023 + 100;
        for (; yearOfPast <= yearOfFuture; yearOfPast++){
            if (yearOfPast % 79 == 0){
                System.out.println(yearOfPast);
            }
        }
    }
}
