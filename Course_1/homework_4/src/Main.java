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
        task8();
        myownwork();
    }
    public static void task1() {
        System.out.println("Задание 1");
        int millions = 1637585;
        System.out.println("Значение переменной 'millions' с типом 'int' равно " + millions);
        byte hundreds = 125;
        System.out.println("Значение переменной 'hundreds' с типом 'byte' равно " + hundreds);
        short thousands = 12564;
        System.out.println("Значение переменной 'thousands' с типом 'short' равно " + thousands);
        long aLotOf = 541356431;
        System.out.println("Значение переменной 'aLotOf' с типом 'long' равно " + aLotOf);
        float little = 5.3415F;
        System.out.println("Значение переменной 'little' с типом 'float' равно " + little);
        double big = 7.5413513465;
        System.out.println("Значение переменной 'big' с типом 'double' равно " + big);
    }
    public static void task2() {
        System.out.println("\nЗадание 2");
        float first = 27.12F;
        System.out.println("float first = 27.12F;");
        long second = 987678965549L;
        System.out.println("long second = 987678965549L;");
        double third = 2.786;
        System.out.println("double third = 2.786;");
        short fourth = 569;
        System.out.println("short fourth = 569;");
        int fifth = -159;
        System.out.println("int fifth = -159;");
        short sixth = 27897;
        System.out.println("short sixth = 27897;");
        byte seventh = 67;
        System.out.println("byte seventh = 67;");
    }
    public static void task3() {
        System.out.println("\nЗадание 3");
        short ludmila = 23;
        short anna = 27;
        short ekaterina = 30;
        short overallPaper = 480;
        int overallPupils = ludmila + anna + ekaterina;
        int everyPupilPaper = overallPaper / overallPupils;
        System.out.println("На каждого ученика расчитано " + everyPupilPaper + " листов бумаги");
        /// Вначале отдельно проверял через float, так как ответ выходит целочисленный, решил красивее оформить
    }
    public static void task4() {
        System.out.println("\nЗадание 4");
        int twoMinutesBottles = 16;
        int twoMinutes = 2;
        int oneMinuteBottles = twoMinutesBottles / twoMinutes;
        int twentyMinutesBottles = oneMinuteBottles * 20;
        System.out.println("За 20 минут машина произвела " + twentyMinutesBottles + " штук бутылок");
        int oneDayMinutes = 24 * 60;
        int oneDayBottles = oneMinuteBottles * oneDayMinutes;
        System.out.println("За 1 сутки машина произвела " + oneDayBottles + " штук бутылок");
        int threeDaysBottles = oneDayBottles * 3;
        System.out.println("За 3 суток машина произвела " + threeDaysBottles + " штук бутылок");
        int monthBottles = oneDayBottles * 30;
        System.out.println("За 1 месяц машина произведет " + monthBottles + " бутылок");
    }
    public static void task5(){
        System.out.println("\nЗадание 5");
        int overallDye = 120;
        int oneClassBrown = 4;
        int oneClassWhite = 2;
        int oneClassDye = oneClassWhite + oneClassBrown;
        int overallClasses = overallDye / oneClassDye;
        int overallBrown = overallClasses * oneClassBrown;
        int overallWhite = overallClasses * oneClassWhite;
        System.out.println("В школе, где " + overallClasses + " классов, нужно " + overallWhite + " банок белой краски и " + overallBrown + " банок коричневой краски");
        ///Отдельно проверял через float, опять же для оформления посчитал через int
    }
    public static void task6() {
        System.out.println("\nЗадание 6");
        int oneBananaGramm = 80;
        int bananaGramm = oneBananaGramm * 5;
        int oneMilkGramm = 105;
        int milkGramm = oneMilkGramm * 2;
        int oneIceCreamGramm = 100;
        int iceCreamGramm = oneIceCreamGramm * 2;
        int oneEggGramm = 70;
        int eggGramm = oneEggGramm * 4;
        int overallGramm = bananaGramm + milkGramm + iceCreamGramm + eggGramm;
        int killogramm = overallGramm / 1000;
        System.out.println("Такой спортзавтрак весит " + overallGramm + " грамм или " + killogramm + " киллограмм");
    }
    public static void task7(){
        System.out.println("\nЗадание 7");
        int finallResultKillogram = 7;
        int finallResultGramm = finallResultKillogram * 1000;
        int lostWeightWorst = 250;
        int lostWeightBest = 500;
        int daysWorst = finallResultGramm / lostWeightWorst;
        int daysBest = finallResultGramm / lostWeightBest;
        int middle = (daysWorst + daysBest) / 2;
        System.out.println("Если спортсмен будет терять по 250 грамм в день - это займет " + daysWorst + " дней, а если по 500 грамм в день - " + daysBest + " дней");
        System.out.println("В среднем спортсмен может сбросить этот вес за " + middle + " день");
    }
    public static void task8(){
        System.out.println("\nЗадание 8");
        int masha = 67760;
        int denis = 83690;
        int kristina = 76230;
        int yearMashaBefore = masha * 12;
        int yearDenisBefore = denis * 12;
        int yearKristinaBefore = kristina * 12;
        int profitMashaMonth = (masha / 100) * 110;
        int profitDenisMonth = (denis / 100) * 110;
        int profitKristinaMonth = (kristina / 100) * 110;
        int profitYearMasha = profitMashaMonth * 12;
        int profitYearDenis = profitDenisMonth * 12;
        int profitYearKristina = profitKristinaMonth * 12;
        int differenceMasha = profitYearMasha - yearMashaBefore;
        int differenceDenis = profitYearDenis - yearDenisBefore;
        int differenceKristina = profitYearKristina - yearKristinaBefore;
        System.out.println("Маша теперь получает " + profitMashaMonth + " рублей в месяц или " + profitYearMasha + " рублей в год. Годовой доход вырос на " + differenceMasha + " рублей");
        System.out.println("Денис теперь получает " + profitDenisMonth + " рублей в месяц или " + profitYearDenis + " рублей в год. Годовой доход вырос на " + differenceDenis + " рублей");
        System.out.println("Кристина теперь получает " + profitKristinaMonth + " рублей в месяц или " + profitYearKristina + " рублей в год. Годовой доход вырос на " + differenceKristina + " рублей");
    }
    public static void myownwork() {
        System.out.println("\nЗадание 8. Другой способ решения последнего задания, но данные нужно вводить самому");
        Scanner myObj = new Scanner (System.in);
        System.out.println("Введите ваше имя:");
        String name = myObj.nextLine();
        Scanner myNum = new Scanner (System.in);
        System.out.println("Введите вашу заработную плату:");
        int wage = Integer.parseInt(myNum.nextLine());
        Scanner myQuest = new Scanner (System.in);
        System.out.println("Сколько лет вы работаете на нашу фирму?");
        int quest = Integer.parseInt(myQuest.nextLine());
        int experience = 3;
        if (quest > experience){
            int boostedWage = (wage / 100) * 110;
            int profitYear = (boostedWage * 12) - (wage * 12);
            System.out.println("Уважаемый(ая) " + name + ", ваша зарплата теперь равна " + boostedWage + ", в связи с тем, что люди, работающие у нас больше 3 лет получают надбавку к зарплате в виде 10%, что на " + profitYear + " рублей в год больше, чем вы получали раннее.");
        }
        else {
            int need = experience - quest;
            System.out.println("Уважаемый(ая) " + name + ", ваша зарплата равна " + wage + " рублям. Через " + need + " год(а) вы сможете получить надбавку к зарплате на 10%");
        }
        /// Попробовал поэксперементировать, надеюсь вы хотя бы взгланите на мою работу. Я старался.
    }
}