import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1ver1();
        task1ver2();
        task2();
        task3();
        task4();
        task5();
    }
    public static void task1ver1() {
        System.out.println("Задание 1 версия 1");
        Scanner userNew = new Scanner(System.in);
        System.out.println("Какой моделю телефона вы пользуетесь:\n0 - iOS\n1 - Android\nВведите число");
        int clientOS = userNew.nextInt();
        switch (clientOS){
            case 0:
                System.out.println("Установите версию приложения для iOS по ссылке");
                break;
            case 1:
                System.out.println("Установите версию приложения для Android по ссылке");
                break;
        }
    }
    public static void task1ver2() {
        System.out.println("\nЗадание 1 версия 2");
        int clientOS = 1;
        if (clientOS == 0){
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else {
            System.out.println("Установите версию приложения для Android по ссылке");
        }
    }
    public static void task2() {
        System.out.println("\nЗадание 2");
        int clientOS = 1;
        int clientDeviceYear = 2015;
        if (clientOS == 0 && clientDeviceYear >= 2015){
            System.out.println("Установите версию приложения для iOS по ссылке");
        } else if (clientOS == 1 && clientDeviceYear >= 2015){
            System.out.println("Установите версию приложения для Android по ссылке");
        } else if (clientOS == 0 && clientDeviceYear < 2015){
            System.out.println("Установите облегченную версию приложения для iOS по ссылке");
        } else {
            System.out.println("Установите облегченную версию приложения для Android по ссылке");
        }
        if (clientOS < 0 && clientOS > 1){
            System.out.println("Данного варианта не существует");
        }
    }
    public static void task3() {
        System.out.println("\nЗадание 3");
        int year = 2021;
        if (year % 4 == 0 && year % 100 != 0) {
            System.out.println(year + " год является високосным");
        } else {
            if (year % 400 == 0){
                System.out.println(year + " год является високосным");
            } else {
                System.out.println(year + " год не является високосным");
            }
        }
    }
    public static void task4() {
        System.out.println("\nЗадание 4");
        int deliveryDistance = 95;
        int deliveryDuration = 1;
        if (deliveryDistance >= 0 && deliveryDistance < 20){
            System.out.println("Потребуется дней: " + deliveryDuration);
        } else if (deliveryDistance >= 20 && deliveryDistance < 100) {
            deliveryDuration++;
            if (deliveryDistance >= 20 && deliveryDistance < 60){
                System.out.println("Потребуется дней: " + deliveryDuration);
            } else {
                deliveryDuration++;
                System.out.println("Потребуется дней: " + deliveryDuration);
            }
        } else {
            System.out.println("Мы не имеем возможности доставить вам карту");
        }
    }
    public static void task5() {
        System.out.println("\nЗадание 5");
        int monthNumber = 12;
        switch (monthNumber){
            case 12,1,2:
                System.out.println(monthNumber + "-й месяц пренадлежит к сезону зима");
                break;
            case 3,4,5:
                System.out.println(monthNumber + "-й месяц пренадлежит к сезону весна");
                break;
            case 6,7,8:
                System.out.println(monthNumber + "-й месяц пренадлежит к сезону лето");
                break;
            case 9,10,11:
                System.out.println(monthNumber + "-й месяц пренадлежит к сезону осень");
                break;
            default:
                break;
        }
    }
}