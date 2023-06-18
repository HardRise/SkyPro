public class Main {
    public static void main(String[] args) {
        task123();
        task4();
        task5();
        task67();
        task8();
    }
    public static void task123() {
        System.out.println("Задание 1");
        var dog = 8.0;
        var cat = 3.6;
        var paper = 763789;
        System.out.println("dog = " + dog);
        System.out.println("cat = " + cat);
        System.out.println("paper = " + paper);
        System.out.println("\nЗадание 2");
        dog = dog + 4;
        cat = cat + 4;
        paper = paper + 4;
        System.out.println("dog + 4 = " + dog);
        System.out.println("cat + 4 = " + cat);
        System.out.println("paper + 4 = " + paper);
        System.out.println("\nЗадание 3");
        dog = dog - 3.5;
        cat = cat - 1.6;
        paper = paper - 7639;
        System.out.println("dog + 4 - 3.5 = " + dog);
        System.out.println("cat + 4 - 1.6 = " + cat);
        System.out.println("paper + 4 - 7639 = " + paper);
    }
    public static void task4() {
        var friend = 19;
        System.out.println("\nЗадание 4");
        System.out.println("friend = " + friend);
        friend = friend + 2;
        System.out.println("friend + 2 = " + friend);
        friend = friend / 7;
        System.out.println("(friend + 2) / 7 = " + friend);
    }
    public static void task5() {
        System.out.println("\nЗадание 5");
        var frog = 3.5;
        System.out.println("frog = " + frog);
        frog = frog * 10;
        System.out.println("frog * 10 = " + frog);
        frog = frog / 3.5;
        System.out.println("frog * 10 / 3.5 = " + frog);
        frog = frog + 4;
        System.out.println("(frog * 10 / 3.5) + 4 = " + frog);
    }
    public static void task67() {
        System.out.println("\nЗадание 6");
        var firstWeight = 78.2;
        var secondWeight = 82.7;
        var overallWeight = firstWeight + secondWeight;
        System.out.println("Общий вес двух бойцов составляет " + overallWeight + " кг");
        var difference = secondWeight - firstWeight;
        System.out.println("Разница между весами бойцов равняется " + difference + " кг");
        System.out.println("\nЗадание 7");
        difference = secondWeight - firstWeight;
        System.out.println("1 способ '-' = " + difference + " кг");
        difference = secondWeight % firstWeight;
        System.out.println("2 способ '%' = " + difference + " кг");
    }
    public static void task8() {
        System.out.println("\nЗадание 8.1");
        var overallFirstCompanyHours = 640;
        var oneHours = 8;
        var firstCompanyEmployee = overallFirstCompanyHours / oneHours;
        System.out.println("Всего работников в компании - " + firstCompanyEmployee + " человек");
        System.out.println("Задание 8.2");
        var differenceEmployee = 94;
        var secondCompanyEmployee = firstCompanyEmployee + differenceEmployee;
        var overallSecondCompanyHours = secondCompanyEmployee * oneHours;
        System.out.println("Если в компании работает " + secondCompanyEmployee + " человек, то всего " + overallSecondCompanyHours + " часов работы может быть поделено между сотрудниками");
    }
}