package com.example.demo.endpoint;


import com.example.demo.model.Profissional;
import com.example.demo.repository.ProfissionalRepository;
import net.minidev.json.JSONUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("profissionais")
public class ProfissionalEndPoint {
//    private final List<ProfissionalRepository> ProfissionalDAO;
//
//
//    @Autowired
//    public ProfissionalEndPoint(List<ProfissionalRepository> profissionalDAO) {
//        ProfissionalDAO = profissionalDAO;
//    }

//    @GetMapping()
//    public ResponseEntity<?> listAll(){
//        //return new ResponseEntity<>(ProfissionalDAO.findAll)
//    }
    @GetMapping("s")
    public void teste(){
        System.out.println("salve");
    }
}
