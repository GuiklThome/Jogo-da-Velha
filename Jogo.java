package JogoDavelha;

import java.util.Scanner;

public class Jogo{
	public static void main(String[] args) {
		Scanner entrada = new Scanner (System.in) ;
		
		String x = "X";
		String o = "O";
		
		int controlador = 2;
		
		System.out.println("Nome do Primeiro Jogador ");
		String primeiro = entrada.nextLine(); 
		Jogador primeiroJogador = new Jogador(primeiro,0);
		
		
		System.out.println("Nome do Segundo jogador ");
		String segundo = entrada.nextLine();
		Jogador segundoJogador = new Jogador(segundo,0);
		
		System.out.println("Digite o tamnho do Tabuleiro");
		int tamanho = entrada.nextInt();
		JogoDaVelha tabuleiro = new JogoDaVelha(tamanho);
	
		boolean verificarJogo = tabuleiro.verificarGanhador();
		
		int linhas;
		int colunas; 
		int sair; 
		int lock = 0;
		
		do {
			do {
			tabuleiro.toString(); 
			System.out.println();
			
			if(controlador == 2) {
				System.out.println("Vez do jogador : " + primeiro  );
				System.out.println("Informe a linha: "); linhas = entrada.nextInt();  
				System.out.println("informe a coluna: "); colunas = entrada.nextInt();
				
				if( linhas >= 1) {
					linhas--;
				}
				if( colunas >= 1 ) {
					colunas--;
				}
			
				 if(tabuleiro.MarcarJogadas(linhas, colunas, x)){ 
					controlador = 1;
				}else {
					controlador = 2;
					System.out.println("Jogada Invalida! \nTente Novamente");
				}
				
			
				
							}else if(controlador == 1) {
								System.out.println("Vez do jogador : " + segundo  ); 
								System.out.println("Informe a linha: "); linhas = entrada.nextInt();   
								System.out.println("informe a coluna: "); colunas = entrada.nextInt(); 
							
								if(linhas >= 1) {
								linhas--;
								}
								if(colunas >= 1 ) {
								colunas--;
								}
										if(tabuleiro.MarcarJogadas(linhas, colunas, o)){ 
											controlador = 2;
												}else {
													controlador = 1;
													System.out.println("Jogada Invalida! \nTente Novamente");
												}
											}
							
							
			
			verificarJogo = tabuleiro.verificarGanhador(); 
			
			
			
		if((verificarJogo == true && controlador == 2)) { 
			System.out.println(""); 
			tabuleiro.toString();
			System.out.println("Você é o vencedor da rodada: " + segundo);
			segundoJogador.pontos++;
			System.out.println("Deseja continuar jogando (1 - Para Sim / 2 - Para Não) ?");
			lock = entrada.nextInt();
			tabuleiro.Reiniciar();
			
		}if((verificarJogo == true && controlador == 1)) {
			System.out.println("");
			tabuleiro.toString();
			System.out.println("Você é o vencedor da rodada: " + primeiro); 
			primeiroJogador.pontos++;
			System.out.println("Deseja continuar jogando (1 - Para Sim / 2 - Para Não) ?");
			lock = entrada.nextInt();
			tabuleiro.Reiniciar();
		}
		
		sair = lock;
		}while ((sair == 1 || sair == 1));  
		}while(verificarJogo == false);
		
		if(primeiroJogador.getPontos() > segundoJogador.getPontos()) { 
			System.out.println("");
			System.out.println("Voce é o vencedor!!!");
			primeiroJogador.ExibeJogador();
			
			
		}if(primeiroJogador.getPontos() < segundoJogador.getPontos()) {
			System.out.println("");
			System.out.println("Voce é o vencedor!!!");
			segundoJogador.ExibeJogador();
		}
		if(primeiroJogador == segundoJogador) {
			System.out.println("Empate");
		}
		entrada.close();
}
}