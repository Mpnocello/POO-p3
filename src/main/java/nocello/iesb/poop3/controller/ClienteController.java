package nocello.iesb.poop3.controller;

import nocello.iesb.poop3.dto.ClienteDTO;
import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.service.ClienteService;
import nocello.iesb.poop3.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class ClienteController {


    @Autowired
    private ClienteService serv;

    @PostMapping("/cadastro-cliente")
    public ResponseEntity<String> cadastroCliente(@RequestBody ClienteDTO novo){

        int salvou;
        salvou = serv.salvarCliente(novo);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Nome errado");
            case 2:
                return ResponseEntity.badRequest().body("Cpf invalido");
            case 3:
                return ResponseEntity.badRequest().body("Telefone Residencial invalido");
            case 4:
                return ResponseEntity.badRequest().body("Telefone Comercial invalido");
            case 5:
                return ResponseEntity.badRequest().body("Telefone Celular invalido");
            case 6:
                return ResponseEntity.badRequest().body("Email invalido");
        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mostrar-cliente")
    public List<ClienteDTO> mostraCliente(){
        List<ClienteDTO> novo = serv.mostraCliente();
        return novo;
    }
}
