package pch.huellaschile.msgestionveterinarios.domain.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinario;

@Repository
public interface VeterinarioRepository extends MongoRepository<Veterinario, String> {
    Veterinario findByLicenciaProfesional(String licencia);
    Boolean existsVeterinarioByLicenciaProfesionalIgnoreCase(String licencia);
}
