package br.com.alura.bytebank.servico;

import br.com.alura.bytebank.model.Pagamento;
import br.com.alura.bytebank.registrador.RegistroDePagamento;
import br.com.alura.bytebank.registrador.validador.ValidaPagamento;

import java.util.List;

public class ServicoPagamento {

    private RegistroDePagamento registro = new RegistroDePagamento();

    public void registra(List<Pagamento> pagamentos) {
        ValidaPagamento validaPagamento = new ValidaPagamento();
        validaPagamento.verificaTipo(pagamentos);
        registro.registra(pagamentos);
    }

    public void exibeEfetuados() {
        registro.exibeEfetuados();
    }
}
