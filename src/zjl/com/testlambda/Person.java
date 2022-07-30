package zjl.com.testlambda;

import java.util.List;
import java.util.Objects;

/**
 * @Auther: ZJL
 * @Date: 2022/7/26 23:54
 * @Description:
 */

public class Person implements Cloneable{
    private String name;
    private Integer age;

    private List<String> skillList;

    public Person(String name, Integer age, List<String> skillList) {
        this.name = name;
        this.age = age;
        this.skillList = skillList;
    }
    public Person(){}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public List<String> getSkillList() {
        return skillList;
    }

    public void setSkillList(List<String> skillList) {
        this.skillList = skillList;
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
        return Objects.equals(name, person.name) && Objects.equals(age, person.age) && Objects.equals(skillList, person.skillList);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age, skillList);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", skillList=" + skillList +
                '}';
    }

}
