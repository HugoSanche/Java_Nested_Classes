import java.util.Comparator;

public class Employee {
    //this is example of static nested class
    //the advantage of this is you accesses to attributes private declarate in Employee like employeId or yearStarted
    // who does not have getters
    public static class ComparatorEmployee <T extends Employee> implements Comparator<Employee> {
        private String sortType;
        public ComparatorEmployee() {
            this("name");
        }
        public ComparatorEmployee(String sortType) {
            this.sortType = sortType;
        }

        @Override
        public int compare(Employee o1, Employee o2) {
            if (sortType.equalsIgnoreCase("yearStarted"))
                return o1.yearStarted-o2.yearStarted;
            return o1.name.compareTo(o2.name);
        }
    }

    private int employeeId;
    private String name;
    private int yearStarted;
    public Employee(){

    }
    public Employee(int employeeId, String name, int yearStarted) {
        this.employeeId = employeeId;
        this.name = name;
        this.yearStarted = yearStarted;
    }

    public String getName2() {
        return name;
    }

    @Override
    public String toString() {
        return "%-8d %-8s %-12d".formatted(employeeId,name,yearStarted);
    }
}
