package nocello.iesb.poop3.dto;

import java.util.List;

public class DadosCompra {

    private ClienteDTO cliente;
    private List<CarrinhoDTO> lista;
    private DadosPagamentoDTO dados;
    private float valorTotal;

    public DadosCompra() {
    }

    public DadosCompra(ClienteDTO cliente, List<CarrinhoDTO> lista,
                       DadosPagamentoDTO dados, float valorTotal) {
        this.cliente = cliente;
        this.lista = lista;
        this.dados = dados;
        this.valorTotal = valorTotal;
    }

    public ClienteDTO getCliente() {
        return cliente;
    }

    public void setCliente(ClienteDTO cliente) {
        this.cliente = cliente;
    }

    public List<CarrinhoDTO> getLista() {
        return lista;
    }

    public void setLista(List<CarrinhoDTO> lista) {
        this.lista = lista;
    }

    public DadosPagamentoDTO getDados() {
        return dados;
    }

    public void setDados(DadosPagamentoDTO dados) {
        this.dados = dados;
    }

    public float getValorTotal() {
        return valorTotal;
    }

    public void setValorTotal(float valorTotal) {
        this.valorTotal = valorTotal;
    }
}
