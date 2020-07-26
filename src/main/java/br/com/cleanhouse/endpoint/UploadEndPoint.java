package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.disco.Disco;
import br.com.cleanhouse.model.Upload;
import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.UploadRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import br.com.cleanhouse.uploads.FileUpload;
import br.com.cleanhouse.uploads.FileUploadUrl;
import br.com.cleanhouse.uploads.FireBaseStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.*;

@RestController
@RequestMapping("v1/upload")
public class UploadEndPoint {

    @Autowired
    private Disco disco;

    @Autowired
    private UploadRepository uploadDAO;

    @Autowired
    private UsuarioRepository usuarioDAO;
    @Autowired
    private FireBaseStorageService fireBase;


    @PostMapping("foto/{id}")
    public ResponseEntity<?> uploadFoto(@RequestBody FileUpload file, @PathVariable Long id){
        Optional<Usuario> userOpt =  usuarioDAO.findById(id) ;
        if (userOpt.isPresent()){
           Usuario user = userOpt.get();
            FileUploadUrl url = fazIUploadArquivo(file, user.getEmail());
            user.setUrlPerfil(url.getUrl());
            usuarioDAO.save(user);
          return ResponseEntity.status(HttpStatus.OK).body(url);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encotrado");

    }
    public FileUploadUrl fazIUploadArquivo (FileUpload file, String email){
        Random random = new Random();
        int numAleatorio =  random.nextInt();
        int numAleatorio2 =  random.nextInt();
        String has = email + numAleatorio * numAleatorio2;
        FileUploadUrl url = new FileUploadUrl(fireBase.upLoad(file, has));
        return  url;
    }

    @PostMapping("video/{id}")
    public ResponseEntity<?> uploadVideo(@RequestBody FileUpload file, @PathVariable Long id){
        Optional<Usuario> userOpt =  usuarioDAO.findById(id) ;
        if (userOpt.isPresent()){
            Usuario user = userOpt.get();
            FileUploadUrl url = fazIUploadArquivo(file, user.getEmail());
            user.setUrlVideo(url.getUrl());
            usuarioDAO.save(user);
            return ResponseEntity.status(HttpStatus.OK).body(url);
        }
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Usuario nao encotrado");

    }

}
