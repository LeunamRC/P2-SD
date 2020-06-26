package biblioteca.repository;

import biblioteca.model.Livro;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface LivroRepository extends MongoRepository<Livro, String> {
}
