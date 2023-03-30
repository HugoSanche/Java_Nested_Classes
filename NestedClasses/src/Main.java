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
    }
}