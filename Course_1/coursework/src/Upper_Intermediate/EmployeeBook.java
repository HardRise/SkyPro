package Upper_Intermediate;

import java.util.Arrays;
import java.util.Comparator;
import java.util.Random;

public class EmployeeBook {
    private static int idCalculator = 1;
    private Random random = new Random();

    private final int id;
    private final String fullName;
    private int division;
    private int salary;

    public EmployeeBook(String fullName) {
        this.id = idCalculator++;
        this.fullName = fullName;
        this.division = random.nextInt(1, 6);
        this.salary = random.nextInt(60_000, 80_000);
    }

    public int getId() {
        return id;
    }

    public String getFullName() {
        return fullName;
    }

    public int getDivision() {
        return division;
    }

    public int getSalary() {
        return salary;
    }

    public void setDivision(int division) {
        this.division = division;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    private static final EmployeeBook[] people = new EmployeeBook[10];

    static  {
        EmployeeBook person1 = new EmployeeBook("Петров Петр Петрович");
        EmployeeBook person2 = new EmployeeBook("Павлов Павел Павлович");
        EmployeeBook person3 = new EmployeeBook("Алексеев Алексей Алексеевич");
        EmployeeBook person4 = new EmployeeBook("Николаев Николай Николаевич");
        EmployeeBook person5 = new EmployeeBook("Александров Александр Александрович");
        EmployeeBook person6 = new EmployeeBook("Павлов Павел Павлович");
        EmployeeBook person7 = new EmployeeBook("Алексеев Алексей Алексеевич");
        EmployeeBook person8 = new EmployeeBook("Николаев Николай Николаевич");
        EmployeeBook person9 = new EmployeeBook("Александров Александр Александрович");
        EmployeeBook person10 = new EmployeeBook("Павлов Павел Павлович");

        people[0] = person1;
        people[1] = person2;
        people[2] = person3;
        people[3] = person4;
        people[4] = person5;
        people[5] = person6;
        people[6] = person7;
        people[7] = person8;
        people[8] = person9;
        people[9] = person10;
    }

    public static EmployeeBook[] getPeople() {
        return people;
    }

    public class EmployeeBookDivisionSort implements Comparator<EmployeeBook> {
        @Override
        public int compare(EmployeeBook o1, EmployeeBook o2) {
            return o1.division - o2.division;
        }
    }

    public void addEmployeeToArray(EmployeeBook employee) {
        int counter = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i] == null) {
                people[i] = employee;
                counter = i;
                break;
            }
        }
        if (counter == -1) {
            System.out.println("Штат заполнен, не хватает места");
        }
    }

    public void deleteEmployeeFromArrayFullName(String EmployeeBookThatNeedToDelete) {
        int counter = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null && people[i].fullName.equals(EmployeeBookThatNeedToDelete)) {
                people[i] = null;
                counter = i;
            }
        }
        if (counter == -1) {
            System.out.println("Такой сотрудник не найден");
        }
    }

    public void deleteEmployeeFromArrayId(int idOfThePersonThatNeedToDelete) {
        int counter = -1;
        for (int i = 0; i < people.length; i++) {
            if (people[i] != null && id == idOfThePersonThatNeedToDelete) {
                people[i] = null;
                counter = i;
            }
        }
        if (counter == -1) {
            System.out.println("Такой сотрудник не найден");
        }
    }

    public void makeSomeCorrectionsSalary(String fullNameOfEmployeeBook, int newSalary) {
        for (EmployeeBook person : people) {
            if (person != null && person.getFullName().equals(fullNameOfEmployeeBook)) {
                person.setSalary(newSalary);
            }
        }
    }

    public void makeSomeCorrectionsDivision(String fullNameOfEmployeeBook, int newDivision) {
        for (EmployeeBook person : people) {
            if (person != null && person.fullName.equals(fullNameOfEmployeeBook)) {
                person.setDivision(newDivision);
            }
        }
    }

    public void printAllSortedByDivisions() {
        Arrays.sort(people, new EmployeeBookDivisionSort());
        int counter = 0;
        for (int i = 0; i < people.length; i++) {
            if (counter != people[i].getDivision()) {
                System.out.println("\nСотрудники " + people[i].getDivision() + " отдела");
            }
            System.out.println(people[i].getFullName());
            counter = people[i].getDivision();
        }
    }

    public void printAllSortedByDivisionsNewWay() {
        for (int division = 0; division < 6; division++) {
            StringBuilder stringBuilder = new StringBuilder();
            for (EmployeeBook person : people) {
                if (person != null && division == person.getDivision()) {
                    stringBuilder.append(person).append("\n");
                }
            }
            if (!stringBuilder.isEmpty()) {
                System.out.println("Сотрудники " + division + " отдела" + "\n" + stringBuilder);
            }
        }
    }

    public void printAll() {
        for (EmployeeBook person : people) {
            System.out.println(person);
        }
    }

    public int monthlyExpenses() {
        int monthlyExpenses = 0;
        for (EmployeeBook person : people) {
            monthlyExpenses += person.getSalary();
        }
        return monthlyExpenses;
    }

    public EmployeeBook minSalaryEmployeeBook() {
        EmployeeBook EmployeeBook = null;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() < minSalary) {
                minSalary = people[i].getSalary();
                EmployeeBook = people[i];
            }
        }
        return EmployeeBook;
    }

    public EmployeeBook maxSalaryEmployeeBook() {
        int maxSalary = Integer.MIN_VALUE;
        EmployeeBook EmployeeBook = null;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() > maxSalary) {
                maxSalary = people[i].getSalary();
                EmployeeBook = people[i];
            }
        }
        return EmployeeBook;
    }

    public float middleSalary() {
        return (float) monthlyExpenses() / people.length;
    }

    public void printTheFullNameOfEveryEmployeeBook() {
        for (EmployeeBook person : people) {
            System.out.println(person.getFullName());
        }
    }

    public void indexOfSalaryEveryone(int indexPercent) {
        for (EmployeeBook person : people) {
            person.setSalary(person.getSalary() * (100 + indexPercent) / 100);
            System.out.println(person);
        }
    }

    public EmployeeBook minSalaryEmployeeBook(int certainDivision) {
        EmployeeBook EmployeeBook = null;
        int minSalary = Integer.MAX_VALUE;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() < minSalary && people[i].getDivision() == certainDivision) {
                minSalary = people[i].getSalary();
                EmployeeBook = people[i];
            }
        }
        return EmployeeBook;
    }

    public EmployeeBook maxSalaryEmployeeBook(int certainDivision) {
        int maxSalary = Integer.MIN_VALUE;
        EmployeeBook EmployeeBook = null;
        for (int i = 0; i < people.length; i++) {
            if (people[i].getSalary() > maxSalary && people[i].getDivision() == certainDivision) {
                maxSalary = people[i].getSalary();
                EmployeeBook = people[i];
            }
        }
        return EmployeeBook;
    }

    public int monthlyExpenses(int certainDivision) {
        int monthlyExpenses = 0;
        for (EmployeeBook person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
            }
        }
        return monthlyExpenses;
    }

    public float middleSalary(int certainDivision) {
        int monthlyExpenses = 0;
        int EmployeeBooksFromCertainDivision = 0;
        for (EmployeeBook person : people) {
            if (person.getDivision() == certainDivision) {
                monthlyExpenses += person.getSalary();
                EmployeeBooksFromCertainDivision++;
            }
        }
        return (float) monthlyExpenses / EmployeeBooksFromCertainDivision;
    }

    public void indexOfEmployeeBookSalaryCertainDivision(int indexPercentForCertainDivision, int certainDivision) {
        for (EmployeeBook person : people) {
            if (person.getDivision() == certainDivision) {
                person.setSalary(person.getSalary() * (100 + indexPercentForCertainDivision) / 100);
            }
        }
    }

    public void printAllCertainDivision(int certainDivision) {
        for (EmployeeBook person : people) {
            if (person.getDivision() == certainDivision) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }

    public void printEmployeeBookBiggerSalary(int certainSalary) {
        for (EmployeeBook person : people) {
            if (person.getSalary() > certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }

    public void printEmployeeBookLowerSalary(int certainSalary) {
        for (EmployeeBook person : people) {
            if (person.getSalary() < certainSalary) {
                System.out.printf("id = %d, ФИО работника: %s, зарплата: %d%n",
                        person.getId(), person.getFullName(), person.getSalary());
            }
        }
    }

    @Override
    public String toString() {
        return String.format("id = %d, ФИО работника: %s, отдел: %d, зарплата: %d",
                getId(), getFullName(), getDivision(), getSalary());
    }
}
