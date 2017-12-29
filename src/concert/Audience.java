package concert;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class Audience {

    @Pointcut("execution(* concert.Performance.perform(..))")
    public void perform() {
    }

    @Pointcut("execution(* concert.Performance.c*(int))" + " && args(times)")
    public void count(int times) {
    }

    @Pointcut("execution(* concert.Performance.show(int,int))"+"&& args(a,b)")
    public void show(int a ,int b){}

    @Around("show(a,b)")
    public void showArgs(ProceedingJoinPoint pjp, int a, int b){
        Object[] args = pjp.getArgs();
        Object temp = args[0];
        args[0] = args[1];
        args[1] = temp;
        try {
            pjp.proceed(args);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
    }

    @Around("count(times)")
    public int countPerformance(ProceedingJoinPoint pjp, int times) {
        int result = 0;
        System.out.println("已表演次数：" + times);
        try {
            Object[] args = pjp.getArgs();
            args[0] = times + 1;
            result = (int) pjp.proceed(args);
            System.out.println("最新的表演次数：" + result);
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        return result;
    }

    @Before("perform()")
    public void applause() {
        System.out.println("观众鼓掌欢迎表演");
    }

    @After("perform()")
    public void recognize() {
        System.out.println("观众认可该表演");
    }

    @Around("perform()")
    public void keepQuiet(ProceedingJoinPoint pjp) {
        System.out.println("保持安静，以示尊重。");
        try {
            pjp.proceed();
        } catch (Throwable throwable) {
            throwable.printStackTrace();
        }
        System.out.println("鼓掌表示感谢。");
    }
}
