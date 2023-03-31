import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        List<Employee> employees=new ArrayList<>(List.of(new Employee(10024,"Hugo",2020),
                                                 new Employee(1001,"Patricia", 2008) ,
                                                 new Employee(1009,"Gerardo", 2018),
                                                 new Employee(10028,"Mary",2015)));

//        var comparator=new ComparatorEmployee<>();
//        employees.sort(comparator);

        //similar to above code but with static nested classes
        employees.sort(new Employee.ComparatorEmployee<>("yearStarted"));

        for (var e:employees){
            System.out.println(e.toString());
        }
        System.out.println("Store Members");
        List<StoreEmployee> storeEmployees=new ArrayList<>(List.of(
                new StoreEmployee(5004,"Pedro",2008,"Liverpool"),
                new StoreEmployee(10024,"Hugo",2018,"Valmex"),
                new StoreEmployee(1009,"Gerardo", 2019,"Valmex"),
                new StoreEmployee(5004,"Veronica",2014,"SAMS"),
                new StoreEmployee(5004,"Carolina",2010,"Wallmart")
        ));

        var comparatorOfEmployee=new Employee.ComparatorEmployee<>();
        storeEmployees.sort(comparatorOfEmployee);//check you are used Comparator from Employee not comparator of StoreEmployee

        //accessing a method of inner class
        //Check how accessing to class StoreComparator
        var store=new StoreEmployee();
        var comparatorOfStore=store.new StoreComparator<>();//check you are used Comparator from StoreEmployee not comparator of Employee
        storeEmployees.sort(comparatorOfStore);
        for(StoreEmployee e: storeEmployees ){
            System.out.println(e);
        }
    }
}