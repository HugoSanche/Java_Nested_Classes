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
        List<StoreEmployee> storeEmployees2=new ArrayList<>(List.of(
                new StoreEmployee(5004,"Pedro",2008,"Liverpool"),
                new StoreEmployee(10024,"Hugo",2018,"Valmex"),
                new StoreEmployee(1009,"Gerardo", 2019,"Valmex"),
                new StoreEmployee(5004,"Veronica",2014,"SAMS"),
                new StoreEmployee(5004,"Carolina",2010,"Wallmart")
        ));

        var comparatorOfEmployee=new Employee.ComparatorEmployee<>();
        storeEmployees2.sort(comparatorOfEmployee);//check you are used Comparator from Employee not comparator of StoreEmployee

        //accessing a class   of inner class
        //Check how accessing to class StoreComparator
        var store=new StoreEmployee();
        var comparatorOfStore=store.new StoreComparator<>();//check you are used Comparator from StoreEmployee not comparator of Employee
        storeEmployees2.sort(comparatorOfStore);
        for(StoreEmployee e: storeEmployees2 ){
            System.out.println(e);
        }
        System.out.println("With Local Clases Pig Latin names");
        addPingLatinName(storeEmployees2);

    }
    public static void addPingLatinName(List<? extends StoreEmployee>list ){
        //Check I created an entire class behind the static void method
        //I don't want to add this class to my library of classes
        //I don't want to anyone used or extended
        //it's only used for this specific topics

        String lastName="Apodo";
        class DecoratedEmployee extends StoreEmployee implements Comparable<DecoratedEmployee>{
            private String pigLatinName; //check this variable would be final
            private Employee originalInstance; ///check this variable would be final
            //private String test="No final";

            public DecoratedEmployee(String pigLatinName, Employee originalInstance) {
                this.pigLatinName = pigLatinName+" "+lastName;
                this.originalInstance = originalInstance;
            }

            @Override
            public String toString() {
                //pigLatinName="";
                return originalInstance.toString()+" "+pigLatinName;
            }

            @Override
            public int compareTo(DecoratedEmployee o) {
                return pigLatinName.compareTo(o.pigLatinName);
            }
        }
        List<DecoratedEmployee> newlist=new ArrayList<>(list.size());
        for (var employee:list){
            String name=employee.getName2();
            String pigLatin=name.substring(1)+name.charAt(0)+"ay";
            newlist.add(new DecoratedEmployee(pigLatin,employee));
        }
        //if ypu pass null in to the sort method on a list it will use comparable
        newlist.sort(null);
        for (var decorated:newlist){
            System.out.println(decorated.originalInstance.getName2()+" "+decorated.pigLatinName);
        }
       // lastName="sobrenombre"; //error lastName would be final
    }
}