package zjl.com.test_interface;

/**
 * @Auther: ZJL
 * @Date: 2022/5/28 18:19
 * @Description:
 */
public class X {
    Y y = new Y();

    static {
        System.out.println("tttt");
    }

    X() {
        System.out.println("X");
    }

    public static void main(String[] args) {
        new Z();
    }
}

class Y {
    Y() {
        System.out.println("Y");
    }
}

class Z extends X {
    Y y = new Y();

    static {
        System.out.println("tt");
    }

    Z() {
        System.out.println("Z");
    }
}

