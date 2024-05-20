import java.util.Random;

public class Snake extends Obstacle{
    public Snake() {
        super("Yılan",4,0,12, 0);
        setDamage(randomDamageNumber());
    }
    @Override
    public int randomDamageNumber() {
        Random r= new Random();
        return r.nextInt(4) + 3 ;
    }
}
