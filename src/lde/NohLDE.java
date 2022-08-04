package lde;

import entities.Veiculo;

public class NohLDE {
    private Veiculo valor;
    private NohLDE ant;
    private NohLDE prox;

    public NohLDE(Veiculo valor) {
        this.valor = valor;
        this.ant = null;
        this.prox = null;
    }

    public Veiculo getValor() {
        return valor;
    }

    public void setValor(Veiculo valor) {
        this.valor = valor;
    }

    public NohLDE getAnt() {
        return ant;
    }

    public void setAnt(NohLDE ant) {
        this.ant = ant;
    }

    public NohLDE getProx() {
        return prox;
    }

    public void setProx(NohLDE prox) {
        this.prox = prox;
    }
}