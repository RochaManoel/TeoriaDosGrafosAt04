package Engine;

import java.util.Scanner;

import Entities.Graph;
import auxiliaries.DataBase;
public class Engine {
    private Scanner sc = new Scanner(System.in);

    public Engine(){
        this.Menu();
    }
    private void Menu(){
        boolean control = true;
        while(control){
            System.out.println("DIGITE A OPÇÃO DESEJADA:\n[0] - Encerrar Programa\n[1] - Criar Grafo 01\n[2] - Criar Grafo 02\n[3] - Criar Grafo 03");
            int Option = sc.nextInt();
            switch (Option) {
                case 0:
                    System.out.println("Programa Encerrado com Sucesso!");
                    control = false;
                    break;
                case 1:
                    optionsCase("grafo01.txt", false);
                    break;
                case 2:
                    optionsCase("grafo02.txt", true);
                    break;
                case 3:
                    optionsCase("grafo03.txt", false);
                    break;
                default:
                    System.out.println("Comando Inválido");
                    break;
            }
        }
    }

    public void optionsCase(String name, boolean control){
        Graph grafo = new Graph(new DataBase(name), control);
        System.out.println("\nGrafo Criado com sucesso [  100% ]\n");
        boolean ctrl = true;
        while(ctrl){
            System.out.println("Deseja Saber se o Grafo é Hamiltoniano?\n[0] - Não\n[1] - Sim");
            int Option = sc.nextInt();
            switch (Option) {
                case 1:
                    grafo.functionHamiltoniano(0);
                    grafo.printHamiltoniano();
                    ctrl= false;
                    break;
                case 2:
                    ctrl = false;
                    break;
                default:
                    System.out.println("Comando Inválido");
                    break;
            }
        }


    }

}
