public class Basic {
    public static Employee[] people = Employee.getPeople();
    public static void main(String[] args) {
        //basic
        System.out.println("Список всех сотрудников со всеми данными");
        printAll();

        System.out.printf("Затраты за месяц равны %d рублям%n", monthlyExpenses());
        System.out.println("Сотрудник с минимальной зарплатой: " + minSalaryEmployee());
        System.out.println("Сотрудник с максимальной зарплатой: " + maxSalaryEmployee());
        System.out.printf("Средняя зарплата равна %.2f рублям%n", middleSalary());

        System.out.println("Список ФИО всех сотрудников");
        printTheFullNameOfEveryEmployee();

        //middle
        int indexPercent = 10; // Допустим увеличение зарплаты на 10% у всех
        System.out.printf("Индексирование зарплаты у всех на %d%%%n", indexPercent);
        indexOfSalaryEveryone(indexPercent);

        int certainDivision = 1; // Номер отдела, который нужно проверить
        System.out.println("Сотрудник " + certainDivision + " отдела с минимальной зарплатой: " + minSalaryEmployee(certainDivision));
        System.out.println("Сотрудник " + certainDivision + " отдела с максимальной зарплатой: " + maxSalaryEmployee(certainDivision));
        System.out.printf("Затраты в месяц на зарплаты %d отделу равны %d рублям", certainDivision, monthlyExpenses(certainDivision));
        System.out.printf("%nСредняя зарплата в %d отделе равна %.2f рублям%n", certainDivision, middleSalary(certainDivision));

        int indexPercentForCertainDivision = 10; // Увеличение зарплаты для конкретного отдела
        indexOfEmployeeSalaryCertainDivision(indexPercentForCertainDivision, certainDivision);
        System.out.printf("Список людей %d отдела%n", certainDivision);
        printAllCertainDivision(certainDivision);

        int certainSalary = 25_000; // Проверка заработка в отделе: больше или меньше
        System.out.printf("Сотрудники с зарплатой больше %d рублей%n", certainSalary);
        printEmployeeBiggerSalary(certainSalary);
        System.out.printf("Сотрудники с зарплатой меньше %d рублей%n", certainSalary);
        printEmployeeLowerSalary(certainSalary);
    }

    public static void printAll() {
        for (Employee person : people) {
            System.out.println(person);
        }
    }

    public static int monthlyExpenses() {
        int monthlyExpenses = 0;
        for (Employee person : people) {
            monthlyExpenses += person.getSalary();
        }
        return monthlyExpenses;
    }

    public static Employee minSalaryEmployee() {
        Employee employee = null;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() < minSalary) {
                minSalary = people[i].getSalary();
                employee = people[i];
            }
        }
        return employee;
    }

    public static Employee maxSalaryEmployee() {
        int maxSalary = Integer.MIN_VALUE;
        Employee employee = null;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() > maxSalary) {
                maxSalary = people[i].getSalary();
                employee = people[i];
            }
        }
        return employee;
    }

    public static float middleSalary() {
        return (float) monthlyExpenses() / people.length;
    }

    public static void printTheFullNameOfEveryEmployee() {
        for (Employee person : people) {
            System.out.println(person.getFullName());
        }
    }

    public static void indexOfSalaryEveryone(int indexPercent) {
        for (Employee person : people) {
            person.setSalary(person.getSalary() * (100 + indexPercent) / 100);
            System.out.println(person);
        }
    }

    public static Employee minSalaryEmployee(int certainDivision) {
        Employee employee = null;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() < minSalary && people[i].getDivision() == certainDivision) {
                minSalary = people[i].getSalary();
                employee = people[i];
            }
        }
        return employee;
    }

    public static Employee maxSalaryEmployee(int certainDivision) {
        int maxSalary = Integer.MIN_VALUE;
        Employee employee = null;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() > maxSalary && people[i].getDivision() == certainDivision) {
                maxSalary = people[i].getSalary();
                employee = people[i];
            }
        }
        return employee;
    }

    public static int monthlyExpenses(int certainDivision) {
        int monthlyExpenses = 0;
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
            }
        }
        return monthlyExpenses;
    }

    public static float middleSalary(int certainDivision) {
        int monthlyExpenses = 0;
        int employeesFromCertainDivision = 0;
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
                employeesFromCertainDivision++;
            }
        }
        return (float) monthlyExpenses / employeesFromCertainDivision;
    }

    public static void indexOfEmployeeSalaryCertainDivision(int indexPercentForCertainDivision, int certainDivision) {
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                person.setSalary(person.getSalary() * (100 + indexPercentForCertainDivision) / 100);
            }
        }
    }

    public static void printAllCertainDivision(int certainDivision) {
        for (Employee person : people) {
            if (person.getDivision() == certainDivision) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }

    public static void printEmployeeBiggerSalary(int certainSalary) {
        for (Employee person : people) {
            if (person.getSalary() > certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }

    public static void printEmployeeLowerSalary(int certainSalary) {
        for (Employee person : people) {
            if (person.getSalary() < certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }
}
