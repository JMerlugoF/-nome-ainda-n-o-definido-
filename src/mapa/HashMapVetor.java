package mapa;

import entities.Veiculo;

public class HashMapVetor {
    private Veiculo[] vetor;
    private int size;

    public static final int CAPACIDADE_DEFAULT = 20;

    public static final double FATOR_DE_CARGA_DEFAULT = 0.75;

    public HashMapVetor() {
        this.vetor = new Veiculo[CAPACIDADE_DEFAULT];
        this.size = 0;
    }

    public HashMapVetor(int size) {
        this.vetor = new Veiculo[size];
        this.size = 0;
    }

    private int hash(int chave) {
        return chave % this.vetor.length;
    }

    public void put(int chave, Veiculo valor) {
        int sondagem = 0;
        int hash;
        resize();
        while (sondagem < vetor.length) {
            hash = (hash(chave) + sondagem) % vetor.length;
            if (vetor[hash] == null || vetor[hash].getChassi() == chave) {
                vetor[hash] = valor;
                this.size++;
                return;
            }
            sondagem++;
        }
    }
/*
    private void resize(int novaCapacidade) {
        Veiculo[] novoVetor = new Veiculo[novaCapacidade];
        for (int i = 0; i < this.vetor.length; i++)
            novoVetor[i] = this.vetor[i];
        this.vetor = novoVetor;
    }

*/
    public Veiculo get(int chave) {
        int sondagem = 0;
        int hash;
        while (sondagem < vetor.length) {
            hash = (hash(chave) + sondagem) % vetor.length;
            while (vetor[hash] == null) {
                hash = (hash(chave) + sondagem) % vetor.length;
                sondagem++;
                if (sondagem == vetor.length) {
                    sondagem = 0;
                }
            }
            if (vetor[hash].getChassi() == chave) {
                return vetor[hash];
            }
            sondagem++;
            if (hash == 0) {
                sondagem--;
            }
        }
        return null;
    }


    public Veiculo remove(int chave) {
        int sondagem = 0;
        int hash;
        while (sondagem < vetor.length) {
            hash = (hash(chave) + sondagem) % vetor.length;

            if (vetor[hash] != null && vetor[hash].getChassi() == chave) {
                Veiculo v = vetor[hash];
                vetor[hash] = null;
                this.size--;
                return v;
            }
            sondagem++;
        }
        return null;
    }

    private boolean isFull() {
        return size == vetor.length;
    }

    private boolean isEmpty() {
        return vetor.length == 0;
    }

    public int size() {
        return this.size;
    }

    private void fill(Veiculo[] aux) {
        for (int i = 0; i < aux.length; i++) {
            aux[i] = null;
        }
    }

    private void resize() {
        if (this.size/vetor.length>FATOR_DE_CARGA_DEFAULT) {
            Veiculo[] novoVetor = new Veiculo[this.vetor.length * 2];
            this.size = 0;

            for (int i = 0; i < vetor.length; i++) {
                novoVetor[i] = vetor[i];
            }
            fill(vetor);
            rehash(novoVetor);
            this.vetor = novoVetor;
        }
    }

    private void rehash(Veiculo[] rehash) {
        for (int i = 0; i < rehash.length; i++) {
            if (rehash[i] != null) {
                Veiculo v = rehash[i];
                put(v.getChassi(), v);
            }
        }
    }

    public String print() {
        //sort();
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                builder.append(vetor[i]).append("\n ");
            }
        }
        return builder.toString();
    }

    public void sort() {

        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                int index_menor = i;
                for (int j = i + 1; j < vetor.length; j++)
                    if (vetor[j] != null)
                        if (vetor[j].getChassi() < vetor[index_menor].getChassi())
                            index_menor = j;

                Veiculo aux = vetor[i];
                vetor[i] = vetor[index_menor];
                vetor[index_menor] = aux;
            }
        }
    }

    public int verificaFord(){
        int cont = 0;
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                if (vetor[i].isMarcaFord()) {
                    cont++;
                }
            }
        }
        return cont;
    }

    public void removeMenorIgual(){
        for (int i = 0; i < vetor.length; i++){
            if (vetor[i] != null) {
                if (vetor[i].getChassi() <= 202050000) {
                    remove(vetor[i].getChassi());
                }
            }
        }
    }

}

