package nocello.iesb.poop3.dto;

public class DadosPagamentoDTO {

    private String numeroCartao;
    private String nomeCartao;
    private String dataCartao;
    private String cvvCartao;
    private String enderecoCobranca;
    private String enderecoEntrega;

    public DadosPagamentoDTO() {
    }

    public DadosPagamentoDTO(String numeroCartao, String nomeCartao, String dataCartao, String cvvCartao, String enderecoCobranca, String enderecoEntrega) {
        this.numeroCartao = numeroCartao;
        this.nomeCartao = nomeCartao;
        this.dataCartao = dataCartao;
        this.cvvCartao = cvvCartao;
        this.enderecoCobranca = enderecoCobranca;
        this.enderecoEntrega = enderecoEntrega;
    }

    public String getNumeroCartao() {
        return numeroCartao;
    }

    public void setNumeroCartao(String numeroCartao) {
        this.numeroCartao = numeroCartao;
    }

    public String getNomeCartao() {
        return nomeCartao;
    }

    public void setNomeCartao(String nomeCartao) {
        this.nomeCartao = nomeCartao;
    }

    public String getDataCartao() {
        return dataCartao;
    }

    public void setDataCartao(String dataCartao) {
        this.dataCartao = dataCartao;
    }

    public String getCvvCartao() {
        return cvvCartao;
    }

    public void setCvvCartao(String cvvCartao) {
        this.cvvCartao = cvvCartao;
    }

    public String getEnderecoCobranca() {
        return enderecoCobranca;
    }

    public void setEnderecoCobranca(String enderecoCobranca) {
        this.enderecoCobranca = enderecoCobranca;
    }

    public String getEnderecoEntrega() {
        return enderecoEntrega;
    }

    public void setEnderecoEntrega(String enderecoEntrega) {
        this.enderecoEntrega = enderecoEntrega;
    }
}
