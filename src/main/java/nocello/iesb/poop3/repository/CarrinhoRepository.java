package nocello.iesb.poop3.repository;


import nocello.iesb.poop3.dto.CarrinhoDTO;
import nocello.iesb.poop3.dto.ClienteDTO;
import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.ProdutoEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarrinhoRepository {

    @Autowired
    private ProdutoRepository produtoRepository;

    @Autowired
    private ServicoRepository servicoRepository;

    private List<CarrinhoDTO> listaCarrinho = new ArrayList<>();

    public int adicionar(CarrinhoDTO novo){
        if (novo.isProduto()){
            if (produtoRepository.existeProduto(novo.getNome())){
                if (produtoRepository.procuraProduto(novo.getNome()).getQtd()>novo.getQtd()){
                    listaCarrinho.add(novo);

                    return 0;
                }
                return 2;//quantidade invalida
            }
            return 1;//Produto ou serviço nao encontrado
        }else{
            if (servicoRepository.existeServico(novo.getNome())){
                if (servicoRepository.procuraServico(novo.getNome()).getVagas()>novo.getQtd()){
                    listaCarrinho.add(novo);

                    return 0;
                }
                return 2;
            }
            return 1;
        }
    }

    public List<CarrinhoDTO> mostraCarrinho(){

        return listaCarrinho;
    }
}
