public class Intermediate {

    public static void main(String[] args) {
        //intermediate
        Employee[] people = Employee.getPeople();
        int certainDivision = 1; // Номер отдела, который нужно проверить
        int indexPercent = 10; // Допустим увеличение зарплаты на 10% у всех
        int indexPercentForCertainDivision = 10; // Увеличение зарплаты для конкретного отдела
        int certainSalary = 25_000; // Проверка заработка в отделе: больше или меньше

        for (Employee person : people) {
            person.setSalary(person.getSalary() * (100 + indexPercent) / 100);
        }

        minSalary(certainDivision);
        maxSalary(certainDivision);
        monthlyExpenses(certainDivision);
        middleSalary(certainDivision);
        profitSalaryForCertainDivision(certainDivision, indexPercentForCertainDivision);
        printAll(certainDivision);

        biggerLower(certainSalary);
    }

    public static void minSalary(int certainDivision) {
        Employee[] people = Employee.getPeople();
        float minSalary = Integer.MAX_VALUE;
        int minSalaryEmployee = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getDivision() == certainDivision) {
                if (people[i].getSalary() < minSalary) {
                    minSalaryEmployee = i;
                    minSalary = people[i].getSalary();
                }
            }
        }
        System.out.println("\nСотрудник " + certainDivision + " отдела с минимальной зарплатой: " + people[minSalaryEmployee]);
    }

    public static void maxSalary(int certainDivision) {
        Employee[] people = Employee.getPeople();
        float maxSalary = Integer.MIN_VALUE;
        int maxSalaryEmployee = 0;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getDivision() == certainDivision) {
                if (people[i].getSalary() > maxSalary) {
                    maxSalaryEmployee = i;
                    maxSalary = people[i].getSalary();
                }
            }
        }
        System.out.println("\nСотрудник " + certainDivision + " отдела с максимальной зарплатой: " + people[maxSalaryEmployee]);
    }

    public static void monthlyExpenses(int certainDivision) {
        Employee[] people = Employee.getPeople();
        float monthlyExpenses = 0;
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
            }
        }
        System.out.println("\nСумма затрат на зарплаты " + certainDivision + " отделу за месяц составляет " + monthlyExpenses + " рублей");
    }

    public static void middleSalary(int certainDivision) {
        Employee[] people = Employee.getPeople();
        float monthlyExpenses = 0;
        int employeeCertainDivision = 0;
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
                employeeCertainDivision++;
            }
        }
        System.out.println("\nСреднее значение зарплат " + certainDivision + " отдела равняется " + monthlyExpenses/employeeCertainDivision + " рублям");
    }

    public static void profitSalaryForCertainDivision(int certainDivision, int indexPercentForCertainDivision) {
        Employee[] people = Employee.getPeople();
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                person.setSalary(person.getSalary() * (100 + indexPercentForCertainDivision) / 100);
            }
        }
    }

    public static void printAll(int certainDivision) {
        Employee[] people = Employee.getPeople();
        System.out.println("\nСотрудники " + certainDivision + " отдела:");
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                System.out.println("ФИО работника: " + person.getFullName() + ", зарплата: " + person.getSalary());
            }
        }
    }

    public static void biggerLower(int certainSalary) {
        Employee[] people = Employee.getPeople();
        System.out.println("\nСотрудники с зарплатой больше (или равно) " + certainSalary + " рублей");
        for (Employee person : people) {
            if (person.getSalary() >= certainSalary) {
                System.out.println("id: " + person.getId() + ", ФИО работника: " + person.getFullName() + ", зарплата: " + person.getSalary());
            }
        }

        System.out.println("\nСотрудники с зарплатой меньше " + certainSalary + " рублей");
        for (Employee person : people) {
            if (person.getSalary() < certainSalary) {
                System.out.println("id: " + person.getId() + ", ФИО работника: " + person.getFullName() + ", зарплата: " + person.getSalary());
            }
        }
    }
}
