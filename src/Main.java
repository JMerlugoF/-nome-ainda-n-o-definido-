import arvore.ABB;
import arvore.RequisitosA;
import entities.Veiculo;
import mapa.HashMapVetor;
import mapa.HashMapLDE;

import java.lang.*;

public class Main {
}
class MainVetor {
    public static void main(String[] args) {
        int count = 100000;
        Veiculo[] veiculos = new Veiculo[count];
        for (int i = 0; i < count; i++) {
            veiculos[i] = new Veiculo();
        }

        HashMapVetor mapaV = new HashMapVetor(count);

        long tempoI = System.nanoTime();
        for (int i = 0; i < count; i++) {
            mapaV.put(veiculos[i].getChassi(), veiculos[i]);
        }
        long tempoF = System.nanoTime();

        long tempoI2 = System.nanoTime();
        System.out.println(mapaV.verificaFord());
        long tempoF2 = System.nanoTime();

        long tempoI3 = System.nanoTime();
        String print = mapaV.print();
        System.out.println(print);
        long tempoF3 = System.nanoTime();
        System.out.println("--------------------------------------------------");
        long tempoI4 = System.nanoTime();
        mapaV.removeMenorIgual();
        long tempoF4 = System.nanoTime();

        System.out.println("Tempo total operacoes VETOR");
        System.out.println("Insercao de 100 mil veiculos = " + (tempoF - tempoI));
        System.out.println("Verificacao do numero de veiculos da marca Ford = " + (tempoF2 - tempoI2));
        System.out.println("Apresentacao dos veiculos = " + (tempoF3 - tempoI3));
        System.out.println("Remocao dos veiculos com Chassi igual ou inferior a 202050000 = " + (tempoF4 - tempoI4));
    }
}
class MainLDE {
    public static void main(String[] args) {
        int count = 100000;
        Veiculo[] veiculos = new Veiculo[count];

        for (int i = 0; i < count; i++) {
            veiculos[i] = new Veiculo();
        }

        HashMapLDE mapaLDE = new HashMapLDE(count);
        long tempoI5 = System.nanoTime();
        for (int i = 0; i < count; i++) {
            mapaLDE.put(veiculos[i].getChassi(), veiculos[i]);
        }
        long tempoF5 = System.nanoTime();

        long tempoI6 = System.nanoTime();
        System.out.println(mapaLDE.verificaFordLDE());
        long tempoF6 = System.nanoTime();

        long tempoI7 = System.nanoTime();
        String print2 = mapaLDE.print();
        System.out.println(print2);
        long tempoF7 = System.nanoTime();

        long tempoI8 = System.nanoTime();
        mapaLDE.removeMenorIgualLDE();
        long tempoF8 = System.nanoTime();

        System.out.println("Tempo total operações LDE");
        System.out.println("Inserção de 100 mil veículos = " + (tempoF5 - tempoI5));
        System.out.println("Verificação do número de veículos da marca Ford = " + (tempoF6 - tempoI6));
        System.out.println("Apresentação dos veículos = " + (tempoF7 - tempoI7));
        System.out.println("Remoção dos veículos com Chassi igual ou inferior à 202050000 = " + (tempoF8 - tempoI8));
    }
}
class MainABB {
    public static void main(String[] args) {
        int count = 100;
        Veiculo[] veiculos = new Veiculo[count];

        ABB abb = new ABB();
        long tempoI9 = System.nanoTime();
        RequisitosA.Adicionar100mil(veiculos, abb);
        long tempoF9 = System.nanoTime();

        long tempoI10 = System.nanoTime();
        RequisitosA.CarrosDaFord(abb);
        long tempoF10 = System.nanoTime();

        long tempoI11 = System.nanoTime();
        RequisitosA.ImprimirCrescente(abb);
        long tempoF11 = System.nanoTime();

        long tempoI12 = System.nanoTime();
        RequisitosA.RemoverVeiculos(abb);
        long tempoF12 = System.nanoTime();

        System.out.println("Tempo total operações Árvore");
        System.out.println("Inserção de 100 mil veículos = " + (tempoF9 - tempoI9));
        System.out.println("Verificação do número de veículos da marca Ford = " + (tempoF10 - tempoI10));
        System.out.println("Apresentação dos veículos = " + (tempoF11 - tempoI11));
        System.out.println("Remoção dos veículos com Chassi igual ou inferior à 202050000 = " + (tempoF12 - tempoI12));
    }
}

