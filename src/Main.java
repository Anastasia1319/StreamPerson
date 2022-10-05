import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Address address1 = new Address("Cardiff", "Aberbran Rd.", 8);
        Address address2 = new Address("Liverpool", "Vale Rd.", 20);
        Address address3 = new Address("Oxford", "Oatlands Rd.", 48);
        Address address4 = new Address("Norwich", "Eaton Rd.", 58);
        Address address5 = new Address("Nottingham", "Balfour Rd.", 13);

        Person person1 = new Person ("Paul", "Stephens", address1);
        Person person2 = new Person("Coleen", "Rice", address2);
        Person person3 = new Person("Thomas", "Webster", address3);
        Person person4 = new Person(null, "Rose", address4);
        Person person5 = new Person("Donna", null, address5);
        Person person6 = new Person("Thomas", "Eaton", null);

        List<Person> personList = Arrays.asList(person1,person2, person3, person4, person5, person6);

        personList.stream()
                .filter(p ->(p.getFirstName() != null))
                .filter(p ->(p.getLastName() != null))
                .filter(p -> (p.getAddress() != null))
                .sorted(Comparator.comparingInt(p -> p.getAddress().getHouseNumber()))
                .map(p -> p.toString())
                .collect(Collectors.toList())
                .forEach(System.out::println);
    }
}