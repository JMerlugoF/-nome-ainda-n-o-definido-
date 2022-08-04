package lde;

import entities.Veiculo;

public class LDE implements ILDE {
    private NohLDE inicio;
    private NohLDE fim;
    private int size;

    public LDE() {
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
        }
        size++;
    }

    @Override
    public void insereFim(Veiculo valor) {
        NohLDE novo = new NohLDE(valor);
        if (fim == null) {
            inicio = novo;
            fim = novo;
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
        NohLDE p = inicio;
        while (p != null && p.getValor() != valor) {
            p = p.getProx();
        }
        if (p == null) {
            return false;
        }
        if (p == inicio) {
            inicio = p.getProx();
            if (inicio != null) {
                inicio.setAnt(null);
            } else {
                fim = null;
            }
        } else if (p.getProx() == null) {
            p.getAnt().setProx(null);
            fim = p.getAnt();
        } else { // valor estah no meio
            p.getAnt().setProx(p.getProx());
            p.getProx().setAnt(p.getAnt());
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
                stringBuilder.append(i.getValor()).append(" | ");
            }
        }
        return stringBuilder.toString();
    }

    public void removeMenorIgual() {
        for (NohLDE i = inicio; i != null; i = i.getProx()) {
            if (i.getValor().getChassi() <= 202050000)
                remove(i.getValor());
        }
    }

    public int verificaFord() {
        int cont = 0;
        for (NohLDE i = inicio; i != null; i = i.getProx()) {
            if (i.getValor().isMarcaFord()) {
                cont++;
            }
        }
        return cont;
    }

    public void sort() {
        for (NohLDE i = inicio; i != null; i = i.getProx()) {
            if (i.getValor() != null) {
                NohLDE index_menor = i;
                for (NohLDE j = i.getProx(); j != null; j = j.getProx()) {
                    if (j.getValor() != null) {
                        if (j.getValor().getChassi() < index_menor.getValor().getChassi()) {
                            index_menor = j;
                        }
                    }
                }
                Veiculo aux = i.getValor();
                i.setValor(index_menor.getValor());
                index_menor.setValor(aux);
            }
        }
    }

    // Getters e setters

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
