package lde;

import java.io.Serializable;
import entities.Veiculo;
import lse.Noh;

public class NohLDE implements Serializable{
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

        public NohLDE getProx() {
            return prox;
        }

        public void setProx(NohLDE prox) {
            this.prox = prox;
        }

        public NohLDE getAnt() {
            return ant;
        }

        public void setAnt(NohLDE ant) {
            this.ant = ant;
        }

}