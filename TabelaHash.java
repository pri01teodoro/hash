
public class TabelaHash{
    String chave;
    int valor;
    TabelaHash[] tabela; //array que recebe os valores


    public TabelaHash(String chave, int valor) {
        this.chave = chave;
        this.valor = valor;
    }    

    public TabelaHash(int capacidade){
        tabela = new TabelaHash[capacidade];
    }

    public void put(String chave, int valor){
        //int hash = Math.abs(chave.hashCode());
        int indice = chave.length()%tabela.length;

        // Encontrar a chave ou o próximo vazio
        TabelaHash entrada = tabela[indice];
        while (entrada != null) {
            if (entrada.chave.equals(chave)) {
                break;
            }
            indice++;
            entrada = tabela[indice];
        }

        tabela[indice] = new TabelaHash(chave, valor);

    }

    public TabelaHash remove(String chave){
        TabelaHash temp;
        int hash = Math.abs(chave.hashCode()); 

        temp = tabela[hash];
        tabela[hash] = null;
        
        return temp;
    }

    public void clear(){
       tabela = null;
       valor = 0;
       chave = null;
    }    

    public void print(){
        for (int i = 0; i < tabela.length; i++) {
            TabelaHash entrada = tabela[i];
            System.out.println(i+": "+(entrada == null ? "null" : entrada.chave+" --> "+entrada.valor));
        }
    }

    public int size(){
       return tabela.length;
    }

    public boolean isEmpty(){
        if (tabela.length == 0) {
            return true;
        }else{
            return false;
        }
    }
}

