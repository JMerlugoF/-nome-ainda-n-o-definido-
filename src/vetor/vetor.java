package vetor;

import entities.Veiculo;

public class vetor {
    private Veiculo[] vetor = new Veiculo[100000];
    private int size = 0;


    private void resize(int novaCapacidade) {
        Veiculo[] novaLista = new Veiculo[novaCapacidade];
        for (int i = 0; i < this.vetor.length; i++)
            novaLista[i] = this.vetor[i];
        this.vetor = novaLista;
    }

    public void adiciona(Veiculo v) {
        this.garanteEspaco();
        if (!this.cheio()) {
            this.vetor[this.size] = v;
            this.size++;
        } else {
            System.out.print("Vetor cheio!");
        }
    }

    public boolean cheio() {
        if (size == this.vetor.length)
            return true;
        return false;
    }

    public void garanteEspaco() {
        if (this.cheio()) {
            Veiculo[] novoElementos = new Veiculo[this.vetor.length * 2];
            for (int i = 0; i < this.vetor.length; i++)
                novoElementos[i] = this.vetor[i];
            this.vetor = novoElementos;
        }
    }

    public boolean remove(Veiculo v) {
        int indice = -1;
        for (int i = 0; i < size; i++) //faz a busca
            if (v.equals(this.vetor[i])) {
                indice = i;
                break;
            }
        if (indice != -1) { //achou o elemento
            for (int i = indice; i < (size - 1); i++)
                vetor[i] = vetor[i + 1];
            size--;
            return true;
        }
        return false;
    }

    public int tamanho() {
        return this.size;
    }

    public String print() {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                builder.append(vetor[i]).append("\n ");
            }
        }
        return builder.toString();
    }

    public static void sort(Veiculo[] v) {

        for (int i = 0; i < v.length; i++) {
            int index_menor = i;
            for (int j = i + 1; j < v.length; j++)
                if (v[j].getChassi() < v[index_menor].getChassi())
                    index_menor = j;

            Veiculo aux = v[i];
            v[i] = v[index_menor];
            v[index_menor] = aux;
        }
    }
}

