package zjl.com.testlambda;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Auther: ZJL
 * @Date: 2022/7/27 00:01
 * @Description:
 */
public class testJackson {
    public static List<Person> persons = new ArrayList<>();
    public static List<String> names = new ArrayList<>();
    public static void main(String[] args) {
        names.add("小明");
        names.add("小李李");
        names.add("小王小王");
        names.add("黎明明");
        names.add("黄昏黄昏");
        names.add("joeyddd");
        names.add("Emmasdfd");
        List<String> skill = new ArrayList<>();
        skill.add("篮球球");
        skill.add("羽毛球");
        skill.add("羽毛球篮球");
        skill.add("羽毛球篮球");
        skill.add("羽毛球篮球");
        Person person = new Person("小明", 22, skill);
        names.forEach(name -> {
            Person ps = new Person();
            ps.setAge(person.getAge());
            ps.setName(name);
            ps.setSkillList(skill);
            persons.add(ps);
        });

        showPerson(persons);
        showMapPerson(persons);
    }

    public static <E> void show(Collection<E> E) {
        E.forEach(i->{
            System.out.println(i.toString());
        });
    }

    public static void showPerson(Collection<Person> persons){
        List<String> collect = persons.stream()
                .filter(person -> person.getName().length() <= 3)
                .map(Person::getName)
                .collect(Collectors.toList());
        show(collect);
    }

    public  static  void showMapPerson(Collection<Person> persons){
        List<List<String>> collect = persons.stream().filter(i -> i.getName().length() > 3)
                .map(Person -> Person.
                        getSkillList()
                        .stream()
                        .filter(t -> t.length()>3)
                        .map(i -> i.substring(2,5))
                        .collect(Collectors.toList()))
                .collect(Collectors.toList());
        show(collect);

    }
}
