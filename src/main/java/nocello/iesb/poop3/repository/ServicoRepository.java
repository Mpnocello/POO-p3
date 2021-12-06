package nocello.iesb.poop3.repository;

import nocello.iesb.poop3.model.ProdutoEntity;
import nocello.iesb.poop3.model.ServicoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class ServicoRepository {

    private List<ServicoEntity> listaServicos = new ArrayList<>();

    private List<Adquiridos> adquirido = new ArrayList<>();

    public void adicionar(ServicoEntity novo){

        for (ServicoEntity s:listaServicos){
            if (s.getNome().equals(s.getNome())){
                int i = listaServicos.indexOf(s);
                listaServicos.set(i,novo);
                return;
            }
        }
        listaServicos.add(novo);
        adquirido.add(new Adquiridos(novo.getNome(),0));
    }

    public ServicoEntity procuraPorNome(String nome){
        for (ServicoEntity s:listaServicos){
            if (s.getNome().equals(nome)){
                return s;
            }
        }
        return null;
    }

    public List<ServicoEntity> retornaServico(){
        return listaServicos;
    }

    public int delete(String nome){
        for (ServicoEntity s:listaServicos){
            if (nome.equals(s.getNome())){
                for (Adquiridos a:adquirido){
                    if (a.getNome().equals(nome) && a.getVagas()==0){
                        listaServicos.remove(s);
                        adquirido.remove(a);

                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public boolean existeServico(String nome){
        for (ServicoEntity s:listaServicos){
            if (s.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }
}

class Adquiridos{

    private String nome;
    private int vagas;

    public Adquiridos(String nome, int qtd) {
        this.nome = nome;
        this.vagas = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getVagas() {
        return vagas;
    }

    public void setVagas(int vagas) {
        this.vagas = vagas;
    }
}

