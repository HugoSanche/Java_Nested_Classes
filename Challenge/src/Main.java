import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

//My solution from challenge Anonymous class
public class Main {
    public static void main(String[] args) {
        List<Employee> list =new ArrayList<>();

         Employee h=new Employee("Hugo","Baltazar","05/08/2018");
         Employee v=new Employee("Veronica","Perez","09/10/2015");
         Employee c=new Employee("Carolina","Sanchez","06/04/2010");
         Employee g=new Employee("Guissell","Ramirez","14/12/2017");

         list.add(h);
        list.add(v);
        list.add(c);
        list.add(g);
        printEmployees(list,"name");
        System.out.println("Sorted by yearHide");
        printEmployees(list,"year");
    }
    public static void printEmployees(List<Employee> eList, String sortedField){
      int currentYear= LocalDate.now().getYear();
        class MyEmployee{
            Employee containedEmployee;
            int yearsWorked;
            String fullName;

            public MyEmployee(Employee containedEmployee) {
                this.containedEmployee = containedEmployee;
                yearsWorked=currentYear-Integer.parseInt(containedEmployee.hireDate().split("/")[2]);
                fullName=String.join(" ",containedEmployee.firstName(),containedEmployee.lastName());
            }

            @Override
            public String toString() {
                return "%s has an employee for %d".formatted(fullName,yearsWorked);
            }
        }
        List<MyEmployee> list =new ArrayList<>();

        for(Employee e:eList){
           list.add(new MyEmployee(e));
        }
        var comparator =new Comparator<MyEmployee>(){
            @Override
            public int compare(MyEmployee o1, MyEmployee o2) {
                if (sortedField.equals("name")){
                    return o1.fullName.compareTo(o2.fullName);
            }
            return o1.yearsWorked-o2.yearsWorked;
        }
        };
        list.sort(comparator);
        for(MyEmployee myEmployee:list){
            System.out.println(myEmployee);
        }
    }

}