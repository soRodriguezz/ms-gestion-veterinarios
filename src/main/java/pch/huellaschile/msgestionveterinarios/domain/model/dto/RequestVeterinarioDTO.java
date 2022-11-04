package pch.huellaschile.msgestionveterinarios.domain.model.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RequestVeterinarioDTO {
    private String idVeterinario;
    private String licenciaProfesional;
    private String nombre;
    private String apellido;
}
