package nocello.iesb.poop3.dto;

public class ProdutoDTO {

    private String nome;
    private String descricao;
    private float preco;
    private int qtd;

    public ProdutoDTO(String nome, String descricao, float preco, int qtd) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

}
