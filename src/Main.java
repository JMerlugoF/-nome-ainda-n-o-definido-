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
        for (int i = 0; i<count; i++){
            veiculos[i] = new Veiculo();
            arvore.recursiveAdd(veiculos[i]);
        }
        long start = System.currentTimeMillis();
        arvore.imprimeArvoreOrdenadaRec();
        long end = System.currentTimeMillis();
        System.out.println((start-end)/1000);
        //A impressão resultou em 9s
    }
}
