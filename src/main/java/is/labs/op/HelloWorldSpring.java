package is.labs.op;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.Calendar;
import java.util.Date;

public class HelloWorldSpring {

    public static void main(String[] args) {
        ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");

        System.out.println(context.getBean("helloWorldBean",StringBean.class).getString());
    }

}
