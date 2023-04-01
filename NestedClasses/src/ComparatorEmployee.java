import java.util.Comparator;

public class ComparatorEmployee <T extends Employee> implements Comparator<Employee> {

    @Override
    public int compare(Employee o1, Employee o2) {
        return o1.getName2().compareTo(o2.getName2());
    }
}
