package nocello.iesb.poop3.service;


import nocello.iesb.poop3.dto.CarrinhoDTO;
import nocello.iesb.poop3.repository.CarrinhoRepository;
import nocello.iesb.poop3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CarrinhoService {

    @Autowired
    private CarrinhoRepository repo;

    public int adicionarCarrinho(CarrinhoDTO salvo){

        return repo.adicionar(salvo);
    }

    public List<CarrinhoDTO> mostraCarrinho(){

        return repo.mostraCarrinho();
    }
}
