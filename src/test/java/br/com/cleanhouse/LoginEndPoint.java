package br.com.cleanhouse;

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

public class LoginEndPoint extends CleanApplicationTests {

    private MockMvc mockMvc;

    @Autowired
    private LoginEndPoint loginEndPoint;

    @Before
    private void setUp(){
        this.mockMvc = MockMvcBuilders.standaloneSetup(loginEndPoint).build();
    }

    @Test
    public void FazerLoginComDadosCorretos_RetornarStatusCode200() throws Exception {

        Usuario usuario = new Usuario("catriina@hotmail.com", "123456789");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/login/usuario")
                                .contentType(MediaType.APPLICATION_JSON)
                                .content(json)
                            )
                            .andExpect(MockMvcResultMatchers.status().isOk())
                            .andExpect(MockMvcResultMatchers.header().string("location", Matchers.containsString("http://localhost/login/usuario")));

    }

    @Test
    public void FazerLoginComDadosIncorretos_RetornarStatusCode404() throws Exception {

        Usuario usuario = new Usuario("catriina@hotil.com", "1234789");

        ObjectMapper mapper = new ObjectMapper();

        String json = mapper.writeValueAsString(usuario);

        this.mockMvc.perform(MockMvcRequestBuilders.post("/login/usuario")
                .contentType(MediaType.APPLICATION_JSON)
                .content(json)
        )
                .andExpect(MockMvcResultMatchers.status().isNotFound());

    }

}
