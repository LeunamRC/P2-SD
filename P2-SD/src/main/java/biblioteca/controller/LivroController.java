package biblioteca.controller;


import biblioteca.constant.Constants;
import biblioteca.model.Livro;
import biblioteca.service.LivroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;
import java.util.Optional;

@RestController
public class LivroController {

    @Autowired
    private LivroService livroService;

    @PostMapping(Constants.API_LIVRO)
    public void save(@RequestBody Livro livro){
        livroService.sendLivroRabbit(livro);
    }

    @GetMapping(Constants.API_LIVRO)
    public List<Livro> findAll(){
        return livroService.findAll();
    }

    @PutMapping(Constants.API_LIVRO)
    public void update(@RequestBody Livro livro){
        livroService.save(livro);
    }

    @DeleteMapping(Constants.API_LIVRO + "/{id}")
    public void delete(@PathVariable("id") String id){
        livroService.delete(id);
    }

    @GetMapping(Constants.API_LIVRO + "/{id}")
    public Optional<Livro> findById(@PathVariable("id") String id){
        return livroService.findById(id);
    }
}
