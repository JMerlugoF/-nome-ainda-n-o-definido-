package arvore;

import org.w3c.dom.Node;

import entities.Veiculo;

public class ABB {
    private Noh raiz;

    public ABB() {
        
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void add(Veiculo element) {
        if (isEmpty())
            this.raiz = new Noh(element);
        else {
            Noh aux = this.raiz;
            while (aux != null) {
                if (element.getChassi() < aux.valor.getChassi()) {
                    if (aux.esq == null) {
                        Noh newNode = new Noh(element);
                        aux.esq = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.esq;
                } else {
                    if (aux.dir == null) {
                        Noh newNode = new Noh(element);
                        aux.dir = newNode;
                        newNode.pai = aux;
                        return;
                    }
                    aux = aux.dir;
                }
            }
        }
    }

    public void recursiveAdd(Veiculo element) {
        if (isEmpty())
            this.raiz = new Noh(element);
        else {
            recursiveAdd(this.raiz, element);
        }
    }

    private void recursiveAdd(Noh node, Veiculo element) {
        if (element.getChassi() < node.valor.getChassi()) {
            if (node.esq == null) {
                Noh newNode = new Noh(element);
                node.esq = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.esq, element);
        } else {
            if (node.dir == null) {
                Noh newNode = new Noh(element);
                node.dir = newNode;
                newNode.pai = node;
                return;
            }
            recursiveAdd(node.dir, element);
        }
    }

    public void imprimeArvoreOrdenadaRec(){
        Noh node = this.raiz;
        RecImprimeArvoreOrdenada(node);
    }

    public void RecImprimeArvoreOrdenada(Noh node){
        if(node != null){
            if(node.esq != null)
                RecImprimeArvoreOrdenada(node.esq);
                System.out.println(node.valor.toString());
            if(node.dir != null)
                RecImprimeArvoreOrdenada(node.dir);
        }
    }

    public boolean buscaRec(Veiculo info){
        Noh node = this.raiz;
        return buscaRecMethod(info, node);
    }

    private boolean buscaRecMethod(Veiculo info, Noh node){
        if (node.valor.getChassi() == info.getChassi()) {
            return true;
        }
        if (node.dir == null && node.esq == null) {
            return false;
        }
        if (info.getChassi() > node.valor.getChassi()) {
            return buscaRecMethod(info, node.dir);
        } else {
            return buscaRecMethod(info, node.esq);
        }
    }
}