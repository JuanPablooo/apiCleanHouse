package br.com.cleanhouse;

import br.com.cleanhouse.model.Endereco;
import br.com.cleanhouse.model.Residencia;
import br.com.cleanhouse.model.Servico;
import br.com.cleanhouse.model.SolicitacaoDeServico;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

public class SolicitacaoEndPoint extends CleanApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private SolicitacaoEndPoint solicitacaoEndPoint;

    @Before
    private void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(solicitacaoEndPoint).build();
    }

    @Test
    public void FazerSolicitacaoComDadosCorretos_RetornarStatusCode200() throws Exception {

        Endereco endereco = new Endereco();

        endereco.setBairro("Vila Jardins");
        endereco.setCep("17870-970");
        endereco.setCidade("Flora Rica");
        endereco.setEstado("São Paulo");
        endereco.setPais("Brasil");
        endereco.setRua("Avenida João Veloso 394");

        Residencia residencia = new Residencia();

        residencia.setEndereco(endereco);
        residencia.setNome("Condominio 2");

        Servico servico = new Servico();

        servico.setCozinhar(true);
        servico.setFaxina(true);
        servico.setPassar_lavar_roupa(false);

        Long idC = 3;


        SolicitacaoDeServico solicitacaoDeServico = new SolicitacaoDeServico(residencia, 3, 2, 2020-05-12, servico, 144.90, "Chegar antes das 15hrs", "Aguardando confirmação");

    }
