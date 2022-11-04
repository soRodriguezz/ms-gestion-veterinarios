package pch.huellaschile.msgestionveterinarios.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pch.huellaschile.msgestionveterinarios.domain.model.dto.RequestVeterinarioDTO;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinario;
import pch.huellaschile.msgestionveterinarios.domain.service.VeterinarioService;

import java.util.List;

@RestController
@RequestMapping("/veterinario")
public class VeterinarioController {

    @Autowired
    private VeterinarioService service;

    @PostMapping("/")
    public ResponseEntity<Veterinario> agregarConsulta(@RequestBody Veterinario veterinario) {
        Veterinario vet = service.createVeterinario(veterinario);
        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veterinario>> listarVeterinarios() {
        List<Veterinario> veterinarios = service.findAll();
        return new ResponseEntity<>(veterinarios, HttpStatus.OK);
    }

    @GetMapping("/{licencia}")
    public ResponseEntity<Veterinario> obtenerVeterinario(@PathVariable String licencia) {
        Veterinario veterinario = service.findByLicencia(licencia);
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    @PutMapping("/update/{licencia}")
    public ResponseEntity<Veterinario> updateVeterinario(@PathVariable String licencia, @RequestBody RequestVeterinarioDTO dto) {
        Veterinario veterinario = service.update(licencia, dto);
        return new ResponseEntity<>(veterinario, HttpStatus.OK);
    }

    @DeleteMapping("{licencia}")
    public ResponseEntity<Object> deleteVeterinario(@PathVariable String licencia){
        service.delete(licencia);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
