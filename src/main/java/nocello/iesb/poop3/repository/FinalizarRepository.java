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

    private DadosCompra dadosCompra = new DadosCompra();


    public int adicionar(DadosPagamentoDTO dados){//botei debug aqui ve se pareceu ai

        if (!repoCliente.estaLogado()){
            return 1;
            //usuario nao esta logado
        }

        ClienteEntity cliente = repoCliente.retornaCliente(repoCliente.getLoginId());
        ClienteDTO clienteDTOS = new ClienteDTO(cliente.getNome(), cliente.getCpf(), cliente.getTelefoneResidencial(), cliente.getTelefoneComercial(),
                cliente.getTelefoneCelular(), cliente.getEmail(), cliente.getEndereco(), cliente.getSenha());

        dadosCompra.setDados(dados);
        dadosCompra.setCliente(clienteDTOS);

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
        dadosCompra.setLista(repoCarrinho.mostraCarrinho());
        dadosCompra.setValorTotal(preco);

        return 0;
    }

    public DadosCompra getDadosCompra() {
        return dadosCompra;
    }

    public int fecharCompra(){

        if (repoCliente.estaLogado()){
            repoCarrinho.alteraVendidos();
            repoCarrinho.limparCarrinho();
            //Todo alterar a quatindade de itens e adicionar na lista de comprados

            return 0;
        }

        return 1;
    }
}
