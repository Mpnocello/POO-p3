package nocello.iesb.poop3.repository;

import nocello.iesb.poop3.dto.*;
import nocello.iesb.poop3.model.ClienteEntity;
import nocello.iesb.poop3.model.Endereco;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class FinalizarRepository {

    @Autowired
    private ProdutoRepository repoProduto;

    @Autowired
    private ServicoRepository repoServico;

    @Autowired
    private ClienteRepository repoCliente;

    @Autowired
    private CarrinhoRepository repoCarrinho;

    private DadosCompra dadosCompra;


    public int adicionar(DadosPagamentoDTO dados){

        if (!repoCliente.estaLogado()){
            return 1;

        }

        ClienteEntity cliente = repoCliente.retornaCliente(repoCliente.getLoginId());
        ClienteDTO clienteDTOS = new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getTelefoneResidencial(), cliente.getTelefoneComercial(),
                cliente.getTelefoneCelular(), cliente.getEmail(), cliente.getEndereco(), cliente.getSenha());


        /*List<CarrinhoDTO> carrinhoDTOList = repoCarrinho.mostraCarrinho();
        CarrinhoResponse carrinhoResponse = new CarrinhoResponse();

        carrinhoResponse.setLista(carrinhoDTOList);*/

        float preco = 0;

        for (CarrinhoDTO c: repoCarrinho.mostraCarrinho()){

            if (c.isProduto()){
                preco+=(c.getQtd()*repoProduto.retornaPrecoProduto(c.getNome()));
            }else{
                preco+=(c.getQtd()*repoServico.retornaPrecoServico(c.getNome()));
            }

        }

        //carrinhoResponse.setPreco(preco);

        dadosCompra = new DadosCompra(clienteDTOS, repoCarrinho.mostraCarrinho(), dados, preco);

        return 0;
    }

    public DadosCompra getDadosCompra() {
        return dadosCompra;
    }

    public int fecharCompra(){

        if (repoCliente.estaLogado()){
            repoCarrinho.alteraVendidos();
            repoCarrinho.limparCarrinho();
            dadosCompra = null;

            return 0;
        }

        return 1;
    }
}
