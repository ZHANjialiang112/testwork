package zjl.com.test;

/**
 * @Auther: ZJL
 * @Date: 2022/6/28 23:00
 * @Description:
 */
public class hello {
    public  String isPublic ="public";
    protected  String isProtected = "protected";
     String  isDefault = "default";
    private  String isPrivate = "private";

    public void sayHello() {
        System.out.println("hello public");
    }

    protected void say() {
        System.out.println("Hello protected");
    }

    void sayhello1() {
        System.out.println("hello default ");
    }

    private void say1() {
        System.out.println("hello private");
    }
}
