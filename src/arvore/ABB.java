package arvore;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import entities.Veiculo;

public class ABB implements Map<Long,Veiculo>{
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

    
    @Override
    public int size() {
        return 0;
    }
    
    @Override
    public boolean containsKey(Object key) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public boolean containsValue(Object value) {
        // TODO Auto-generated method stub
        return false;
    }
    
    @Override
    public Veiculo get(Object key) {
        Noh node = this.raiz;
        return buscaRecMethod((int)key, node);
    }

    private Veiculo buscaRecMethod(int info, Noh node){
        if (node.valor.getChassi() == info) {
            return node.valor;
        }
        if (node.dir == null && node.esq == null) {
            return null;
        }
        if (info > node.valor.getChassi()) {
            return buscaRecMethod(info, node.dir);
        } else {
            return buscaRecMethod(info, node.esq);
        }
    }

    @Override
    public Veiculo put(Long key, Veiculo element) {
        if (isEmpty()){
            this.raiz = new Noh(element);
            return element;
        } else {
            Noh aux = this.raiz;
            while (aux != null) {
                if (key < aux.valor.getChassi()) {
                    if (aux.esq == null) {
                        Noh newNode = new Noh(element);
                        aux.esq = newNode;
                        newNode.pai = aux;
                        return element;
                    }
                    aux = aux.esq;
                } else {
                    if (aux.dir == null) {
                        Noh newNode = new Noh(element);
                        aux.dir = newNode;
                        newNode.pai = aux;
                        return element;
                    }
                    aux = aux.dir;
                }
            }
            return null;
        }
    }

    @Override
    public Veiculo remove(Object key) {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public void putAll(Map<? extends Long, ? extends Veiculo> m) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void clear() {
        // TODO Auto-generated method stub
        
    }

    @Override
    public Set<Long> keySet() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Collection<Veiculo> values() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Set<Entry<Long, Veiculo>> entrySet() {
        
        return null;
    }
}