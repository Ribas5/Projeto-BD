package projetobd;

public class Pedido {

    private String data;
    private int id;
    private String expiracao;
    private int id_usuario;


    public int getId() {
        return id;
    }

    public String getData() {
        return data;
    }

    public String getExpiracao() {
        return expiracao;
    }

    public float getIDU() {
        return id_usuario;
    }

    
    /////////set///////////////
    public void setId(int id) {
        this.id = id;
    }

    public void setData(String data) {
        this.data = data;
    }

    public void setExpiracao(String expiracao) {
        this.expiracao = expiracao;
    }

    public void setIDU(int id_usuario) {
        this.id_usuario = id_usuario;
    }

}
