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
}