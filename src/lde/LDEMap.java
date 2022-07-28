package lde;

import entities.Veiculo;
import lse.Noh;

public class LDEMap implements ILDE {
    private Veiculo valor;
    private NohLDE inicio;
    private NohLDE fim;
    private int size;

    public LDEMap() {
        this.inicio = null;
        this.fim = null;
    }

    @Override
    public void insereInicio(Veiculo valor) {
        NohLDE novo = new NohLDE(valor);
        if (inicio == null) {
            inicio = novo;
            fim = novo;
        } else {
            novo.setProx(inicio);
            inicio.setAnt(novo);
            inicio = novo;
            inicio.setAnt(novo);
        }
        size++;
    }

    @Override
    public void insereFim(Veiculo valor) {
        NohLDE novo = new NohLDE(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setAnt(fim);
            fim.setProx(novo);
            fim = novo;
        }
        size++;
    }

    @Override
    public boolean estahVazia() {
        return this.inicio == null;
    }

    @Override
    public boolean remove(Veiculo valor) {
        NohLDE ant = null, p;
        p = inicio;
        while (p != null && p.getValor() != valor) {
            ant = p;
            p = p.getProx();
        }
        if (p == null) {
            return false;
        }
        if (ant == null) {
            inicio = p.getProx();
        } else {
            ant.setProx(p.getProx());
        }
        size--;
        return true;
    }

    @Override
    public int size() {
        return size;
    }

    public String imprime() {
        final StringBuilder stringBuilder = new StringBuilder();
        if (!estahVazia()) {
            for (NohLDE i = inicio; i != null; i = i.getProx()) {
                stringBuilder.append(i.getValor()).append("\n");
            }
        }
        return stringBuilder.toString();
    }
    public NohLDE getInicio() {
        return inicio;
    }

    public void setInicio(NohLDE inicio) {
        this.inicio = inicio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
