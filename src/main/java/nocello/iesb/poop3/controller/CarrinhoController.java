package nocello.iesb.poop3.controller;


import nocello.iesb.poop3.dto.CarrinhoDTO;
import nocello.iesb.poop3.service.CarrinhoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

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

    @GetMapping("/mostrar-carrinho")
    public List<CarrinhoDTO> mostraCarrinho(){
        List<CarrinhoDTO> novo = serv.mostraCarrinho();

        return novo;
    }
}
