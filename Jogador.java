package JogoDavelha;

import java.util.Scanner;

public class Jogador {
	
	String jogador;
	int pontos = 0;
	Scanner entrada = new Scanner (System.in) ;
	
	
	public Jogador(String jogador ,int pontos) {
		this.jogador = jogador;
		this.pontos = pontos;	
		}
		
	
	
	
	public String getJogador() {
		return jogador;
	}

	public void setJogador(String jogador) {
		this.jogador = jogador;
	}

	public int getPontos() {
		return pontos ;
	}

	public void setPontos(int pontos) {
		this.pontos = pontos;
	}

	public String ExibeJogador() {
		System.out.println("Nome: " + getJogador());
		System.out.println("Pontos: " + getPontos());
		return jogador; 
	}
	
	public int  AdicionarPontos() {
		return pontos + 1;
	}
	
	

}
