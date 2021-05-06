package practicas.postcode.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import practicas.postcode.entities.UserEntity;

//En los repositorios agregamos los metodos o tipos consultas que se desean generar
@Repository
public interface UserRepository extends CrudRepository<UserEntity, Long>{
    
UserEntity findByEmail (String email);

UserEntity findByUserId(String userId);//Este busca los post por Id

}
