import arvore.ABB;
import entities.Veiculo;
import mapa.MapaHashLSE;


public class Main {
    public static void main(String[] args) {
        long count = 100000;
        Veiculo[] veiculos = new Veiculo[(int) count];
        MapaHashLSE mapa = new MapaHashLSE(count);
        for (int i = 0; i<count; i++){
            veiculos[i] = new Veiculo();
            mapa.put(veiculos[i].getChassi(), veiculos[i]);
        }
        String print = mapa.print();
        System.out.println(print);
    }
}

class MainABB {
    public static void main(String[] args) {
        long count = 100000;
        Veiculo[] veiculos = new Veiculo[(int) count];
        ABB arvore = new ABB();

        long start = System.currentTimeMillis();
        for (int i = 0; i<count; i++){
            veiculos[i] = new Veiculo();
            arvore.add(veiculos[i]);
            System.out.println(veiculos[i]+" | "+i);
        }
        long end = System.currentTimeMillis();
        System.out.println((start-end)/1000);
        //A adição recursiva resultou em 11s
        //A adição iterativa resultou em 10s
        
        
        //arvore.imprimeArvoreOrdenadaRec();
        
    }
}
