package nocello.iesb.poop3.dto;

import java.util.List;

public class CarrinhoResponse {

    private List<CarrinhoDTO> lista;
    private float preco;

    public CarrinhoResponse() {
    }

    public CarrinhoResponse(List<CarrinhoDTO> lista, float preco) {
        this.lista = lista;
        this.preco = preco;
    }

    public List<CarrinhoDTO> getLista() {
        return lista;
    }

    public void setLista(List<CarrinhoDTO> lista) {
        this.lista = lista;
    }

    public float getPreco() {
        return preco;
    }

    public void setPreco(float preco) {
        this.preco = preco;
    }
}
