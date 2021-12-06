package nocello.iesb.poop3.controller;

import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.repository.ProdutoRepository;
import nocello.iesb.poop3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProdutoController {

    @Autowired
    private ProdutoService serv;

    @PostMapping("/cadastro-produto")
    public ResponseEntity<String> cadastroProduto(@RequestBody ProdutoDTO novo){

        int salvou;
        salvou = serv.salvarProduto(novo);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Nome errado");
            case 2:
                return ResponseEntity.badRequest().body("Preco invalido");
            case 3:
                return ResponseEntity.badRequest().body("Descricao errada");
            case 4:
                return ResponseEntity.badRequest().body("Quantidade invalida");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mostrar-produto")
    public List<ProdutoDTO> mostraProdutos(){
        List<ProdutoDTO> novo = serv.mostraProdutos();
        return novo;
    }

    @DeleteMapping("/deletar-produto")
    public ResponseEntity<String> deletarProduto(@RequestBody ProdutoDTO produto){

        int deletou;
        deletou = serv.delete(produto);

        if (deletou == 1){
            return ResponseEntity.badRequest().body("Erro ao deletar");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar-produto")
    public ResponseEntity<String> atualizarProduto(@RequestBody ProdutoDTO produto){

        int salvou;
        salvou = serv.salvarProduto(produto);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Nome errado");
            case 2:
                return ResponseEntity.badRequest().body("Preco invalido");
            case 3:
                return ResponseEntity.badRequest().body("Descricao errada");
            case 4:
                return ResponseEntity.badRequest().body("Quantidade invalida");
        }
        return ResponseEntity.ok().build();
    }
}
