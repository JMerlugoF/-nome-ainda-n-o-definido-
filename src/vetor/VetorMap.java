package vetor;

import entities.Veiculo;

public class VetorMap implements IVetor {
    private Veiculo[] vetor = new Veiculo[100000];
    private int size = 0;

    public static Veiculo[] selectionSort(Veiculo[] v) {
        for(int i = 0; i <v.length-1; i++)
        {
            int minIndex = v[i].getChassi();
            int pos = i;

            for(int j = i + 1; j < v.length-2; j++)
            {

                if(v[j].getChassi() > v[minIndex].getChassi()) {
                    minIndex = v[j].getChassi();
                    pos = j;
                }
            }
            int temp = v[pos].getChassi();
            v[pos] = v[i];
            int k = v[i].getChassi();
            k = temp;

        }
        return v;
    }

    public void adiciona(Veiculo v) {
        this.garanteEspaco();
        if (!this.cheio()) {
            this.vetor[this.size] = v;
            this.size++;
        } else {
            throw new ArrayIndexOutOfBoundsException("Vetor cheio!");
        }
    }

    public boolean cheio() {
        return size == this.vetor.length;
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
        final StringBuilder builder = new StringBuilder();
        for (int i = 0; i < vetor.length; i++) {
            if (vetor[i] != null) {
                builder.append(vetor[i]).append("\n ");
            }
        }
        return builder.toString();
    }
}

