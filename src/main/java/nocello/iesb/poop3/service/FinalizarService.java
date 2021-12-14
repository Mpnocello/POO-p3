package nocello.iesb.poop3.service;

import nocello.iesb.poop3.dto.DadosCompra;
import nocello.iesb.poop3.dto.DadosPagamentoDTO;
import nocello.iesb.poop3.repository.FinalizarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class FinalizarService {

    @Autowired
    private FinalizarRepository repo;

    public int mandaDados(DadosPagamentoDTO dados){
        //Todo verificar os dados

        Pattern pattern = Pattern.compile("[0-9]{4} [0-9]{4} [0-9]{4} [0-9]{4}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(dados.getNumeroCartao());
        if (!matcher.matches()){
            return 1;
        }

        pattern = Pattern.compile("^\\p{L}+[\\p{L}\\p{Z}\\p{P}]{0,}", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(dados.getNomeCartao());
        if (!matcher.matches()){
            return 2;
        }

        pattern = Pattern.compile("(0[1-9]|1[012])/(2[2-9]|3[0])$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(dados.getDataCartao());
        if (!matcher.matches()){
            return 3;
        }

        pattern = Pattern.compile("[0-9]{3}$", Pattern.CASE_INSENSITIVE);
        matcher = pattern.matcher(dados.getCvvCartao());
        if (!matcher.matches()){
            return 4;
        }

        if (dados.getEnderecoCobranca().equals("")){
            return 5;
        }

        if (dados.getEnderecoEntrega().equals("")){
            return 6;
        }

        repo.adicionar(dados);

        return 0;
    }

    public DadosCompra retornaDados(){

        return repo.getDadosCompra();
    }

    public int fecharCompra(){

        return repo.fecharCompra();
    }
}
