package concert;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;
import org.springframework.context.support.ClassPathXmlApplicationContext;

@EnableAspectJAutoProxy
@ComponentScan
public class Test {

    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Test.class);
//        Performance performance = (Performance) context.getBean("gamePerformance");
        Performance performance = (Performance) context.getBean("musicPerformance");
        performance.perform();
        performance.show(22,66);
    }
}
