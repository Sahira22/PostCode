package practicas.postcode.repositories;

import org.springframework.data.repository.CrudRepository;

import practicas.postcode.entities.PostEntity;

public interface PostRepository extends CrudRepository<PostEntity, Long>{
    
}
