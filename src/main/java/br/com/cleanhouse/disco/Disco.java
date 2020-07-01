package br.com.cleanhouse.disco;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Component
public class Disco {

    private String raiz = "F:/temp/";

    private String diretorioFotos = "fotos";

    private String diretorioVideos = "videos";

    private String diretorioOutros = "outros";

    public boolean salvarFile(MultipartFile file){
        return this.salvar(this.diretorioOutros, file);
    }

    public boolean salvarFoto(MultipartFile foto){
        return this.salvar(this.diretorioFotos, foto);
    }

    public boolean salvarVideo(MultipartFile video){
        return this.salvar(this.diretorioVideos, video);
    }


    public boolean salvar(String diretorio, MultipartFile file){
        Path diretorioPath = Paths.get(this.raiz, diretorio);
        Path arquivoPath = diretorioPath.resolve(file.getOriginalFilename());

        try{
            Files.createDirectories(diretorioPath);
            file.transferTo(arquivoPath.toFile());
            return true;
        } catch (IOException e) {

            System.out.println("Problemas na tentativa de salvar o arquivo: "+ e);

            return false;

        }


    }

}
