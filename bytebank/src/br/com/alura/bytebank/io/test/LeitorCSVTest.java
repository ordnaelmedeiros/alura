package br.com.alura.bytebank.io.test;

import br.com.alura.bytebank.io.LeitorCSV;
import br.com.alura.bytebank.model.Pagamento;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class LeitorCSVTest {

    @Test
    void testNothing() throws IOException {
        assertTrue(true);
    }

    @Test
    void pagamentosDeAbril() throws IOException {

        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(1);

        assertEquals(5, pagamentos.size());
    }

    @Test
    void pagamentosDeMaio() throws IOException {

        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(2);

        assertEquals(5, pagamentos.size());

    }

    @Test
    void pagamentosDeJunho() throws IOException {

        LeitorCSV leitor = new LeitorCSV();
        List<Pagamento> pagamentos = leitor.ler(3);

        assertEquals(5, pagamentos.size());

    }
}