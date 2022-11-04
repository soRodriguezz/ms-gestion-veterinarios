package pch.huellaschile.msgestionveterinarios.domain.model.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document("veterinario")
public class Veterinario {

    @Id
    private String idVeterinario;
    private String licenciaProfesional;
    private String nombre;
    private String apellido;

    public Veterinario(String idVeterinario, String licenciaProfesional, String nombre, String apellido) {
        this.idVeterinario = idVeterinario;
        this.licenciaProfesional = licenciaProfesional;
        this.nombre = nombre;
        this.apellido = apellido;
    }

    public Veterinario() {

    }

    public String getIdVeterinario() {
        return idVeterinario;
    }

    public void setIdVeterinario(String idVeterinario) {
        this.idVeterinario = idVeterinario;
    }

    public String getLicenciaProfesional() {
        return licenciaProfesional;
    }

    public void setLicenciaProfesional(String licenciaProfesional) {
        this.licenciaProfesional = licenciaProfesional;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }
}
