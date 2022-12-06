
// Implementação Inicial de Tabela Hash em Java
// A solução escolhida para a situação de colisão é a de procurar
// o próximo espaço vazio. Não se utiliza listas encadeadas
public class TabelaHash {
	
	// Classe representando uma única entrada de par
	// chave-valor
    public static class TabelaEntrada {
		// Identificador único
        String chave;
		// Valor
        int valor;

		// Construtor, permite chamar 'new TabelaEntrada("AA",123)'
        public TabelaEntrada(String chave, int valor) {
            this.chave = chave;
            this.valor = valor;
        }
    }

	// Array contendo as entradas da tabela
    public TabelaEntrada[] tabela;
	
	// Criar nova TabelaHash com a capacidade especificada
    public TabelaHash(int capacidade)
    {
        tabela = new TabelaEntrada[capacidade];
    }

	// Método que insere ou substitui o valor na chave especificada
    public void put(String chave, int valor)
    {
		// Calcula o índice na tabela a partir do hash da chave
        int hash = Math.abs(chave.hashCode());
        int indice = hash % tabela.length;

        // Encontrar a chave ou o próximo vazio
        TabelaEntrada entrada = tabela[indice];
        while(entrada != null) { 
            if(entrada.chave.equals(chave))
                break;
            
            indice++;
            entrada = tabela[indice];
        }
		
		// Só chega aqui se estiver na posição da chave existente
		// ou se não encontrou a chave e está em um vazio
        tabela[indice] = new TabelaEntrada(chave,valor);
    }

    public TabelaEntrada remove(String chave){
        int hash = Math.abs(chave.hashCode());
        int indice = hash % tabela.length;
        
        TabelaEntrada entrada = tabela[indice];
        TabelaEntrada temp = entrada;
        while (entrada != null) {
            if (entrada.chave.equals(chave)) {
                break;
            }

            entrada = tabela[indice];
            temp = entrada;
        } 

        tabela[indice] = null;
        return temp;
            
    }

    public int size(){
        int tamanho = 0;
        for (TabelaEntrada tabelaEntrada : tabela) {
            if (tabelaEntrada != null) {
                tamanho++;
            }
            
        }
        return tamanho;
     }
 
    public boolean isEmpty(){
       return this.size() == 0;
     }

    public void clear(){
       for (int i = 0; i < tabela.length; i++) {
            tabela[i] = null;
       }
       
    } 

	// Função que escreve na tela como está a tabela para testar e ver
	// detalhadamente o que está acontecendo.
    public void print()
    {
        for(int i=0;i<tabela.length;i++)
        {
            TabelaEntrada entrada = tabela[i];
            
            System.out.println(i+": "+(entrada == null ? "null" : entrada.chave+" --> "+entrada.valor));
        }
    }
}