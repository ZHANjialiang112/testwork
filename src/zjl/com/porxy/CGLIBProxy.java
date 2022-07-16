package zjl.com.porxy;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @Auther: ZJL
 * @Date: 2022/4/23 14:17
 * @Description:
 */
public class CGLIBProxy implements MethodInterceptor {
    private Object target;
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("cglib代理开始");
        Object invoke = method.invoke(target, objects);
        System.out.println("cglib代理结束");
        return invoke;
    }

    public Object getProxy(Object target) {
        this.target = target;
        return Enhancer.create(target.getClass(), this);
    }
}
