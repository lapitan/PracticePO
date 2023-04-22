package is.labs.op;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.IntStream;

public class HelloWorldSpring {

    private static short f(short n){
        if (n<2){
            return 1;
        }
        return (short) (n * f((short) (n-1)));
    }

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context.getBean("helloWorldBean",StringBean.class).getString());

        int a=5;
        int b =100;

        System.out.println(0x02);


    }

}
