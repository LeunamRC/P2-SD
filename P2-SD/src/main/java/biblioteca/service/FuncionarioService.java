package biblioteca.service;


import biblioteca.model.Funcionario;
import biblioteca.rabbit.FuncionarioProducer;
import biblioteca.repository.FuncionarioRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FuncionarioService {

    @Autowired
    private FuncionarioRepository funcionarioRepository;

    @Autowired
    private FuncionarioProducer funcionarioProducer;

    public Funcionario sendFuncionarioRabbit(Funcionario funcionario){
        funcionarioProducer.send(funcionario);
        return funcionario;
    }

    public void save(Funcionario funcionario){
        funcionarioRepository.save(funcionario);
    }
    public List<Funcionario> findAll(){
        return funcionarioRepository.findAll();
    }

   public Optional<Funcionario> findById(String Id) {
        return funcionarioRepository.findById(Integer.parseInt(Id));
    }

    public void delete(String Id) {
        funcionarioRepository.deleteById(Integer.parseInt(Id));
    }

    public void deleteAll(){
        funcionarioRepository.deleteAll();
    }
}