package zjl.com.porxy;

import java.util.ArrayList;

/**
 * @Auther: ZJL
 * @Date: 2022/4/23 11:05
 * @Description:
 */
public class Test {
    public static void main(String[] args) {
        //JDKProxy jdkProxy = new JDKProxy();
        //UserManager user = (UserManager) jdkProxy.getJDKProxy(new UserPorxy());
        //user.addUser("hello");

        //CGLIBProxy cglibProxy = new CGLIBProxy();
        //UserManager user = (UserManager)cglibProxy.getProxy(new UserPorxy());
        //user.addUser("hello");

        ArrayList<Object> proxy = (ArrayList<Object>) new CGLIBProxy().getProxy(new ArrayList<>());
        proxy.add("hello");
    }
}
