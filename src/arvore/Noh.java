package arvore;

import entities.Veiculo;

public class Noh {
    Veiculo valor;
    Noh esq;
    Noh dir;
    Noh pai;

    Noh(Veiculo v) {
        this.valor = v;
    }

    public boolean ehFolha() {
        return this.esq == null && this.dir == null;
    }

    public boolean filhosSoNaDireita() {
        return (this.esq == null && this.dir != null);
    }
    
    public boolean filhosSoNaEsquerda() {
        return (this.esq != null && this.dir == null);
    }

}