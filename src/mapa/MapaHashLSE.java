package mapa;

import entities.Veiculo;
import lse.LSE;
import lse.Noh;


public class MapaHashLSE {
    private LSE[] tabela;
    private final int CAPACIDADE_DEFAULT = 20;

    public MapaHashLSE() {
        this.tabela = new LSE[CAPACIDADE_DEFAULT];
    }

    public MapaHashLSE(long capacidade) {
        this.tabela = new LSE[(int) capacidade];
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
        LSE veiculos = this.tabela[hash];

        if (veiculos == null) {
            veiculos = new LSE();
            veiculos.insereInicio(valor);
            this.tabela[hash] = veiculos;

        } else {
            for (Noh n = veiculos.getInicio(); n != null; n = n.getProximo()) {
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
        LSE veiculos = this.tabela[hash];

        if (veiculos == null || veiculos.estahVazia())
            return null;

        for (Noh n = veiculos.getInicio(); n != null; n = n.getProximo()) {
            if (n.getValor().getChassi() == chave)
                return n.getValor();
        }
        return null;
    }

    public Veiculo remove(int chave) {
        int hash = hash(chave);
        LSE veiculos = this.tabela[hash];

        while (!veiculos.estahVazia()) {
            for (Noh n = veiculos.getInicio(); n != null; n = n.getProximo()) {
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
