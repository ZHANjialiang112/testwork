package zjl.com.porxy;

/**
 * @Auther: ZJL
 * @Date: 2022/4/23 10:59
 * @Description:
 */
public class UserPorxy implements UserManager {
    public String name = "hello";
    @Override
    public void addUser(String user) {
        System.out.println("add user:"+user);
    }
}
