package nocello.iesb.poop3.model;

import nocello.iesb.poop3.dto.ProdutoDTO;

public class ProdutoEntity extends ProdutoDTO {

    private String id;

    public ProdutoEntity(String nome, String descricao, float preco, int qtd, String id) {
        super(nome, descricao, preco, qtd);
        this.id = id;
        this.getNome();
        this.getDescricao();
        this.getPreco();
        this.getQtd();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


