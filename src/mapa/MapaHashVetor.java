package mapa;
import entities.Veiculo;

public class MapaHashVetor {
    private Veiculo[] vetor;
    private int size;

    public MapaHashVetor(int size) {
        this.vetor = new Veiculo[size];
        this.size = 0;
    }

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
        if (isFull()) {
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
                Veiculo obj = rehash[i];
                put(obj.getChassi(), obj);
            }
        }
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
}