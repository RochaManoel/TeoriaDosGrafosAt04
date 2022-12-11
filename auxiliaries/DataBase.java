package auxiliaries;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class DataBase {  
    private Integer nVertices = 0;
    private Integer nArestas = 0;
    private ArrayList<Data> listData = new ArrayList<>();

    /*---CONSTRUTORES---*/
    public DataBase(String nameArq){
        try {
            FileReader file = new FileReader(nameArq);
            BufferedReader readFile = new BufferedReader(file);
            String firstLine = readFile.readLine();

            this.nVertices = Integer.parseInt(firstLine.substring(0,2).trim());
            this.nArestas = Integer.parseInt(firstLine.substring(3,firstLine.length()).trim());

            for(int count = 0; count < this.nArestas; count++){
                String otherLine = readFile.readLine();
                int vInicial = Integer.parseInt(otherLine.substring(0,2).trim());
                int vFinal = Integer.parseInt(otherLine.substring(3,otherLine.length()).trim());
                this.listData.add(new Data(vInicial, vFinal));
            }

            file.close();
        } 
        catch (IOException e) {
            System.err.printf("Erro na abertura do arquivo: %s.\n",
            e.getMessage());
        }
    }

    /*-----GETTERS------*/
    public Integer getnArestas() {
        return nArestas;
    }
    public Integer getnVertices() {
        return nVertices;
    }
    public ArrayList<Data> getListData() {
        return listData;
    }

    /*-----SETTERS------*/
    public void setnArestas(Integer nArestas) {
        this.nArestas = nArestas;
    }
    public void setnVertices(Integer nVertices) {
        this.nVertices = nVertices;
    }
    public void setListData(ArrayList<Data> listData) {
        this.listData = listData;
    }

}
