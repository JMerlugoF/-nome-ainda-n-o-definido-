package lde;

import entities.Veiculo;

public class LDEMap implements ILDE {
    private NohLDE inicio;
    private NohLDE fim;
    private int size;

    public LDEMap() {
        this.inicio = null;
        this.fim = null;
    }

    public void bubbleSort() {
        NohLDE corrente, indice;
        Veiculo temp;
        if (inicio == null) {
            return;
        } else {
            for (corrente = inicio; corrente.getProx() != null; corrente = corrente.getProx()) {
                for (indice = corrente.getProx(); indice != null; indice = indice.getProx()) {
                    if (corrente.getValor().getChassi() > indice.getValor().getChassi()) {
                        temp = corrente.getValor();
                        corrente.setValor(indice.getValor());
                        indice.setValor(temp);
                    }
                }
            }
        }
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
        while (p != null && p.getValor() != valor) { //busca
            p = p.getProx();
        }
        if (p == null) { // não achou, então não faz nada e retorna false
            return false;
        }
        if (p == inicio) { // valor estah no inicio
            inicio = p.getProx();
            if (inicio != null) {
                inicio.setAnt(null);
            } else {
                fim = null;
            }
        } else if (p.getProx() == null) { // valor estah no fim
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
                stringBuilder.append(i.getValor()).append("\n");
            }
        }
        return stringBuilder.toString();
    }

    //  Getters e Setters

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
