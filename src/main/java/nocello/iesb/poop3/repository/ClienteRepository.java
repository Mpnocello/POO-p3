package nocello.iesb.poop3.repository;


import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.ProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<ClienteEntity> listaCliente = new ArrayList<>();

    public void adicionar(ClienteEntity novo){
        listaCliente.add(novo);
    }

    public List<ClienteEntity> retornaCliente(){
        return listaCliente;
    }

    public String login(String nome, String senha){
        String retorno = null;

        for (ClienteEntity cliente: listaCliente){
            if (nome.equals(cliente.getNome())){
                if (senha.equals(cliente.getSenha())){
                    retorno = cliente.getLogin();
                    break;
                }
            }
        }
        return retorno;
    }
}
