public class Campana {
    private int countSuoni;
    private String [] suoni;
    
    public Campana(){
        countSuoni = 0;
        //Creo un array di stringhe nel quale inserisco i tre suoni
        suoni = new String[] {"DIN", "DON", "DAN"};
    }

    public synchronized void emettiSuono() {
        String nome = Thread.currentThread().getName();
        //Controllo se il nome del thread corrisponde a quello all'interno dell'array
        try{
            while(nome != suoni[countSuoni]){
                wait();
            }
        } catch (InterruptedException ex){}
        //Stampo il suono corrente
        System.out.println("Suono: -->" + suoni[countSuoni]);
        //Controllo se ho terminato una sequenza completa (DIN, DON, DAN)
        if(countSuoni == 2){
            countSuoni = -1;
        }
        //Imposto la durata del ThreadSuono, facendolo "dormire" per 1 secondo
        try{
            Thread.sleep(1000);
        }catch(Exception ex){}
        //Vado al prossimo suono nell'array suoni[]
        countSuoni++;
        //Notifico agli altri ThreadSuono che possono "risvegliarsi"
        notifyAll();
    }
}