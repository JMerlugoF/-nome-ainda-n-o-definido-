package mapa;
import entities.Veiculo;
import lde.LDE;
import lde.NohLDE;

public class HashMapLDE {
    private LDE[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;
    private int size;

    public HashMapLDE() {
        this.tabela = new LDE[CAPACIDADE_DEFAULT];
        this.size = 0;
    }

    public HashMapLDE(long capacidade) {
        this.tabela = new LDE[(int) capacidade];
        this.size = 0;
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    private int hashMultiplicacao(int chave) {
        double a = 0.617648934;
        double hash = chave * a;
        hash = (hash % 1) * this.tabela.length;
        return (int) hash;
    }

    public void put(int chave, Veiculo valor) {
        int hash = hash(chave);
        LDE veiculos = this.tabela[hash];
        this.size++;
        if (veiculos == null) {
            veiculos = new LDE();
            veiculos.insereInicio(valor);
            this.tabela[hash] = veiculos;

        } else {
            for (NohLDE n = veiculos.getInicio(); n != null; n = n.getProx()) {
                if (n.getValor().getChassi() == chave) {
                    n.setValor(valor);
                    return;
                }
            }
            veiculos.insereInicio(valor);
        }
    }

    public Veiculo get(int chave) {
        int hash = hash(chave);
        LDE veiculos = this.tabela[hash];

        if (veiculos == null || veiculos.estahVazia())
            return null;

        for (NohLDE n = veiculos.getInicio(); n != null; n = n.getProx()) {
            if (n.getValor().getChassi() == chave)
                return n.getValor();
        }
        return null;
    }

    public Veiculo remove(int chave) {
        int hash = hash(chave);
        LDE veiculos = this.tabela[hash];

        while (!veiculos.estahVazia()) {
            for (NohLDE n = veiculos.getInicio(); n != null; n = n.getProx()) {
                if (n.getValor().getChassi() == chave) {
                    n.setValor(null);
                    return n.getValor();
                }
            }
        }
        return null;
    }

    public String print() {
        final StringBuilder sb = new StringBuilder();
        sort();
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] == null) {
                sb.append(i).append(" Null").append("\n");
            }else {
                sb.append(i).append(" ").append(tabela[i].imprime()).append("\n");
            }
        }
        return sb.toString();
    }

    public void sort() {
       for (int i = 0; i<tabela.length; i++){
           if (tabela[i] != null) {
               tabela[i].sort();
               break;
           }
       }
    }
    
   public void removeMenorIgualLDE(){
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                tabela[i].removeMenorIgual();
            }
        }
    }

    public int verificaFordLDE(){
        int cont = 0;
        for (int i = 0; i < tabela.length; i++) {
            if (tabela[i] != null) {
                cont += tabela[i].verificaFord();
            }
        }
        return cont;
    }



    // Getters
    public int getSize() {
        return size;
    }

    public LDE[] getTabela() {
        return tabela;
    }

    public int getCAPACIDADE_DEFAULT() {
        return CAPACIDADE_DEFAULT;
    }
}



