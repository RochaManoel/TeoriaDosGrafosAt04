package Entities;

import java.util.ArrayList;

import auxiliaries.Data;
import auxiliaries.DataBase;

public class Graph {
    private int nVertices = 0;
    private int [][]Grafo = new int[this.nVertices][this.nVertices];
    private ArrayList<Integer> caminho = new ArrayList<>();
    private Boolean isHalmitoniano = false;

    /*---CONSTRUTORES---*/
    public Graph(DataBase db, boolean direction){
        this.nVertices = db.getnVertices();
        this.createGraph(db, direction);
    }

    /*-----GETTERS------*/
    public int[][] getGrafo() {
        return Grafo;
    }
    public int getnVertices() {
        return nVertices;
    }
    public ArrayList<Integer> getCaminho() {
        return caminho;
    }
    public Boolean getIsHalmitoniano() {
        return isHalmitoniano;
    }

    /*-----SETTERS------*/
    public void setGrafo(int[][] grafo) {
        Grafo = grafo;
    }
    public void setnVertices(int nVertices) {
        this.nVertices = nVertices;
    }
    public void setCaminho(ArrayList<Integer> path) {
        this.caminho = path;
    }
    public void setIsHalmitoniano(Boolean isHalmitoniano) {
        this.isHalmitoniano = isHalmitoniano;
    }

    //Criar Grafo para construir matriz de adjacência
    private void createGraph(DataBase db,boolean direction){
        int [][]grafo = new int[nVertices][nVertices];
        for(int i = 0; i<nVertices;i++){
            for(int j = 0; j <nVertices;j++){
                grafo[i][j] = 0;
            }
        }
        for(Data data : db.getListData()){
            grafo[data.getverticeInicial()-1][data.getverticeFinal()-1] = 1;
            if(!direction){
                grafo[data.getverticeFinal()-1][data.getverticeInicial()-1] = 1;
            }
        }
        this.Grafo = grafo;
    }

    //Analisar o Grafo em questão se ele é hamiltoniano...

    public boolean functionHamiltoniano(Integer root){
        this.caminho.add(root);
        for(int i=0; i < nVertices; i++){
            if(this.Grafo[root][i]==1){
                if(inPath(i)){
                    if(functionHamiltoniano(i)){
                        return true;
                    }
                }
            }
        }

        if(this.caminho.size() == this.nVertices){
            if(this.Grafo[this.caminho.get(nVertices-1)][this.caminho.get(0)]==1){
                this.isHalmitoniano = true;
                return true;
            }
            else{
                return false;
            }
        }
        this.caminho.remove(root);
        return isHalmitoniano;
    }

    private boolean inPath(Integer n){
        for(int i:this.caminho){
            if(n==i){
                return false;
            }
        }
        return true;
    }

    public void printGrafo(){
        for(int i = 0; i<nVertices;i++){
            for(int j = 0; j <nVertices;j++){
                System.out.printf("%d ", this.Grafo[i][j]);
            }
            System.out.println("\n");
        }
    }

    public void positionRobot(Integer quant){
        int vertice = 0;
        double result = this.caminho.size()/quant;
        System.out.println();
        for(int i = 1; i <= quant;i++){
            int aux = this.caminho.get(vertice)+1;
            System.out.println("O Robô "+i+" inicia no vértice: "+aux);
            vertice+=result;
        }
        System.out.println();
    }

    public void printHamiltoniano(){
        if(this.isHalmitoniano){
            System.out.printf("\nO Grafo analisado é Hamiltoniano, Logo possui um Caminho que demonstra um Ciclo Hamiltoniano.\nO Caminho é : ");
            for(Integer i : this.caminho){
                System.out.printf("%d ", i+1);
            }
            System.out.println("\n");
        }
        else{
            System.out.println("\nO Grafo analisado não é Hamiltoniano, Logo Não possui um Caminho que demonstra um Ciclo Hamiltoniano.\n");
        }
    }

}
