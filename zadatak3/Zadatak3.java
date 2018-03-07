package zadatak3;
import java.util.concurrent.*;
import java.nio.charset.Charset;
import java.util.Random;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveTask;

/**
 *
 * @author manojlovic
 */
public class Zadatak3 {

    public static void main(String[] args) {

        final int SIZE = 6000000;
        byte[] lista1 = new byte[SIZE];
        new Random().nextBytes(lista1);
        String generisaniString = new String(lista1, Charset.forName("UTF-8"));

        long startTime = System.currentTimeMillis();

        int brojac = 0;
        for (int i = 0; i < lista1.length; i++) {
            if (lista1[i] == 'a' || lista1[i] == 'e' || lista1[i] == 'i'
                    || lista1[i] == 'o' || lista1[i] == 'u'
                    || lista1[i] == 'A' || lista1[i] == 'E' || lista1[i] == 'I'
                    || lista1[i] == 'O' || lista1[i] == 'U') {
                brojac++;
            } else {

            }
        }
        System.out.println("Broj samoglasnika je: " + brojac);

        long endTime = System.currentTimeMillis();
        System.out.println("The number of processors is " + Runtime.getRuntime().availableProcessors());
        System.out.println("Time is " + (endTime - startTime));
    }

    
    
    
    
  //  public static int max(int[] list) {
    //  }
    
    /*
    private static class Zadatak3 extends RecursiveTask<Integer> {
    private final static int THRESHOLD = 1000;
    private int[] list;
    private int low;
    private int high;
    // }
    
       public Zadatak3(byte[] lista1, int low, int high) {
            this.lista1 = lista1;
            this.low = low;
            this.high = high;
       }
    
    
 //   @Override
// public Integer compute() {

        @Override
        protected Integer compute() {
            throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        }
    
    
}*/
}
