import java.util.Comparator;

public record Employee(String firstName, String lastName, String hireDate) implements Comparator<Employee> {
    public Employee {
    }

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.lastName.compareTo(o2.firstName);
    }
}
