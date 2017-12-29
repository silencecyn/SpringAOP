package concert;

import org.springframework.stereotype.Component;

@Component
public class MusicPerformance implements Performance {
    @Override
    public void perform() {
        System.out.println("Singing the music: The Show.");
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
