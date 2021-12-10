package nocello.iesb.poop3.controller;


import nocello.iesb.poop3.dto.CarrinhoDTO;
import nocello.iesb.poop3.dto.CarrinhoResponse;
import nocello.iesb.poop3.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CarrinhoController {

    @Autowired
    private CarrinhoService serv;

    @PostMapping("/adicionar-carrinho")
    public ResponseEntity<String> adicionarCarrinho(@RequestBody CarrinhoDTO novo){

        int salvou;
        salvou = serv.adicionarCarrinho(novo);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Produto ou serviço nao encontrado");
            case 2:
                return ResponseEntity.badRequest().body("Quantidade invalida");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mostra-carrinho")
    public ResponseEntity<CarrinhoResponse> mostraCarrinho(@RequestParam(required = false) String desconto){

        CarrinhoResponse carrinho = new CarrinhoResponse();
        List<CarrinhoDTO> novo = serv.mostraCarrinho();
        carrinho.setLista(novo);

        float preco = serv.calculaPreco(desconto);

        if (preco==-1){
            return ResponseEntity.notFound().build();
        }

        carrinho.setPreco(preco);

        return ResponseEntity.ok().body(carrinho);
    }

    @DeleteMapping("/limpar-carrinho")
    public ResponseEntity<String> limparCarrinho(){

        int retorno = serv.limparCarrinho();

        if (retorno==1){
            return ResponseEntity.badRequest().body("Carrinho já esta vazio");
        }

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/deletar-item")
    public ResponseEntity<String> deletarItem(@RequestBody CarrinhoDTO item){

        int retorno = serv.deletarItem(item);

        if (retorno==1){
            return ResponseEntity.badRequest().body("Item não encontrado");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/alterar-item")
    public ResponseEntity<String> alterarItem(@RequestBody CarrinhoDTO item){

        int atualizar;
        atualizar = serv.alterarItem(item);

        switch (atualizar){
            case 1:
                return ResponseEntity.badRequest().body("Produto ou serviço nao encontrado");

        }
        return ResponseEntity.ok().build();
    }
}
