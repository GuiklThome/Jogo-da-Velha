package JogoDavelha;

public class JogoDaVelha {

    private String tabuleiro[][];

    public JogoDaVelha(int tamanho) {
        this.tabuleiro = new String[tamanho][tamanho];
    }

    public String toString() {
        for (int i = 0; i < tabuleiro.length; i++) { 
            for (int j = 0; j < tabuleiro.length; j++) {
                System.out.print(tabuleiro[i][j] == null ? "[ ]" : "[" + tabuleiro[i][j] + "]");
            }
            System.out.println();
        }
		return null; 
    }
    
    public boolean MarcarJogadas(int linha, int coluna, String marca) {
        if (!marca.equalsIgnoreCase("O") && !marca.equalsIgnoreCase("X")) {   
            return false; 
        }
        
        if (this.tabuleiro[linha][coluna] == null) { 
            this.tabuleiro[linha][coluna] = marca; 
            return true;  
        } 
        return false;  
    } 
    
    public void Reiniciar() {
    	for (int i = 0; i < tabuleiro.length; i++) { 
    		for (int j = 0; j < tabuleiro.length; j++) {
    			tabuleiro[i][j] = null ; 
    		}}
    	
    } 
    
  
    public boolean verificarGanhador() {
        String aux = String.format("%0" + this.tabuleiro.length +"d", 0);
        String resultado1 = aux.replace("0", "O");
        String resultado2 = aux.replace("0", "X");      
        String linha = "";
        String coluna = ""; 
        String diagonal = ""; 
        String diagonalSecundaria = "";
        int indexOposto = this.tabuleiro.length - 1; 

        for (int i = 0; i < this.tabuleiro.length; i++) {
            for (int j = 0; j < this.tabuleiro.length; j++) { 
                linha += this.tabuleiro[i][j] != null ? this.tabuleiro[i][j] : "";
                coluna += this.tabuleiro[j][i] != null ? this.tabuleiro[j][i] : "";

                if (j == i) {
                    diagonal += this.tabuleiro[i][j] != null ? this.tabuleiro[i][j] : ""; 
                    diagonalSecundaria += this.tabuleiro[i][indexOposto] != null ? this.tabuleiro[i][indexOposto--] : ""; 
                }
            }

            //VERIFICA LINHA
            if (linha.equalsIgnoreCase(resultado1) || linha.equalsIgnoreCase(resultado2)) { 
                return true;
            }

            //VERIFICA COLUNA
            if (coluna.equalsIgnoreCase(resultado1) || coluna.equalsIgnoreCase(resultado2)) {
                return true;
            }

            linha = "";
            coluna = ""; 
        }

        //VERIFICA DIAGONAL
        if (diagonal.equalsIgnoreCase(resultado1) || diagonal.equalsIgnoreCase(resultado2)) {
            return true;
        }

        //VERIFICA DIAGONAL SECUNDARIA
        if (diagonalSecundaria.equalsIgnoreCase(resultado1) || diagonalSecundaria.equalsIgnoreCase(resultado2)) {
            return true;
        } 

        return false;
    }
    


}
	
	
		
	

 

		 
		
		
		
	
	


