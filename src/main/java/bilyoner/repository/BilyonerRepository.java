package bilyoner.repository;

import bilyoner.document.Bilyoner;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BilyonerRepository extends MongoRepository<Bilyoner, Long> {

    Optional<Bilyoner> findById(Long id);

    Bilyoner findFirstByOrderByIdDesc();

    Bilyoner findFirstByOrderById();

    List<Bilyoner> findAllByOrderById();

    List<Bilyoner> findAllByOrderByIdDesc();
}
