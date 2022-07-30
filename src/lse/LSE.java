package lse;

import entities.Veiculo;

public class LSE implements ILista {
    private Noh inicio;
    private int size;

    public LSE() {
        this.inicio = null;
    }

    @Override
    public void insereInicio(Veiculo valor) {
        Noh novo = new Noh(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            novo.setProximo(inicio);
            inicio = novo;
        }
        size++;
    }

    @Override
    public void insereFim(Veiculo valor) {
        Noh novo = new Noh(valor);
        if (inicio == null) {
            inicio = novo;
        } else {
            Noh ultimo = null;
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                ultimo = i;
            }
            ultimo.setProximo(novo);
            size++;
        }
    }

    @Override
    public boolean estahVazia() {
        return this.inicio == null;
    }

    @Override
    public boolean remove(Veiculo valor) {
        Noh ant = null, p;
        p = inicio;
        while (p != null && p.getValor() != valor) {
            ant = p;
            p = p.getProximo();
        }
        if (p == null) {
            return false;
        }
        if (ant == null) {
            inicio = p.getProximo();
        } else {
            ant.setProximo(p.getProximo());
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
            for (Noh i = inicio; i != null; i = i.getProximo()) {
                stringBuilder.append(i.getValor()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    // Getters e setters

    public Noh getInicio() {
        return inicio;
    }

    public void setInicio(Noh inicio) {
        this.inicio = inicio;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
