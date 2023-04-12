package org.example;

import javax.swing.*;
import java.util.Scanner;

public class JogoDaVelha {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Campo [][] jogo = new Campo [3][3];
        char simbolo = 'X';
        boolean game = true;
        char vitoria = ' ';

        iniciaJogo(jogo);
        while (game){
            desenhaJogo(jogo);
            vitoria = verifiqueVitoria(jogo);
            if (vitoria != (' ')){
                System.out.printf("%nVitória do jogador %s! %n", vitoria);
                break;
            }

            try{
                if(verificaJogada(jogo, jogar(entrada, simbolo), simbolo)){
                    if (simbolo == 'X'){
                        simbolo = 'O';
                    } else {
                        simbolo = 'X';
                    }
                }

            } catch (Exception e){
                System.out.println("Erro no processamento");
            }
        }
        System.out.println("Fim do jogo!");
        entrada.close();
    }

    public static void desenhaJogo(Campo[][] jogo){
        limparTela();
        System.out.println("   0   1   2");
        System.out.printf("0  %c | %c | %c %n", jogo[0][0].getSimbolo(), jogo[0][1].getSimbolo(), jogo[0][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("1  %c | %c | %c %n", jogo[1][0].getSimbolo(), jogo[1][1].getSimbolo(), jogo[1][2].getSimbolo());
        System.out.println("  ------------");
        System.out.printf("2  %c | %c | %c %n", jogo[2][0].getSimbolo(), jogo[2][1].getSimbolo(), jogo[2][2].getSimbolo());
    }

    public static char verifiqueVitoria(Campo[][] jogo){
        char vencedor = ' ';

        if (jogo[0][1].getSimbolo() == jogo[0][0].getSimbolo() && jogo[0][1].getSimbolo() == jogo[0][2].getSimbolo() && jogo[0][1].getSimbolo() != ' '){
            vencedor = jogo[0][1].getSimbolo();
        } else if(jogo[1][0].getSimbolo() == jogo[0][0].getSimbolo() && jogo[1][0].getSimbolo() == jogo[2][0].getSimbolo() && jogo[1][0].getSimbolo() != ' '){
            vencedor = jogo[1][0].getSimbolo();
        } else if(jogo[1][2].getSimbolo() == jogo[0][2].getSimbolo() && jogo[1][2].getSimbolo() == jogo[2][2].getSimbolo() && jogo[1][2].getSimbolo() != ' '){
            vencedor = jogo[1][2].getSimbolo();
        } else if(jogo[2][1].getSimbolo() == jogo[2][2].getSimbolo() && jogo[2][1].getSimbolo() == jogo[2][0].getSimbolo() && jogo[2][1].getSimbolo() != ' '){
            vencedor = jogo[2][1].getSimbolo();
        } else if(jogo[1][1].getSimbolo() == jogo[0][1].getSimbolo() && jogo[1][1].getSimbolo() == jogo[2][1].getSimbolo() && jogo[1][1].getSimbolo() != ' '){
            vencedor = jogo[1][1].getSimbolo();
        } else if(jogo[1][1].getSimbolo() == jogo[1][0].getSimbolo() && jogo[1][1].getSimbolo() == jogo[1][2].getSimbolo() && jogo[1][1].getSimbolo() != ' '){
            vencedor = jogo[1][1].getSimbolo();
        } else if(jogo[1][1].getSimbolo() == jogo[0][0].getSimbolo() && jogo[1][1].getSimbolo() == jogo[2][2].getSimbolo() && jogo[1][1].getSimbolo() != ' '){
            vencedor = jogo[1][1].getSimbolo();
        } else if(jogo[1][1].getSimbolo() == jogo[0][2].getSimbolo() && jogo[1][1].getSimbolo() == jogo[2][0].getSimbolo() && jogo[1][1].getSimbolo() != ' '){
            vencedor = jogo[1][1].getSimbolo();
        }

        return vencedor;
    }

    public static void limparTela(){
        for (int i = 0; i < 200; i++){
            System.out.println("");
        }
    }

    public static boolean verificaJogada(Campo [][] jogo, int coordenada[], char simbolo){
        char simboloDapPosicao = jogo[coordenada[0]][coordenada[1]].getSimbolo();
        if(simboloDapPosicao == ' ') {
            jogo[coordenada[0]][coordenada[1]].setSimbolo(simbolo);
            return true;
        } else {
            JOptionPane.showMessageDialog(null, "Esse campo já foi preenchido!", "Aviso", JOptionPane.WARNING_MESSAGE);
            return false;
        }
    }

    public static int[] jogar (Scanner entrada, char simbolo){
        int coordenada[] = new int[2];
        System.out.printf("%s %c%n", "Quem joga: ", simbolo);
        System.out.println("Informe a linha: ");
        coordenada[0] = entrada.nextInt();
        System.out.println("Informe a coluna: ");
        coordenada[1] = entrada.nextInt();

        return coordenada;
    }

    public static void iniciaJogo(Campo [][] jogo){
        for (int i = 0; i < 3; i++){
            for (int j = 0; j < 3; j++){
                jogo[i][j] = new Campo();
            }
        }
    }
}