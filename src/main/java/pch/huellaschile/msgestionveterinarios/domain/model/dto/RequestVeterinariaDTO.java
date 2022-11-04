package pch.huellaschile.msgestionveterinarios.domain.model.dto;

import lombok.Getter;
import lombok.Setter;
import pch.huellaschile.msgestionveterinarios.domain.model.entity.Veterinario;

@Getter
@Setter
public class RequestVeterinariaDTO {
        private String idVeterinaria;
        private String registroNacional;
        private String nombre;
        private Boolean estaCertificado;
        private String licenciaProfesional;
        private Veterinario veterinario;
}
