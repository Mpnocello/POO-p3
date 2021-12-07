package nocello.iesb.poop3.repository;

import nocello.iesb.poop3.model.ProdutoEntity;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Repository
public class ProdutoRepository {

    private List<ProdutoEntity> listaProdutos = new ArrayList<>();

    private List<Comprados> comprados = new ArrayList<>();

    public void adicionar(ProdutoEntity novo){

        for (ProdutoEntity p:listaProdutos){
            if (p.getNome().equals(p.getNome())){
                int i = listaProdutos.indexOf(p);
                listaProdutos.set(i,novo);
                return;
            }
        }
        listaProdutos.add(novo);
        comprados.add(new Comprados(novo.getNome(),0));
    }

    public ProdutoEntity procuraPorNome(String nome){
        for (ProdutoEntity p:listaProdutos){
            if (p.getNome().equals(nome)){
                return p;
            }
        }
        return null;
    }

    public List<ProdutoEntity> retornaProduto(){
        return listaProdutos;
    }

    public int delete(String nome){
        for (ProdutoEntity p:listaProdutos){
            if (nome.equals(p.getNome())){
                for (Comprados c:comprados){
                    if (c.getNome().equals(nome) && c.getQtd()==0){
                        listaProdutos.remove(p);
                        comprados.remove(c);

                        return 0;
                    }
                }
            }
        }
        return 1;
    }

    public boolean existeProduto(String nome){
        for (ProdutoEntity p:listaProdutos){
            if (p.getNome().equals(nome)){
                return true;
            }
        }
        return false;
    }

    public ProdutoEntity procuraProduto(String nome){
        for (ProdutoEntity p:listaProdutos){
            if (p.getNome().equals(nome)){
                return p;
            }
        }
        return null;
    }
}

class Comprados{

    private String nome;
    private int qtd;

    public Comprados(String nome, int qtd) {
        this.nome = nome;
        this.qtd = qtd;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }
}
