package pch.huellaschile.msgestionveterinarios.domain.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import pch.huellaschile.msgestionveterinarios.common.exception.VeterinariaExistException;
import pch.huellaschile.msgestionveterinarios.common.exception.VeterinarioNotExistException;
import pch.huellaschile.msgestionveterinarios.domain.model.dto.RequestVeterinariaDTO;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinaria;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinario;
import pch.huellaschile.msgestionveterinarios.domain.repository.VeterinariaRepository;
import pch.huellaschile.msgestionveterinarios.domain.repository.VeterinarioRepository;

import java.util.List;

@Service
public class VeterinariaService {

    @Autowired
    private VeterinariaRepository repository;

    @Autowired
    private VeterinarioRepository repositoryVet;

    public List<Veterinaria> findAll() {
        return repository.findAll();
    }

    public Veterinaria findByRegistro(String registro) {
        return repository.findByRegistroNacionalIgnoreCase(registro);
    }

    public Veterinaria createVeterinaria(Veterinaria vet) throws VeterinarioNotExistException, VeterinariaExistException {

        Veterinario veterinario = repositoryVet.findByLicenciaProfesional(vet.getLicenciaProfesional());
        Object[] args = {vet};

        if(veterinario == null) {
            throw new VeterinarioNotExistException("veterinario.notexist.message", args);
        }

        vet.setVeterinario(veterinario);

        boolean exist = repository.existsVeterinarioByRegistroNacionalIgnoreCase(vet.getRegistroNacional());

        if(exist) {
            throw new VeterinariaExistException("veterinaria.exist.message", args);
        }

        return repository.save(vet);
    }


    public Veterinaria updateVeterinaria(String registro, RequestVeterinariaDTO dto) {

        Veterinario veterinario = repositoryVet.findByLicenciaProfesional(dto.getLicenciaProfesional());

        if(veterinario == null) {
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veterinario no existe");
        }

        Veterinaria veterinaria = repository.findByRegistroNacionalIgnoreCase(registro);

        if(veterinaria == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veterinaria no existe");
        }

        Veterinaria veterinaria1 = new Veterinaria();

        veterinaria1.setNombre(dto.getNombre());
        veterinaria1.setRegistroNacional(veterinaria.getRegistroNacional());
        veterinaria1.setIdVeterinaria(veterinaria.getIdVeterinaria());
        veterinaria1.setVeterinario(veterinario);
        veterinaria1.setEstaCertificado(dto.getEstaCertificado());
        veterinaria1.setLicenciaProfesional(dto.getLicenciaProfesional());

        return repository.save(veterinaria1);
    }

    public void deleteVeterinaria(String registro) {
        Veterinaria veterinaria = repository.findByRegistroNacionalIgnoreCase(registro);

        if(veterinaria == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Veterinaria no existe");
        }

        repository.delete(veterinaria);
    }

}
