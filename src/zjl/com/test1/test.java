package zjl.com.test1;

/**
 * @Auther: ZJL
 * @Date: 2022/6/28 23:09
 * @Description:
 */
public class test {
    public static void main(String[] args) {
        child child = new child();
        child.childTest();
        child.sayHello();

        testFinal("helo");
    }
    public static void testFinal(final String hello){
        System.out.println("HI"+ hello);
    }
}
