package br.com.cleanhouse.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteEndPoint {


    @GetMapping("s")
    public void teste(){
        System.out.println("salve");
    }

}

