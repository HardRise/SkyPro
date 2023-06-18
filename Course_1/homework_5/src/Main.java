import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        task1();
        task2();
        task3();
        task4();
        task5();
        task6();
        task7();
    }
    public static void task1() {
        System.out.println("Задание 1");
        Scanner myNum = new Scanner(System.in);
        System.out.println("Сколько вам лет?");
        int age = myNum.nextInt();
        if (age >= 18){
            System.out.println("Если возраст человека равен " + age + " годам, то он совершеннолетний");
        } else {
            System.out.println("Если возраст человека равен " + age + " годам, то он не совершеннолетний");
        }
    }
    public static void task2(){
        System.out.println("\nЗадание 2");
        Scanner degreeNum = new Scanner(System.in);
        System.out.println("Сколько градусов сейчас на улице?");
        int degree = degreeNum.nextInt();
        if (degree >= 5){
            System.out.println("На улице " + degree + " градусов, можно идти без шапки");
        } else {
            System.out.println("На улице " + degree + " градусов, нужно надеть шапку");
        }
    }
    public static void task3() {
        System.out.println("\nЗадание 3");
        Scanner speedNum = new Scanner(System.in);
        System.out.println("С какой скоростью вы едите?");
        int speed = speedNum.nextInt();
        if (speed >= 60){
            System.out.println("Если скорость равна " + speed + " км/ч, то придется заплатить штраф");
        } else {
            System.out.println("Если скорость равна " + speed + " км/ч, то можно ездить спокойно");
        }
    }
    public static void task4(){
        System.out.println("\nЗадание 4");
        Scanner ageNum = new Scanner(System.in);
        System.out.println("Напишите возраст, который необходимо проверить");
        int age = ageNum.nextInt();
        boolean kindergarten = 2 <= age && age <= 6;
        boolean school = 7 <= age && age < 18;
        boolean university = 18 <= age && age < 24;
        boolean work = 24 <= age;
        if (kindergarten) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему нужно ходить в детский сад");
        }
        if (school) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему нужно ходить в школу");
        }
        if (university) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему нужно ходить в университет");
        }
        if (work) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему нужно ходить на работу");
        }
    }
    public static void task5() {
        System.out.println("\nЗадание 5");
        Scanner ageNum = new Scanner(System.in);
        System.out.println("Сколько вам лет, на аттракционах опасно поэтому необходимо проверить");
        int age = ageNum.nextInt();
        boolean ban = age < 5;
        boolean controlled = 5 <= age && age <= 14;
        boolean free = 14 < age;
        if (ban) {
            System.out.println("Если возраст ребенка равен " + age + " годам, то ему нельзя кататься на аттракционе");
        }
        if (controlled) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему можно кататься на аттракционе в сопровождении");
        }
        if (free) {
            System.out.println("Если возраст человека равен " + age + " годам, то ему можно кататься на аттракционе без сопровождения взрослого");
        }
    }
    public static void task6() {
        System.out.println("\nЗадание 6");
        int total = 102;
        int sit = 60;
        Scanner ticketNum = new Scanner(System.in);
        System.out.println("Напишите какой вы в очереди за билетом");
        int ticket = ticketNum.nextInt();
        boolean success = ticket > 0 && ticket <= total;
        boolean sitTicket = ticket > 0 && ticket <= sit;
        if (success) {
            if (sitTicket) {
                System.out.println("На данный момент свободны и сидячии, и стоячии места");
            } else {
                System.out.println("На данный момент свободны только стоячие места");
            }
        } else {
            System.out.println("На данный момент все места заняты");
        }
    }
    public static void task7() {
        System.out.println("\nЗадание 7");
        Scanner oneNum = new Scanner(System.in);
        System.out.println("Введите первое число: ");
        int one = oneNum.nextInt();
        Scanner twoNum = new Scanner(System.in);
        System.out.println("Введите второе число: ");
        int two = twoNum.nextInt();
        Scanner threeNum = new Scanner(System.in);
        System.out.println("Введите третье число: ");
        int three = threeNum.nextInt();
        boolean first = one > two && one > three;
        boolean second = two > one && two > three;
        if (first) {
            System.out.println("Самое большее первое число равное " + one);
        } else {
            if (second){
                System.out.println("Самое большее второе число равное " + two);
            } else {
                System.out.println("Самое большее третье число равное " + three);
            }
        }
    }
}