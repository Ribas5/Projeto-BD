
package projetobd;


public class Filme {
    private String nome ;
    private int id;
    private int duracao;
    private float preco;
    private String faixa_etaria;
    private int id_estudio;

    public String getNome() {
        return nome;
    }

    public int getId() {
        return id;
    }

    public int getDuracao() {
        return duracao;
    }

    public float getPreco() {
        return preco;
    }

    public String getFaixaetaria() {
        return faixa_etaria;
    }

    public int getIdestudio() {
        return id_estudio;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setDuracao(int duracao) {
        this.duracao = duracao;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public void setFaixaetaria(String faixa_etaria) {
        this.faixa_etaria = faixa_etaria;
    }

    public void setIdestudio(int id_estudio) {
        this.id_estudio = id_estudio;
    }
    
     
}
