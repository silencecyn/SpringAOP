package concert;

import org.springframework.stereotype.Component;

@Component
public class GamePerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Game performance on show.");
    }

    @Override
    public int count(int times) {
        return times;
    }

    @Override
    public void show(int a, int b) {
        System.out.println("a="+a+";b="+b);
    }
}
