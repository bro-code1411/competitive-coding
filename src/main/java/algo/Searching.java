package algo;

import javax.xml.namespace.QName;
import java.util.*;
import java.util.stream.Collectors;


public class Searching {
    public static class Person{
        private String name;
        private Long phoneNo;
        private Integer age;
        private String parentName;

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public Long getPhoneNo() {
            return phoneNo;
        }

        public void setPhoneNo(Long phoneNo) {
            this.phoneNo = phoneNo;
        }

        public Integer getAge() {
            return age;
        }

        public void setAge(Integer age) {
            this.age = age;
        }

        public String getParentName() {
            return parentName;
        }

        public void setParentName(String parentName) {
            this.parentName = parentName;
        }

        public Person(String name, Long phoneNo, Integer age, String parentName) {
            this.name = name;
            this.phoneNo = phoneNo;
            this.age = age;
            this.parentName = parentName;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Person person = (Person) o;
            return Objects.equals(name, person.name) &&
                    Objects.equals(phoneNo, person.phoneNo) &&
                    Objects.equals(age, person.age) &&
                    Objects.equals(parentName, person.parentName);
        }

        @Override
        public int hashCode() {
            return Objects.hash(name, phoneNo, age, parentName);
        }

        @Override
        public String toString() {
            return "Person{" +
                    "name='" + name + '\'' +
                    ", phoneNo=" + phoneNo +
                    ", age=" + age +
                    ", parentName='" + parentName + '\'' +
                    '}';
        }
    }

    public static HashMap<String, Person> nameToPersonMap = new HashMap<>();

    public static void insertData(Person person){
        nameToPersonMap.put(person.getName(), person);
    }

    public static List<Person> searchForName(String name){
        List<String> names = nameToPersonMap.keySet().stream().filter(s -> s.toLowerCase().contains(name.toLowerCase())).collect(Collectors.toList());
        List<Person> result = new ArrayList<>();
        for (String n : names){
            result.add(nameToPersonMap.get(n));
        }
        return result;
    }
    public static List<Person> searchForNames(List<String> nameList){
        List<Person> result = new ArrayList<>();
        for(String a : nameList){
            for (String key : nameToPersonMap.keySet()){
                if(key.toLowerCase().contains(a.toLowerCase())){
                    result.add(nameToPersonMap.get(key));
                }
            }
        }
        return result;
    }
    public static void main(String[] args){
        Person p1 = new Person("John Mathew Smith", 9876543210L, 10,"Scott Sr");
        Person p2 = new Person("Frodo Baggins", 986902643210L, 16,"Drogo Baggins");
        Person p3 = new Person("John Mathew smith", 9876543210L, 10,"Scott Sr");

        insertData(p1);
        insertData(p2);
        insertData(p3);
        List<Person> result = searchForName("baggins");
        List<Person> result2 = searchForNames(Arrays.asList("smith", "frodo"));

        result2.forEach(a-> System.out.println(a.toString()));

    }
}
