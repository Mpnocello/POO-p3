package nocello.iesb.poop3.service;

import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.model.ProdutoEntity;
import nocello.iesb.poop3.model.builders.ProdutoEntityBuilder;
import nocello.iesb.poop3.repository.ProdutoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Service
public class ProdutoService {

    @Autowired
    private ProdutoRepository repo;

    public int salvarProduto(ProdutoDTO produto){
        if (produto.getNome().equals("")){
            return 1;
        }

        if (produto.getPreco()<0){
            return 2;
        }

        if (produto.getDescricao().equals("")){
            return 3;
        }

        if (produto.getQtd()<0){
            return 4;
        }

        ProdutoEntity novo = new ProdutoEntityBuilder()
                .withNome(produto.getNome())
                .witPreco(produto.getPreco())
                .withDescricao(produto.getDescricao())
                .withQtd(produto.getQtd())
                .withId(UUID.randomUUID().toString())
                .build();

        repo.adicionar(novo);
        return 0;
    }

    public List<ProdutoDTO> mostraProdutos(){
        List<ProdutoDTO> produtoDTOS = new ArrayList<>();
        List<ProdutoEntity> produtoEntities = repo.retornaProduto();

        for (ProdutoEntity prod:produtoEntities){
            produtoDTOS.add(new ProdutoDTO(prod.getNome(),prod.getDescricao(),prod.getPreco(),prod.getQtd()));
        }
        return produtoDTOS;
    }

    public int delete(ProdutoDTO produto){
        int retorno = repo.delete(produto.getNome());

        return retorno;
    }
}
