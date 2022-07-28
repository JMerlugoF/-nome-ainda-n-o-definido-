package mapa;
import entities.Veiculo;
import lde.LDEMap;
import lde.NohLDE;

public class mapaHashLDE {
    private LDEMap[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    public mapaHashLDE() {
        this.tabela = new LDEMap[CAPACIDADE_DEFAULT];
    }

    public mapaHashLDE(long capacidade) {
        this.tabela = new LDEMap[(int) capacidade];
    }

    private int hash(int chave) {
        return chave % this.tabela.length;
    }

    private int hashMultiplicacao(Integer chave) {
        double a = 0.617648934;
        double hash = chave * a;
        hash = (hash % 1) * this.tabela.length;
        return (int) hash;
    }

    public void put(int chave, Veiculo valor) {
        int hash = hash(chave);
        LDEMap veiculos = this.tabela[hash];

        if (veiculos == null) {
            veiculos = new LDEMap();
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
        LDEMap veiculos = this.tabela[hash];

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
        LDEMap veiculos = this.tabela[hash];

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

    public String print(){
        final StringBuilder sb = new StringBuilder();
        for (int i = 0; i<tabela.length; i++){
            if (tabela[i] != null){
                sb.append(tabela[i].imprime());
            }
        }
        return sb.toString();
    }
}


