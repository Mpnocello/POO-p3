package nocello.iesb.poop3.repository;


import nocello.iesb.poop3.dto.CarrinhoDTO;
import nocello.iesb.poop3.dto.ClienteDTO;
import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.ProdutoEntity;
import nocello.iesb.poop3.model.ServicoEntity;
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
                if (qtdValida(novo)){
                    save(novo);

                    return 0;
                }
                return 2;
            }
            return 1;
        }else{
            if (servicoRepository.existeServico(novo.getNome())){
                if (qtdValida(novo)){
                    save(novo);

                    return 0;
                }
                return 2;
            }
            return 1;
        }
    }

    private void save(CarrinhoDTO carrinho){
        for (CarrinhoDTO c:listaCarrinho){
            if (carrinho.getNome().equals(c.getNome())){
                if (qtdValida(new CarrinhoDTO(c.getNome(), c.getQtd()+carrinho.getQtd(),c.isProduto()))){
                    listaCarrinho.get(listaCarrinho.indexOf(c)).setQtd(c.getQtd()+carrinho.getQtd());

                }
                return;
            }
        }
        listaCarrinho.add(carrinho);
    }

    public List<CarrinhoDTO> mostraCarrinho(){

        return listaCarrinho;
    }

    public int limparCarrinho(){

        if (listaCarrinho.isEmpty()){
            return 1;
        }
        listaCarrinho.clear();
        return 0;
    }

    public int deletarItem(CarrinhoDTO item){

        for (CarrinhoDTO c:listaCarrinho){
            if (item.getNome().equals(c.getNome())){
                listaCarrinho.remove(c);

                return 0;
            }
        }
        return 1;
    }

    public int alterarItem(CarrinhoDTO item){

        for (CarrinhoDTO c:listaCarrinho){
            if (item.getNome().equals(c.getNome())){
                if (qtdValida(item)){
                    listaCarrinho.set(listaCarrinho.indexOf(c),item);

                    return 0;
                }
            }
        }
        return 1;
    }

    private boolean qtdValida(CarrinhoDTO item){
        if (item.isProduto()){
            for (ProdutoEntity p:produtoRepository.retornaProduto()){
                if (p.getNome().equals(item.getNome())){
                    if (p.getQtd()>=item.getQtd()){
                        return true;
                    }
                }
            }
            return false;

        }else {
            for (ServicoEntity s:servicoRepository.retornaServico()){
                if (s.getNome().equals(item.getNome())){
                    if (s.getVagas()>=item.getQtd()){
                        return true;
                    }
                }
            }
            return false;
        }
    }

    public float calculaPreco(){

        float preco = 0;

        for (CarrinhoDTO c:listaCarrinho){
            if (c.isProduto()){
                preco+=c.getQtd()*produtoRepository.procuraProduto(c.getNome()).getPreco();
            }else {
                preco+=c.getQtd()*servicoRepository.procuraServico(c.getNome()).getPreco();
            }
        }
        return preco;
    }

    public void alteraVendidos(){

        for(CarrinhoDTO c:listaCarrinho){
            if(c.isProduto()){
                produtoRepository.atualizaVendido(c.getNome(), c.getQtd());
            }else{
                servicoRepository.atualizaAdquirido(c.getNome(), c.getQtd());
            }
        }

    }
}
