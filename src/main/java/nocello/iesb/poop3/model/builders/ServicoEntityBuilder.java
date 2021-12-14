package nocello.iesb.poop3.model.builders;

import nocello.iesb.poop3.model.ServicoEntity;

public class ServicoEntityBuilder {

    private String id;
    private String nome;
    private String descricao;
    private float preco;
    private int vagas;
    private String animal;

    private static final ServicoEntityBuilder instancia = new ServicoEntityBuilder();

    public static ServicoEntityBuilder getInstance(){
        return instancia;
    }

    private ServicoEntityBuilder(){
    }

    public ServicoEntityBuilder withNome(String nome){
        this.nome = nome;
        return this;
    }

    public ServicoEntityBuilder withDescricao(String descricao){
        this.descricao = descricao;
        return this;
    }

    public ServicoEntityBuilder withPreco(float preco){
        this.preco = preco;
        return this;
    }

    public ServicoEntityBuilder withVagas(int vagas){
        this.vagas = vagas;
        return this;
    }

    public ServicoEntityBuilder withAnimal(String animal){
        this.animal = animal;
        return this;
    }

    public ServicoEntityBuilder withId(String id){
        this.id = id;
        return this;
    }

    public ServicoEntity build(){
        return new ServicoEntity(nome, descricao, preco, vagas, animal, id);
    }

}
