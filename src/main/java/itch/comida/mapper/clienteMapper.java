package itch.comida.mapper;

import itch.comida.dto.clienteDTO;
import itch.comida.entity.Cliente;

public class clienteMapper {
    public static clienteDTO mapToClienteDTO(Cliente cliente) {
        return new clienteDTO(
                cliente.getId(),
                cliente.getNombreCliente(),
                cliente.getTelefono(),
                cliente.getCorreo()
        );
    }

    public static Cliente mapToCliente(clienteDTO clienteDto) {
        Cliente cliente = new Cliente();
        // Copiar el id solo si no es null
        if (clienteDto.getId() != null) {
            cliente.setId(clienteDto.getId());
        }
        cliente.setNombreCliente(clienteDto.getNombreCliente());
        cliente.setTelefono(clienteDto.getTelefono());
        cliente.setCorreo(clienteDto.getCorreo());
        return cliente;
    }
}