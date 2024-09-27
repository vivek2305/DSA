import org.w3c.dom.ls.LSOutput;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static java.util.Arrays.stream;

public class Main {
    public static void display(){
        System.out.println("pub;ic");
    }
    public static void main(String[] args) {
        //q1- print frequency of each character in given string.
       String s="vivek";
        Map<Character,Long> map= s.chars()
                .filter(c->c!=' ')
                .mapToObj(c->(char)c)
                .collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map);

        // q2 print frequency of each word in given string.

        String s1="hello hello good morning";
        Map<String, Long> map1= Stream.of(s1.split(" ")).collect(Collectors.groupingBy(Function.identity(),Collectors.counting()));
        System.out.println(map1);

        //q3 to find max and min number from a list.

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4,4,6, 5, 6, 7, 8, 9, 10);

        OptionalInt max= numbers.stream()
                .mapToInt(Integer::intValue).max();

        OptionalInt min = numbers.stream()
                .mapToInt(Integer::intValue)
                .min();
        System.out.println(max+" "+min);

        //q4 2nd largest number
        Optional<Integer> second= numbers.stream()
                .distinct()
                .sorted(Comparator.reverseOrder())
                .skip(1)
                .findFirst();
        if(second.isPresent())
            System.out.println(second);

        //q4 find sum of list of numbers

        OptionalInt sum= numbers.stream()
                .mapToInt(Integer::intValue)
                .reduce(Integer::sum);
        System.out.println(sum);

        //q5 print even no

        numbers.stream().filter(x->x%2==0)
                .forEach(System.out::println);
        numbers.stream().filter(x->x%2!=0)
                .forEach(System.out::println);

        // remove duplicate from a list
        System.out.println("remove duplicates");
        List<Integer> out=numbers.stream()
                .distinct()
                .toList(); // or .collect(COllectors.toList());
        System.out.println(out);

        // retrieve distinct elements for employee list
        List<Employee> employeeList=new ArrayList<>();
        employeeList.add(new Employee(1,"shivendar",27,50000,"Infosys"));
        employeeList.add(new Employee(2,"vivek",27,76000,"Infosys"));
        employeeList.add(new Employee(4,"rishabh",23,33000,"coforge"));
        employeeList.add(new Employee(3,"amar",28,70000,"coforge"));
        employeeList.add(new Employee(2,"vivek",26,76000,"Infosys"));

        employeeList.stream().distinct().forEach(System.out::println);

        //retrieve last element from string

        numbers.stream().reduce((a,b)->b).ifPresent(System.out::println);

        // reverse each word of a string
        String out1=Stream.of(s1.split(" "))
                .map(word-> new StringBuilder(word).
                        reverse().toString()).collect(Collectors.joining(" "));
        System.out.println(out1);

        //sort list of string alphabetically
        Stream.of(s1.split(" "))
                .sorted().forEach(System.out::println); // .collect(Collectors.joining(" ")); for returning a String

     //to count characters in a string

     int out2= (int) s.chars().mapToObj(c->(char)c)
             .count();
     System.out.println(out2);

     //find first repeated character in a string

     Set<Character> a= new HashSet<>();
     s.chars().mapToObj(c->(char)c)
             .filter(x->!(a.add(x))).findFirst().ifPresent(System.out::println);
    }
}
