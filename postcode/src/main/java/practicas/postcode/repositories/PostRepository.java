package practicas.postcode.repositories;

import java.util.List;


import org.springframework.data.repository.PagingAndSortingRepository;

import practicas.postcode.entities.PostEntity;
// PagingAndSortingRepository esta clase nos permite ademas de un CRUD ordener los datos, aqui podemos ordenar por fecha o cualquier otro campo
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long>{
    List<PostEntity> getByUserIdOrderByCreatedAtDesc(long userId);
}
