package nocello.iesb.poop3.service;

import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.dto.ServicoDTO;
import nocello.iesb.poop3.model.ServicoEntity;
import nocello.iesb.poop3.model.ServicoEntityBuilder;
import nocello.iesb.poop3.repository.ServicoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ServicoService {

    @Autowired
    private ServicoRepository repo;

    public int salvarServico(ServicoDTO servico){
        if (servico.getNome().equals("")){
            return 1;
        }

        if (servico.getDescricao().equals("")){
            return 2;
        }

        if (servico.getPreco()<0){
            return 3;
        }

        if (servico.getVagas()<0){
            return 4;
        }

        if (servico.getAnimal().equals("")){
            return 5;
        }

        ServicoEntity novo = new ServicoEntityBuilder()
                .withNome(servico.getNome())
                .withDescricao(servico.getDescricao())
                .withPreco(servico.getPreco())
                .withVagas(servico.getVagas())
                .withAnimal(servico.getAnimal())
                .withId(UUID.randomUUID().toString())
                .build();

        repo.adicionar(novo);
        return 0;
    }

    public List<ServicoDTO> mostraServicos(){
        List<ServicoDTO> servicoDTOS = new ArrayList<>();
        List<ServicoEntity> servicoEntities = repo.retornaServico();

        for (ServicoEntity serv:servicoEntities){
            servicoDTOS.add(new ServicoDTO(serv.getNome(),serv.getDescricao(),serv.getPreco(),serv.getVagas(),serv.getAnimal()));
        }
        return servicoDTOS;
    }

    public int delete(ServicoDTO servico) {
        int retorno = repo.delete(servico.getNome());

        return retorno;
    }
}
