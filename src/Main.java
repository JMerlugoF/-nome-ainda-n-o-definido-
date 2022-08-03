import java.time.Instant;
import java.util.Map;

import arvore.ABB;
import arvore.RequisitosA;
import entities.Veiculo;
import mapa.HashMapVetor;
import mapa.HashMapLDE;
import mapa.HashMapArvore;
import java.lang.*;

public class Main {
    public static void main(String[] args) {

        int count = 100000;
        Veiculo[] veiculos = new Veiculo[count];
        for (int i = 0; i<count; i++) {
            veiculos[i] = new Veiculo();
        }

        HashMapVetor mapaV = new HashMapVetor(count);

        long tempoI = System.nanoTime();
        for (int i = 0; i<count; i++){
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
        //String printMenorIgual = mapa.print();
        //System.out.println(printMenorIgual);

        System.out.println("Tempo total operações VETOR");
        System.out.println("Inserção de 100 mil veículos = "+(tempoF-tempoI));
        System.out.println("Verificação do número de veículos da marca Ford = "+(tempoF2-tempoI2));
        System.out.println("Apresentação dos veículos = "+(tempoF3-tempoI3));
        System.out.println("Remoção dos veículos com Chassi igual ou inferior à 202050000 = "+(tempoF4-tempoI4));

        int count2 = 100000;
        HashMapLDE mapaLDE = new HashMapLDE(count2);
        long tempoI5 = System.nanoTime();
        for (int i = 0; i<count2; i++){
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
        //String printMenorIgual = mapaLDE.print();
        //System.out.println(printMenorIgual);

        System.out.println("Tempo total operações LDE");
        System.out.println("Inserção de 100 mil veículos = "+(tempoF5-tempoI5));
        System.out.println("Verificação do número de veículos da marca Ford = "+(tempoF6-tempoI6));
        System.out.println("Apresentação dos veículos = "+(tempoF7-tempoI7));
        System.out.println("Remoção dos veículos com Chassi igual ou inferior à 202050000 = "+(tempoF8-tempoI8));
    }
}


