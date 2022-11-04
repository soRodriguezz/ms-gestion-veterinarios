package pch.huellaschile.msgestionveterinarios.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pch.huellaschile.msgestionveterinarios.domain.model.dto.RequestVeterinariaDTO;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinaria;
import pch.huellaschile.msgestionveterinarios.domain.service.VeterinariaService;

import java.util.List;

@RestController
@RequestMapping("/veterinaria")
public class VeterinariaController {

    @Autowired
    private VeterinariaService service;

    @PostMapping("/")
    public ResponseEntity<Veterinaria> agregarConsulta(@RequestBody Veterinaria veterinaria) {
        Veterinaria vet = service.createVeterinaria(veterinaria);
        return new ResponseEntity<>(vet, HttpStatus.OK);
    }

    @GetMapping("/all")
    public ResponseEntity<List<Veterinaria>> listarVeterinarias() {
        List<Veterinaria> veterinarias = service.findAll();
        return new ResponseEntity<>(veterinarias, HttpStatus.OK);
    }

    @GetMapping("/{registro}")
    public ResponseEntity<Veterinaria> obtenerVeterinaria(@PathVariable String registro) {
        Veterinaria veterinaria = service.findByRegistro(registro);
        return new ResponseEntity<>(veterinaria, HttpStatus.OK);
    }

    @PutMapping("/{registro}")
    public ResponseEntity<Veterinaria> editarVeterinaria(@PathVariable String registro, @RequestBody RequestVeterinariaDTO dto) {
        Veterinaria veterinaria = service.updateVeterinaria(registro, dto);
        return new ResponseEntity<>(veterinaria, HttpStatus.OK);
    }

    @DeleteMapping("{registro}")
    public ResponseEntity<Object> deleteVeterinaria(@PathVariable String registro){
        service.deleteVeterinaria(registro);
        return new ResponseEntity<>(HttpStatus.OK);
    }


}
