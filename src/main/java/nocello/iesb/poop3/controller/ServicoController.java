package nocello.iesb.poop3.controller;

import nocello.iesb.poop3.dto.ProdutoDTO;
import nocello.iesb.poop3.dto.ServicoDTO;
import nocello.iesb.poop3.service.ServicoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ServicoController {

    @Autowired
    private ServicoService serv;

    @PostMapping("/cadastro-servico")
    public ResponseEntity<String> cadastroServico(@RequestBody ServicoDTO novo){

        int salvou;
        salvou = serv.salvarServico(novo);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Nome invalido");
            case 2:
                return ResponseEntity.badRequest().body("Descricao invalida");
            case 3:
                return ResponseEntity.badRequest().body("Preco invalido");
            case 4:
                return ResponseEntity.badRequest().body("Vaga invalida");
            case 5:
                return ResponseEntity.badRequest().body("Animal invalido");

        }
        return ResponseEntity.ok().build();
    }

    @GetMapping("/mostrar-servico")
    public List<ServicoDTO> mostraServico(){
        List<ServicoDTO> novo = serv.mostraServicos();
        return novo;
    }

    @DeleteMapping("/deletar-servico")
    public ResponseEntity<String> deletarServico(@RequestBody ServicoDTO servico){

        int deletou;
        deletou = serv.delete(servico);

        if (deletou == 1){
            return ResponseEntity.badRequest().body("Erro ao deletar");
        }
        return ResponseEntity.ok().build();
    }

    @PutMapping("/atualizar-servico")
    public ResponseEntity<String> atualizarServico(@RequestBody ServicoDTO servico){

        int salvou;
        salvou = serv.salvarServico(servico);

        switch (salvou){
            case 1:
                return ResponseEntity.badRequest().body("Nome invalido");
            case 2:
                return ResponseEntity.badRequest().body("Descricao invalida");
            case 3:
                return ResponseEntity.badRequest().body("Preco invalido");
            case 4:
                return ResponseEntity.badRequest().body("Vaga invalida");
            case 5:
                return ResponseEntity.badRequest().body("Animal invalido");

        }
        return ResponseEntity.ok().build();
    }
}
