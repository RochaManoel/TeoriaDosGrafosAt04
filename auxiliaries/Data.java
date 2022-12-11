package auxiliaries;

public class Data {
    private Integer verticeInicial;
    private Integer verticeFinal;

    /*---CONSTRUTORES---*/
    public Data(Integer verticeInicial, Integer verticeFinal){
        this.verticeInicial = verticeInicial;
        this.verticeFinal = verticeFinal;
    }

    /*-----GETTERS------*/
    public Integer getverticeInicial() {
        return verticeInicial;
    }
    public Integer getverticeFinal() {
        return verticeFinal;
    }

    /*-----SETTERS------*/
    public void setverticeInicial(Integer verticeInicial) {
        this.verticeInicial = verticeInicial;
    }
    public void setverticeFinal(Integer verticeFinal) {
        this.verticeFinal = verticeFinal;
    }
}
