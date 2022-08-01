import entities.Veiculo;
import mapa.MapaHashLSE;
import mapa.mapaHashLDE;
import mapa.MapaHashVetor;
import vetor.VetorMap;
import vetor.IVetor;
import java.lang.*;


public class Main {
    public static void main(String[] args) {

        long count = 99999;
        long count1 = 100000;
        Veiculo[] veiculos = new Veiculo[(int)count1];
        MapaHashLSE mapa = new MapaHashLSE(count);

        for (int i = 0; i<count; i++){
            veiculos[i] = new Veiculo();
            mapa.put(veiculos[i].getChassi(), veiculos[i]);
        }

        String print = mapa.print();
        System.out.println(print);

//        Veiculo v1  = new Veiculo();
//        Veiculo v2  = new Veiculo();
//        Veiculo v3  = new Veiculo();
//        Veiculo v4  = new Veiculo();
//
//        System.out.println(v1.toString());
//        System.out.println(v2.toString());
//        System.out.println(v3.toString());
//        System.out.println(v4.toString());

//        long count2 = 100000;
//        Veiculo[] veiculos1 = new Veiculo[(int) count2];
//        mapaHashLDE mapa1 = new mapaHashLDE(count2);
//        for (int i = 0; i<count2; i++){
//            veiculos1[i] = new Veiculo();
//            mapa1.put(veiculos1[i].getChassi(), veiculos1[i]);
//        }
//        String print2 = mapa1.print();
//        System.out.println(print2);

//        long count2 = 100000;
//        Veiculo[] veiculos1 = new Veiculo[(int) count2];
//        MapaHashVetor mapa1 = new MapaHashVetor((int) count2);
//        long tempoI = System.nanoTime();
//        for (int i = 0; i<count2; i++){
//            veiculos1[i] = new Veiculo();
//            if(veiculos1[i].getChassi()>202099992) {
//                mapa1.put(veiculos1[i].getChassi(), veiculos1[i]);
//            }
//        }
//        long tempoF = System.nanoTime();
//        System.out.println("Tempo total= "+(tempoF-tempoI));
        //Veiculo a5 = new Veiculo();
      //  Veiculo a7 = new Veiculo();
        //mapa1.put(23,a5);
        //mapa1.put(202059667,a7);
      //  String print2 = mapa1.print();

        // System.out.println(print2);
        //IVetor elem = new VetorMap();
        //System.out.println(IVetor.selectionSort(veiculos1));
        //Veiculo vv = new Veiculo();
        //IVetor.remove(vv);
        //System.out.println(print2);
        //System.out.println("====================================================");
      //  mapa1.remove(202099998);
        //mapa1.put(123,a7);
       // String print3 = mapa1.print();
       // System.out.println(print3);
    }
}


