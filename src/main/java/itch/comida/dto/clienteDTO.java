package itch.comida.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class clienteDTO {

    private Integer id;

    @NotBlank(message = "El nombre no puede estar vacío")
    private String nombreCliente;

    @NotBlank(message = "El teléfono no puede estar vacío")
    @Size(min = 10, max = 10, message = "El teléfono debe tener exactamente 10 dígitos")
    @Pattern(regexp = "\\d+", message = "El teléfono solo puede contener números")
    private String telefono;

    @NotBlank(message = "El correo no puede estar vacío")
    private String correo;
}