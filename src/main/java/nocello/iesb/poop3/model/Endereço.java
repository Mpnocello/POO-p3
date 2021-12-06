package nocello.iesb.poop3.model;

public class Endereço {

    private String residencial;
    private String comercial;

    public Endereço(String residencial, String comercial) {
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
