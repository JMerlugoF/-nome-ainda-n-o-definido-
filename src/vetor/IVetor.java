package vetor;

import entities.Veiculo;

public interface IVetor {
    public void adiciona(Veiculo v);

    public int tamanho();

    //public boolean contem(Veiculo v);

    public boolean cheio();

    public boolean remove(Veiculo v);

    public void garanteEspaco();
    public String print();

    public static Veiculo[] selectionSort(Veiculo[] v){
        return v;
    }
}
