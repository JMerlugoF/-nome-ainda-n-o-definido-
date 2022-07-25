package lse;

import entities.Veiculo;

public class Noh {
    private Veiculo valor;
    private Noh proximo;

    public Noh(Veiculo valor) {
        this.valor = valor;
        this.proximo = null;
    }

    public Veiculo getValor() {
        return valor;
    }

    public void setValor(Veiculo valor) {
        this.valor = valor;
    }

    public Noh getProximo() {
        return proximo;
    }

    public void setProximo(Noh proximo) {
        this.proximo = proximo;
    }
}
