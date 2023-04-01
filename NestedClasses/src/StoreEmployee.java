import java.util.Comparator;
public class StoreEmployee extends Employee{
    private String store;
    public StoreEmployee(int employeeId, String name, int yearStarted, String store) {
        super(employeeId, name, yearStarted);
        this.store = store;
    }
    public StoreEmployee() {
    }
    @Override
    public String toString() {
        return "%-10s%s".formatted(store,super.toString());
    }
    public class StoreComparator<T extends StoreEmployee>  implements Comparator<StoreEmployee> {
        @Override
        public int compare(StoreEmployee o1, StoreEmployee o2) {
            int result;
            result = o1.store.compareTo(o2.store);

            //if are o1 and o2 from the same store call comparator of Employee and order by "yearStarted"
            if (result == 0) {
                //System.out.println("Result "+result+" o1 "+o1+" o2 "+o2);
                return new Employee.ComparatorEmployee<>("yearStarted").compare(o1,o2);
            }
            return result;
        }
    }
}