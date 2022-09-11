package zjl.com.other;

import net.sf.cglib.core.CollectionUtils;

import javax.swing.text.DateFormatter;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.time.LocalDate;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Test {
    public static void main(String[] args) {

        //add


//        people people = new people();
//        people.setAge(12);
//        buildPeople(people);
//        System.out.println(people);
//
        Date date = new Date();
//        Calendar instance = Calendar.getInstance();
//        instance.setTime(date);
//        System.out.println(date);
//        System.out.println(instance);



//        LocalDate now = LocalDate.now();
//        int i = now.compareTo(LocalDate.parse("2024-09-01"));
//        System.out.println(i);

//

        List<String> list = new ArrayList<>();
        list.add("2022-4-12");
        list.add("1022-10-12");
        list.add("2022-3-12");
        list.add("2021-8-12");
        list.add("2022-4-15");
        list.add(null);
        list.add(null);
//        List<String> collect = list.stream().filter(Objects::nonNull).collect(Collectors.toList());
//        boolean empty = collect.isEmpty();
//        System.out.println(empty);
//        String s = list.stream().filter(Objects::nonNull).min(String::compareTo).get();
//        System.out.println(s);
//        System.out.println(list);
//        System.out.println(list);
        List<String> stringList = new ArrayList<>();
        System.out.println(stringList.size());
    }

    public  static void buildPeople(people people){
        people.setName("张三");
    }
}





class people{
    private int age;
    private String name;

    public people(int age, String name) {
        this.age = age;
        this.name = name;
    }

    public people() {
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "people{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}