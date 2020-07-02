package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.disco.Disco;
import br.com.cleanhouse.model.Upload;
import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.UploadRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("upload")
public class UploadEndPoint {

    @Autowired
    private Disco disco;

    @Autowired
    private UploadRepository uploadDAO;

    @Autowired
    private UsuarioRepository usuarioDAO;

    @PostMapping("{id}")
    public void upload(@RequestParam MultipartFile file, @PathVariable("id") Long id){


        String nomeFile = file.getOriginalFilename();
        String tipo = "Outros";

        Usuario usuario = usuarioDAO.findById(id).get();

        Upload upload = new Upload();

        upload.setNome(nomeFile);
        upload.setTipo(tipo);
        //upload.setUsuario(usuario);

        List<Upload> listUpload = new ArrayList<>();
        listUpload.add(upload);

        usuario.setUploads(listUpload);

        if(disco.salvarFile(file)){
            uploadDAO.save(upload);
        }
        else{
            System.out.println("Não foi salvo");
        }

    }

    @PostMapping("foto/{id}")
    public ResponseEntity<?> uploadFoto(@RequestParam MultipartFile foto, @PathVariable("id") Long id){

        if(foto.getSize() <= 2097152){
            String nomeFile = foto.getOriginalFilename();
            String tipo = "Imagem";

            Usuario usuario = usuarioDAO.findById(id).get();

            Upload upload = new Upload();

            upload.setNome(nomeFile);
            upload.setTipo(tipo);
            //upload.setUsuario(usuario);

            List<Upload> listUpload = new ArrayList<>();
            listUpload.add(upload);

            usuario.setUploads(listUpload);

            if(disco.salvarFoto(foto)){
                System.out.println(foto.getSize());
                return new ResponseEntity<>(uploadDAO.save(upload), HttpStatus.CREATED);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi salvo");
            }
        }else{
            System.out.println(foto.getSize());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Só é permitido tamanho até 2MB");
        }



    }

    @PostMapping("video/{id}")
    public ResponseEntity<?> uploadVideo(@RequestParam MultipartFile video, @PathVariable("id") Long id){

        if(video.getSize() <= 314572800){
            String nomeFile = video.getOriginalFilename();
            String tipo = "Video";

            Usuario usuario = usuarioDAO.findById(id).get();

            Upload upload = new Upload();

            upload.setNome(nomeFile);
            upload.setTipo(tipo);
            //upload.setUsuario(usuario);

            List<Upload> listUpload = new ArrayList<>();
            listUpload.add(upload);

            usuario.setUploads(listUpload);

            if(disco.salvarVideo(video)){
                System.out.println(video.getSize());
                return new ResponseEntity<>(uploadDAO.save(upload), HttpStatus.CREATED);
            }
            else{
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Não foi salvo");
            }
        }else{
            System.out.println(video.getSize());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Só é permitido tamanho até 300MB");
        }



    }

}
