package nocello.iesb.poop3.controller;

import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

public class ClienteController {


    @RestController
    public class ProdutoController {

        @Autowired
        private ProdutoService serv;

        @PostMapping("/cadastro-cliente")
        public ResponseEntity<String> cadastroCliente(@RequestBody ProdutoDTO novo){

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



}
