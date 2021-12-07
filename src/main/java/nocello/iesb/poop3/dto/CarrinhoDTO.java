package nocello.iesb.poop3.dto;

public class CarrinhoDTO {

    private String nome;
    private int qtd;
    private boolean isProduto;

    public CarrinhoDTO(String nome, int qtd, boolean isProduto) {
        this.nome = nome;
        this.qtd = qtd;
        this.isProduto = isProduto;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public boolean isProduto() {
        return isProduto;
    }

    public void setProduto(boolean produto) {
        isProduto = produto;
    }
}
