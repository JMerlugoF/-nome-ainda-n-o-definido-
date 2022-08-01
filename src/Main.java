import entities.Veiculo;
import mapa.MapaHashLSE;
import mapa.mapaHashLDE;
import mapa.MapaHashVetor;
import vetor.VetorMap;
//import vetor.IVetor;
import java.lang.*;

public class Main {
    public static void main(String[] args) {
        /*
        long count = 100000;
        Veiculo[] veiculos = new Veiculo[(int) count];
        for (int i = 0; i<count; i++) {
            veiculos[i] = new Veiculo();
        }
        //VetorMap.sort(veiculos);
*/
        long count = 100000;
        Veiculo[] veiculos = new Veiculo[(int) count];
        MapaHashLSE mapa = new MapaHashLSE(count);
        //long tempoI = System.nanoTime();

        for (int i = 0; i<count; i++){
            //if(veiculos[i].getChassi()>202099992) {
                veiculos[i] = new Veiculo();
            //}
            mapa.put(veiculos[i].getChassi(), veiculos[i]);
        }

        //long tempoF = System.nanoTime();

        //System.out.println("Tempo total= "+(tempoF-tempoI));
        String print = mapa.print();
        System.out.println(print);
/*
        long count2 = 100000;
        Veiculo[] veiculos1 = new Veiculo[(int) count2];
        mapaHashLDE mapa1 = new mapaHashLDE(count2);
        for (int i = 0; i<count2; i++){
            veiculos1[i] = new Veiculo();
        }
        for (int i = 0; i<count2; i++){
            mapa1.put(veiculos1[i].getChassi(), veiculos1[i]);
        }
        String print = mapa1.print();
        System.out.println(print);

        MapaHashVetor mapa1 = new MapaHashVetor((int) count);
        int count2=100000;
        long tempoI = System.nanoTime();
        for (int i = 0; i<count2; i++){
            if(veiculos[i].getChassi()>202059992) {
                mapa1.put(veiculos[i].getChassi(), veiculos[i]);
            }
        }
        long tempoF = System.nanoTime();
        System.out.println("Tempo total= "+(tempoF-tempoI));
/*
        //Veiculo a5 = new Veiculo();
        //Veiculo a7 = new Veiculo();
        //mapa1.put(23,a5);
        //mapa1.put(202059667,a7);
        //String print2 = mapa1.print();

        // System.out.println(print2);
        //IVetor elem = new VetorMap();
        long tempoI2 = System.nanoTime();
        MapaHashVetor.sort(mapa1);
        long tempoF2 = System.nanoTime();
        System.out.println("Tempo total= "+(tempoF2-tempoI2));
        //Veiculo vv = new Veiculo();
        //IVetor.remove(vv);
        //System.out.println(print2);
        //System.out.println("====================================================");
        //mapa1.remove(202099998);
        //mapa1.put(123,a7);
        String print = mapa1.print();
        System.out.println(print);
        */

    }
}


