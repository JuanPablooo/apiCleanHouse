package com.example.demo.endpoint;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/clientes")
public class ClienteEndPoint {

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

