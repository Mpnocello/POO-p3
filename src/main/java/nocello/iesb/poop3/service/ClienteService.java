package nocello.iesb.poop3.service;


import nocello.iesb.poop3.dto.ClienteDTO;
import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.model.*;
import nocello.iesb.poop3.repository.ClienteRepository;
import nocello.iesb.poop3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ClienteService {


    @Autowired
    private ClienteRepository repo;

    public int salvarCliente(ClienteDTO cliente){

        Pattern pattern = Pattern.compile("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(cliente.getNome());
        if (!matcher.matches()){
            return 1;
        }

        pattern = Pattern.compile("[0-9]{3}.[0-9]{3}.[0-9]{3}-[0-9]{2}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cliente.getCpf());
        if (!matcher.matches()){
            return 2;
        }

        pattern = Pattern.compile("(?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cliente.getTelefoneResidencial());
        if (!matcher.matches()){
            return 3;
        }

        pattern = Pattern.compile("(?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cliente.getTelefoneComercial());
        if (!matcher.matches()){
            return 4;
        }

        pattern = Pattern.compile("(?:[2-8]|9[1-9])[0-9]{3}-[0-9]{4}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cliente.getTelefoneCelular());
        if (!matcher.matches()){
            return 5;
        }

        pattern = Pattern.compile("^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(cliente.getEmail());

        if (!matcher.matches()) {
            return 6;
        }

        ClienteEntity novo = new ClienteEntityBuilder()
                .withNome(cliente.getNome())
                .withCpf(cliente.getCpf())
                .withTelefoneResidencial(cliente.getTelefoneResidencial())
                .withTelefoneComercial(cliente.getTelefoneComercial())
                .withTelefoneCelular(cliente.getTelefoneCelular())
                .withEmail(cliente.getEmail())
                .withLogin(UUID.randomUUID().toString())
                .withEndereço(cliente.getEndereço())
                .withSenha(cliente.getSenha())
                .build();

        repo.adicionar(novo);
        return 0;
    }

    public List<ClienteDTO> mostraCliente(){
        List<ClienteDTO> clienteDTOS = new ArrayList<>();
        List<ClienteEntity> clienteEntities = repo.retornaCliente();

        for (ClienteEntity cliente:clienteEntities){
            clienteDTOS.add(new ClienteDTO(cliente.getNome(),cliente.getCpf(),cliente.getTelefoneResidencial()
                    ,cliente.getTelefoneComercial(), cliente.getTelefoneCelular(), cliente.getEmail(),
                    new Endereço(cliente.getEndereço().getResidencial(),cliente.getEndereço().getComercial()),
                    cliente.getSenha()));
        }
        return clienteDTOS;
    }
}
