import java.util.Random;

public class Employee {

    private static int idCalculator = 1;
    private Random random = new Random();

    private int id;
    private String fullName;
    private int division;
    private int salary;

    public Employee(String fullName) {
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

    private static final Employee[] people = new Employee[10];

    static  {
        Employee person1 = new Employee("Петров Петр Петрович");
        Employee person2 = new Employee("Павлов Павел Павлович");
        Employee person3 = new Employee("Алексеев Алексей Алексеевич");
        Employee person4 = new Employee("Николаев Николай Николаевич");
        Employee person5 = new Employee("Александров Александр Александрович");
        Employee person6 = new Employee("Павлов Павел Павлович");
        Employee person7 = new Employee("Алексеев Алексей Алексеевич");
        Employee person8 = new Employee("Николаев Николай Николаевич");
        Employee person9 = new Employee("Александров Александр Александрович");
        Employee person10 = new Employee("Павлов Павел Павлович");

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

    public static Employee[] getPeople() {
        return people;
    }

    @Override
    public String toString() {
        return String.format("id = %d, ФИО работника: %s, отдел: %d, зарплата: %d",
                getId(), getFullName(), getDivision(), getSalary());
    }
}