package nocello.iesb.poop3.controller;


import nocello.iesb.poop3.dto.DadosCompra;
import nocello.iesb.poop3.dto.DadosPagamentoDTO;
import nocello.iesb.poop3.service.FinalizarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FinalizarController {

    @Autowired
    private FinalizarService serv;

    @PostMapping("/dados-pagamento")
    public ResponseEntity<String> dadosPagamento(@RequestBody DadosPagamentoDTO dados){

        int retorno = serv.mandaDados(dados);

        return ResponseEntity.ok().build();
    }

    @GetMapping("/mostra-dados")
    public DadosCompra mostraDados(){

        return serv.retornaDados();
    }

    @PostMapping("/fechar-compra")
    public ResponseEntity<String> fecharCompra(){

        if (serv.fecharCompra()==0){

            return ResponseEntity.ok().build();
        }

        return ResponseEntity.badRequest().body("usuario nao esta logado");
    }
}
