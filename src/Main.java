import java.time.Instant;
import java.util.Map;

import arvore.ABB;
import arvore.RequisitosA;
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
        Veiculo[] veiculos = new Veiculo[(int) 100000];
        ABB arvore = new ABB();
        RequisitosA.Adicionar100mil(veiculos, arvore);
        RequisitosA.RemoverVeiculos(arvore);
        RequisitosA.ImprimirCrescente(arvore);
        RequisitosA.CarrosDaFord(arvore);
    }
}
