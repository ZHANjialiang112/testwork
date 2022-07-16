package zjl.com.test;

/**
 * @Auther: ZJL
 * @Date: 2022/6/28 23:02
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        child child = new child();
        child.say();
        child.sayHello();
        child.sayhello1();
        System.out.println(child.isPublic);
        System.out.println(child.isProtected);
        System.out.println(child.isDefault);
    }
}
