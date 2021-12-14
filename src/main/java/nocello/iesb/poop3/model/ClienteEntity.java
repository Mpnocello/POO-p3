package nocello.iesb.poop3.model;

import nocello.iesb.poop3.dto.ClienteDTO;

public class ClienteEntity extends ClienteDTO {

    private String login;

    public ClienteEntity() {
    }


    public ClienteEntity(String nome, String cpf, String telefoneResidencial, String telefoneComercial,
                         String telefoneCelular, String email, Endereco endereço,
                         String senha, String login) {
        super(nome, cpf, telefoneResidencial, telefoneComercial, telefoneCelular, email, endereço, senha);
        this.login = login;
        this.getNome();
        this.getCpf();
        this.getTelefoneResidencial();
        this.getTelefoneComercial();
        this.getTelefoneCelular();
        this.getEmail();
        this.getEndereco();
        this.getSenha();
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }
}
