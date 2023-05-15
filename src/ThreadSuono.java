public class ThreadSuono extends Thread{
    private Campana c;

    public ThreadSuono(String nome, Campana c){
        super(nome);
        this.c = c;
    }

    @Override
    public void run(){
        c.emettiSuono();
    }
}