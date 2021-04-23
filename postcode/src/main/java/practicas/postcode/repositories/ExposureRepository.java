package practicas.postcode.repositories;

import org.springframework.data.repository.CrudRepository;

import practicas.postcode.entities.ExposureEntity;

public interface ExposureRepository extends CrudRepository<ExposureEntity, Long>{
    
    ExposureEntity findById (long id);


}
