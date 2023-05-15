import java.util.List;
import java.util.ArrayList;

public class App {
    public static void main(String[] args) throws Exception {
        Campana c = new Campana();
        List <ThreadSuono> suoni = new ArrayList<>();
        ThreadSuono T_din = new ThreadSuono("DIN", c);
        ThreadSuono T_don = new ThreadSuono("DON", c);
        ThreadSuono T_dan = new ThreadSuono("DAN", c);
        suoni.add(T_din);
        suoni.add(T_don);
        suoni.add(T_dan);
        for(ThreadSuono suono : suoni){
            suono.start();
        }
        long tempoDurataSequenza = 10000;
        Thread.sleep(tempoDurataSequenza);
        System.exit(0);
    }
}