package nocello.iesb.poop3.model;

import nocello.iesb.poop3.dto.ServicoDTO;

public class ServicoEntity extends ServicoDTO {

    private String id;


    public ServicoEntity(){
    }

    //todo: tirar esse construtor e botar outro com tudo


    public ServicoEntity(String nome, String descricao, float preco, int vagas, String animal, String id) {
        super(nome, descricao, preco, vagas, animal);
        this.id = id;
        this.getNome();
        this.getDescricao();
        this.getPreco();
        this.getVagas();
        this.getAnimal();
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


}

