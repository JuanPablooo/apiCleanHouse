package br.com.cleanhouse;

import br.com.cleanhouse.endpoint.LoginEndPoint;
import br.com.cleanhouse.model.Usuario;
import com.fasterxml.jackson.core.JsonProcessingException;
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

public class LoginEndPointTest extends CleanApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private LoginEndPoint loginEndPoint;

    @Before
    public void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(loginEndPoint).build();
    }

    @Test
    public void FazerLoginComDadosCorretos_RetornarStatusCode200() throws Exception {

        Usuario usuario = new Usuario("catarina@gmail.com", "123456789");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/login")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                            )
                            .andExpect(MockMvcResultMatchers.status().isOk());

    }

    @Test
    public void FazerLoginComDadosIncorretos_RetornarStatusCode404() throws Exception {

        Usuario usuario = new Usuario("catriina@hotil.com", "1234789");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/v1/login")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(MockMvcResultMatchers.status().isBadRequest());

    }

}
