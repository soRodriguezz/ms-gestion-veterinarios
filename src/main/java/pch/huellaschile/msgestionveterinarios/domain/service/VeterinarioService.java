package pch.huellaschile.msgestionveterinarios.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msgestionveterinarios.domain.model.dto.RequestVeterinarioDTO;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinario;
import pch.huellaschile.msgestionveterinarios.domain.repository.VeterinarioRepository;

import java.util.List;

@Service
public class VeterinarioService {

    @Autowired
    private VeterinarioRepository repository;

    public Veterinario createVeterinario(Veterinario veterinario) {

        boolean exist = repository.existsVeterinarioByLicenciaProfesionalIgnoreCase(veterinario.getLicenciaProfesional());

        if(exist) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario con licencia profesional existe");
        }

        return repository.save(veterinario);
    }

    public List<Veterinario> findAll() {
        return repository.findAll();
    }

    public Veterinario findByLicencia(String licencia) {
        return repository.findByLicenciaProfesional(licencia);
    }

    public void delete(String licencia) {
        Veterinario veterinario = repository.findByLicenciaProfesional(licencia);

        if(veterinario == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe");
        }

        repository.delete(veterinario);
    }

    public Veterinario update(String licencia, RequestVeterinarioDTO dto) {

        Veterinario veterinario = repository.findByLicenciaProfesional(licencia);

        if(veterinario == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Usuario no existe");
        }

        Veterinario veterinario1 = new Veterinario();

        veterinario1.setApellido(dto.getApellido());
        veterinario1.setIdVeterinario(veterinario.getIdVeterinario());
        veterinario1.setLicenciaProfesional(veterinario.getLicenciaProfesional());
        veterinario1.setNombre(dto.getNombre());

        return repository.save(veterinario1);
    }

}
