package nocello.iesb.poop3.service;

import nocello.iesb.poop3.dto.DadosCompra;
import nocello.iesb.poop3.dto.DadosPagamentoDTO;
import nocello.iesb.poop3.repository.FinalizarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FinalizarService {

    @Autowired
    private FinalizarRepository repo;

    public int mandaDados(DadosPagamentoDTO dados){
        //Todo verificar os dados

        repo.adicionar(dados);

        return 0;
    }

    public DadosCompra retornaDados(){

        return repo.getDadosCompra();
    }

    public int fecharCompra(){

        return repo.fecharCompra();
    }
}
