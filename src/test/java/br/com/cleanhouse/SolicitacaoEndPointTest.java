package br.com.cleanhouse;

import br.com.cleanhouse.endpoint.SolicitacaoEndPoint;
import br.com.cleanhouse.model.*;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import java.util.Date;

public class SolicitacaoEndPointTest extends CleanApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private SolicitacaoEndPoint solicitacaoEndPoint;

    @Before
    public void setUp() {
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
        residencia.setId(1L);

        Servico servico = new Servico();

        servico.setCozinhar(true);
        servico.setFaxina(true);
        servico.setPassar_lavar_roupa(false);

        Date data = new Date();

        //data.setDate(2020 - 05 - 02);

        SolicitacaoDeServicoDTO solicitacaoDeServico = new SolicitacaoDeServicoDTO(1L,"João Silva", 1L,"Clementina", data,residencia, servico, 144.90, "Chegar antes das 15hrs", "Aguardando confirmação");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(solicitacaoDeServico);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/solicitacao/servico")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(MockMvcResultMatchers.status().isCreated());


    }
}
