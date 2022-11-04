package pch.huellaschile.msgestionveterinarios.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinaria;

@Repository
public interface VeterinariaRepository extends MongoRepository<Veterinaria, String> {

    Veterinaria findByRegistroNacionalIgnoreCase(String registro);

    Boolean existsVeterinarioByRegistroNacionalIgnoreCase(String registro);
}
