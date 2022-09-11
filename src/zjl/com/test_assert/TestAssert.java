package zjl.com.test_assert;

import com.sun.istack.internal.NotNull;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.stream.Collectors;


public class TestAssert {
    public static List<Person> personList = new ArrayList<>(10);
    public static String[] names = {"张三","李额四","王准备五","二狗子",""};
    public static void main(String[] args) {

        ArrayList<String> list = new ArrayList<>();
        list.add("hello");
        System.out.println("Test Assert start!!");
        assert 1 > 0;
        System.out.println("1 > 0 access!!");

//        测试断言
//        assert isEmpty(list);
        System.out.println("Test end!!");

        buildPersonList();
    }

    public static Boolean isEmpty(Collection<String> list) {
        return list.isEmpty();
    }

    public static void buildPersonList(){
        for (String name : names) {
            personList.add(new Person(name, name.length()));
        }
        testFunction(personList,list-> personList.stream()
                .map(Person::getName)
                .filter(Objects::nonNull)
                .collect(Collectors.toList()));
    }


    public static void testFunction(@NotNull List<Person> persons, Function<List<Person>,List<String>> function){
        List<Integer> collect = function.apply(personList).stream().map(String::length).collect(Collectors.toList());
        System.out.println(collect);
    }
}

class Person{
    private String name;
    private int age;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Person person = (Person) o;
        return age == person.age && name.equals(person.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }

    @Override
    public String toString() {
        return "person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
