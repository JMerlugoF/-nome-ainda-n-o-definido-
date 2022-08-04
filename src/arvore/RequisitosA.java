package arvore;
import entities.Veiculo;

public class RequisitosA {

    public static void Adicionar100mil(Veiculo[] veiculos, ABB arvore){
        while(arvore.size() < 99999){
            veiculos[arvore.size()] = new Veiculo();
            arvore.put((long)veiculos[arvore.size()].getChassi(), veiculos[arvore.size()]);
        }
    }

    public static void ImprimirCrescente(ABB arvore) {
        arvore.imprimeArvoreOrdenadaRec();;
    }

    public static void CarrosDaFord(ABB arvore){
        int count = 0;
        int c = 0;
        Noh j = null;
        while(j == null){
            j = arvore.get((long)202000000+c);
            c++;
        }
        for (int i = 202000000+c; i < (202000000+c)+10000; i++) {
            try {
                if(arvore.get((long)i).valor.isMarcaFord()){
                    count++;
                }
            } catch (NullPointerException e) {}
        }
        System.out.println(count);
    }

    public static void RemoverVeiculos(ABB arvore){
        for (int i = 202050000; i >= 202000000; i--) {
            try {
                if(arvore.get((long)i) != null)
                    arvore.remove((long)i);
            } catch (NullPointerException e) {}
        }
    }
}