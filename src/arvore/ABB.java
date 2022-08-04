package arvore;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

import entities.Veiculo;

public class ABB implements Map<Long, Object> {
    private Noh raiz;
    private int nElements;

    public ABB() {
        this.nElements = 0;
    }

    public boolean isEmpty() {
        return this.raiz == null;
    }

    public void imprimeArvoreOrdenadaRec() {
        Noh node = this.raiz;
        RecImprimeArvoreOrdenada(node);
    }

    private void RecImprimeArvoreOrdenada(Noh node) {
        if (node != null) {
            if (node.esq != null)
                RecImprimeArvoreOrdenada(node.esq);
            System.out.println(node.valor.toString());
            if (node.dir != null)
                RecImprimeArvoreOrdenada(node.dir);
        }
    }

    @Override
    public int size() {
        return this.nElements;
    }

    @Override
    public boolean containsKey(Object key) {
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        return false;
    }

    @Override
    public Noh get(Object key) throws NullPointerException {
        Noh node = this.raiz;
        return buscaRecMethod((long) key, node);
    }

    private Noh buscaRecMethod(Long info, Noh node) {
        if (node == null) {
            return null;
        }
        if (node.valor.getChassi() == info) {
            return node;
        }
        if (info > node.valor.getChassi()) {
            return buscaRecMethod(info, node.dir);
        } else {
            return buscaRecMethod(info, node.esq);
        }
    }

    @Override
    public Object put(Long i, Object element) {
        Veiculo info = (Veiculo) element;
        if (get(i) != null)
            return null;
        if (isEmpty()) {
            this.raiz = new Noh(info);
            nElements++;
            return info;
        } else {
            Noh aux = this.raiz;
            while (aux != null) {
                if (i < aux.valor.getChassi()) {
                    if (aux.esq == null) {
                        Noh newNode = new Noh(info);
                        aux.esq = newNode;
                        newNode.pai = aux;
                        nElements++;
                        return info;
                    }
                    aux = aux.esq;
                } else {
                    if (aux.dir == null) {
                        Noh newNode = new Noh(info);
                        aux.dir = newNode;
                        newNode.pai = aux;
                        nElements++;
                        return info;
                    }
                    aux = aux.dir;
                }
            }
            return null;
        }
    }

    @Override
    public Object remove(Object key) {
        Noh node = this.raiz;
        return removeElement((Long) key, buscaRecMethod((long) key, node));
    }

    private Object removeElement(Long key, Noh element) {
        if (element.ehFolha()) {
            if (element == this.raiz) {
                this.raiz = null;
                nElements--;
                return element;
            } else {
                if (key < element.pai.valor.getChassi())
                    element.pai.esq = null;
                else
                    element.pai.dir = null;
                nElements--;
                return element;
            }
        } else if (element.filhosSoNaEsquerda()) {
            if (element == this.raiz) {
                this.raiz = element.esq;
                this.raiz.pai = null;
                nElements--;
                return element;
            } else {
                element.esq.pai = element.pai;
                if (element.valor.getChassi() < element.pai.valor.getChassi())
                    element.pai.esq = element.esq;
                else
                    element.pai.dir = element.esq;
                nElements--;
                return element;
            }
        } else if (element.filhosSoNaDireita()) {
            if (element == this.raiz) {
                this.raiz = element.dir;
                this.raiz.pai = null;
                nElements--;
                return element;
            } else {
                element.dir.pai = element.pai;
                if (element.valor.getChassi() < element.pai.valor.getChassi())
                    element.pai.esq = element.dir;
                else
                    element.pai.dir = element.dir;
                nElements--;
                return element;
            }
        } else {
            if (element != null) {
                Noh sucessor = sucessor(element);
                element.valor = sucessor.valor;
                return removeElement((long) sucessor.valor.getChassi(), sucessor);
            }
        }
        return element;
    }

    public Noh sucessor(Noh element) {
        if (element.dir != null)
            return maxEsq(element.dir);
        else {
            Noh aux = element.pai;

            while (aux != null && aux.valor.getChassi() < element.valor.getChassi())
                aux = aux.pai;

            return aux;
        }
    }

    private Noh maxEsq(Noh noh) {
        if (noh.esq == null) return noh;
        else return maxEsq(noh.esq);
    }

    @Override
    public void putAll(Map<? extends Long, ? extends Object> m) {
    }

    @Override
    public void clear() {
    }

    @Override
    public Set<Long> keySet() {
        return null;
    }

    @Override
    public Collection<Object> values() {
        return null;
    }

    @Override
    public Set<Entry<Long, Object>> entrySet() {
        return null;
    }
}