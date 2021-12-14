package nocello.iesb.poop3.repository;


import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.ProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ClienteRepository {

    private List<ClienteEntity> listaCliente = new ArrayList<>();

    private String loginId = null;

    public String getLoginId() {
        return loginId;
    }

    public void setLoginId(String loginId) {
        this.loginId = loginId;
    }

    public int adicionar(ClienteEntity novo){
        for(ClienteEntity c: listaCliente){
            if(c.getNome().equals(novo.getNome())){
                return 1;//usuario ja existe
            }
        }
        listaCliente.add(novo);
        return 0;
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
                    setLoginId(cliente.getLogin());
                    break;
                }else {
                    setLoginId(null);
                }
            }
        }
        return retorno;
    }

    public boolean estaLogado(){

        if (getLoginId()==null){
            return false;
        }
        return true;
    }

    public ClienteEntity retornaCliente(String id){
        for (ClienteEntity cliente: listaCliente){
            if (cliente.getLogin().equals(id)){

                return cliente;
            }
        }
        return null;
    }
}
