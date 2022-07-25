package lse;

import entities.Veiculo;

public interface ILista {
    public void insereInicio(Veiculo valor);

    public void insereFim(Veiculo valor);

    public boolean estahVazia();

    public boolean remove(Veiculo valor);

    public int size();

    public String imprime();
}