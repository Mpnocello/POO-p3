package nocello.iesb.poop3.model;

public class Endereco {

    private String residencial;
    private String comercial;

    public Endereco() {
    }

    public Endereco(String residencial, String comercial) {
        this.residencial = residencial;
        this.comercial = comercial;
    }

    public String getResidencial() {
        return residencial;
    }

    public void setResidencial(String residencial) {
        this.residencial = residencial;
    }

    public String getComercial() {
        return comercial;
    }

    public void setComercial(String comercial) {
        this.comercial = comercial;
    }
}
