package biblioteca.service;


import biblioteca.model.Livro;
import biblioteca.rabbit.LivroProducer;
import biblioteca.repository.LivroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class LivroService {

    @Autowired
    private LivroRepository livroRepository;

    @Autowired
    private LivroProducer livroProducer;

    public Livro sendLivroRabbit(Livro livro){
        livroProducer.send(livro);
        return livro;
    }

    public void save(Livro livro){
        livroRepository.save(livro);
    }
    public List<Livro> findAll(){
        return livroRepository.findAll();
    }
    public Optional<Livro> findById(String id){
        return livroRepository.findById(id);
    }
    public void delete(String id){
        livroRepository.deleteById(id);
    }

    public void deleteAll(){
        livroRepository.deleteAll();
    }
}