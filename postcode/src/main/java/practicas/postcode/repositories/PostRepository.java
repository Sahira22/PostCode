package practicas.postcode.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;

import practicas.postcode.entities.PostEntity;
// PagingAndSortingRepository esta clase nos permite ademas de un CRUD ordener los datos, aqui podemos ordenar por fecha o cualquier otro campo
public interface PostRepository extends PagingAndSortingRepository<PostEntity, Long>{
    List<PostEntity> getByUserIdOrderByCreatedAtDesc(long userId);

    
    @Query(value = "SELECT * FROM posts p WHERE p.exposure_id = :exposure and p.expires_at > :now ORDER BY created_at DESC LIMIT 20", nativeQuery = true)
    List<PostEntity> getLastPublicPosts(@Param("exposure") long exposureId, @Param("now") Date now);

    PostEntity findByPostId(String postId);
}
