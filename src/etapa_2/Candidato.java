package etapa_2;

public class Candidato {
    private String nome;
    private String partido;
    private int intencoesVotos;


    public Candidato(String nome, String partido, int intencoesVotos) {
        this.nome = nome;
        this.partido = partido;
        this.intencoesVotos = intencoesVotos;
    }


    public String getNome() {
        return nome;
    }


    public void setNome(String nome) {
        this.nome = nome;
    }


    public String getPartido() {
        return partido;
    }


    public void setPartido(String partido) {
        this.partido = partido;
    }


    public int getIntencoesVotos() {
        return intencoesVotos;
    }


    public void setIntencoesVotos(int intencoesVotos) {
        this.intencoesVotos = intencoesVotos;
    }


    @Override
    public String toString() {
        return "Candidato " + nome + ", Partido = " + partido + ", intenções de votos = " + intencoesVotos;
    }

    

    
}
