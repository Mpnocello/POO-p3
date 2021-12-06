package nocello.iesb.poop3.dto;

public class ServicoDTO {

    private String nome;
    private String descricao;
    private float preco;
    private int vagas;
    private String animal;

    public ServicoDTO(String nome, String descricao, float preco, int vagas, String animal) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.vagas = vagas;
        this.animal = animal;
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

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }

    public String getAnimal() {
        return animal;
    }

    public void setAnimal(String animal) {
        this.animal = animal;
    }
}
