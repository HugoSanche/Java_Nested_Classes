import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class RunMethods {
    public static void main(String[] args) {
        List<StoreEmployee> storeEmployees2 = new ArrayList<>(List.of(
                new StoreEmployee(5004, "Pedro", 2008, "Liverpool"),
                new StoreEmployee(10024, "Hugo", 2018, "Valmex"),
                new StoreEmployee(1009, "Gerardo", 2019, "Valmex"),
                new StoreEmployee(5004, "Veronica", 2014, "SAMS"),
                new StoreEmployee(5004, "Carolina", 2010, "Wallmart")
        ));

        var c0 = new ComparatorEmployee<StoreEmployee>();//Instance of ComparatorEmployee class
        var c1 = new Employee.ComparatorEmployee<StoreEmployee>(); //Instance of the nested class, EmployeeComparator on the Employee Class
        var c2 = new StoreEmployee().new StoreComparator<StoreEmployee>();//Comparator of inner class

        class NameSort<T> implements Comparator<StoreEmployee>{
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName2().compareTo(o2.getName2());
            }
        }
        var c3 =new NameSort<StoreEmployee>(); //Comparator local class

        var c4 = new Comparator<StoreEmployee>(){ //Comparator using Anonymous class
            //THIS IS ANONYMOUS CLASS CHECK DON'T HAVE NAME
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName2().compareTo(o2.getName2());
            }
        };// punto y como porque es una expresion no una declaracion

        sortIt(storeEmployees2,c0);
        sortIt(storeEmployees2,c1);
        sortIt(storeEmployees2,c2);
        sortIt(storeEmployees2,c3);
        sortIt(storeEmployees2,c4);
        sortIt(storeEmployees2,new Comparator<StoreEmployee>(){ //Comparator using Anonymous class
            //THIS IS ANONYMOUS CLASS CHECK DON'T HAVE NAME
            @Override
            public int compare(StoreEmployee o1, StoreEmployee o2) {
                return o1.getName2().compareTo(o2.getName2());
            }
        });

        //Anonymous class using before java 8, now its more common to use lambda expression
        //Anonymous class would be replaced by Lambda Expression
        sortIt(storeEmployees2, (o1, o2) -> o1.getName2().compareTo(o2.getName2())); //Using Lambda expression
        }

    public static <T> void sortIt(List <T> list, Comparator <? super T > comparator){
        System.out.println("Sorting with Comparator " + comparator.toString());
        list.sort(comparator);
        for (var employee : list) {
            System.out.println(employee);
        }
    }
}
