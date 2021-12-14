package nocello.iesb.poop3.model.builders;

import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.Endereco;

public class ClienteEntityBuilder {

    private String nome;
    private String cpf;
    private String telefoneResidencial;
    private String telefoneComercial;
    private String telefoneCelular;
    private String email;
    private String login;
    private Endereco endereco;
    private String senha;

    public ClienteEntityBuilder withNome(String nome){
        this.nome = nome;
        return this;
    }

    public ClienteEntityBuilder withCpf(String cpf){
        this.cpf = cpf;
        return this;
    }

    public ClienteEntityBuilder withTelefoneResidencial(String telefoneResidencial){
        this.telefoneResidencial = telefoneResidencial;
        return this;
    }

    public ClienteEntityBuilder withTelefoneComercial(String telefoneComercial){
        this.telefoneComercial = telefoneComercial;
        return this;
    }

    public ClienteEntityBuilder withTelefoneCelular(String telefoneCelular){
        this.telefoneCelular = telefoneCelular;
        return this;
    }

    public ClienteEntityBuilder withEmail(String email){
        this.email = email;
        return this;
    }

    public ClienteEntityBuilder withLogin(String login){
        this.login = login;
        return this;
    }

    public ClienteEntityBuilder withEndereco(Endereco endereco){
        this.endereco = endereco;
        return this;
    }

    public ClienteEntityBuilder withSenha(String senha){
        this.senha = senha;
        return this;
    }

    public ClienteEntity build(){
        return new ClienteEntity(nome, cpf, telefoneResidencial, telefoneComercial,
                telefoneCelular, email, endereco, senha, login);

    }
}


