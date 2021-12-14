package nocello.iesb.poop3.model.builders;

import nocello.iesb.poop3.model.ProdutoEntity;

public class ProdutoEntityBuilder {

    private String id;
    private String nome;
    private String descricao;
    private float preco;
    private int qtd;


    private static final ProdutoEntityBuilder instancia = new ProdutoEntityBuilder();

    public static ProdutoEntityBuilder getInstance(){
        return instancia;
    }

    private ProdutoEntityBuilder(){
    }

    public ProdutoEntityBuilder withNome(String nome){
        this.nome = nome;
        return this;

    }

    public ProdutoEntityBuilder withDescricao(String descricao){
        this.descricao = descricao;
        return this;
    }

    public ProdutoEntityBuilder witPreco(float preco){
        this.preco = preco;
        return this;
    }

    public ProdutoEntityBuilder withQtd(int qtd){
        this.qtd = qtd;
        return this;
    }

    public ProdutoEntityBuilder withId(String id){
        this.id = id;
        return this;
    }

    public ProdutoEntity build(){
        return new ProdutoEntity(nome,descricao,preco,qtd, id);
    }

}
