package br.com.cleanhouse.endpoint;


import br.com.cleanhouse.disco.Disco;
import br.com.cleanhouse.model.Upload;
import br.com.cleanhouse.model.Usuario;
import br.com.cleanhouse.repository.UploadRepository;
import br.com.cleanhouse.repository.UsuarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

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
        upload.setUsuario(usuario);

        if(disco.salvarFile(file)){
            uploadDAO.save(upload);
        }
        else{
            System.out.println("Não foi salvo");
        }

    }

    @PostMapping("foto/{id}")
    public void uploadFoto(@RequestParam MultipartFile foto, @PathVariable("id") Long id){

        String nomeFile = foto.getOriginalFilename();
        String tipo = "Imagem";

        Usuario usuario = usuarioDAO.findById(id).get();

        Upload upload = new Upload();

        upload.setNome(nomeFile);
        upload.setTipo(tipo);
        upload.setUsuario(usuario);

        if(disco.salvarFoto(foto)){
            uploadDAO.save(upload);
        }
        else{
            System.out.println("Não foi salvo");
        }

    }

    @PostMapping("video/{id}")
    public void uploadVideo(@RequestParam MultipartFile video, @PathVariable("id") Long id){

        String nomeFile = video.getOriginalFilename();
        String tipo = "Video";

        Usuario usuario = usuarioDAO.findById(id).get();

        Upload upload = new Upload();

        upload.setNome(nomeFile);
        upload.setTipo(tipo);
        upload.setUsuario(usuario);

        if(disco.salvarVideo(video)){
            uploadDAO.save(upload);
        }
        else{
            System.out.println("Não foi salvo");
        }

    }

}
