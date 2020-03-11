package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClientesEndPoint {

    @GetMapping("/s")
    public void sksdk(){

        System.out.println("jsossdfos");
    }
    public class SeiLa{
        public void nsei(){
            System.out.println("blablabla");
        }
    }
}

