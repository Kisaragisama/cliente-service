package itch.comida.service;

import java.util.List;
import itch.comida.dto.clienteDTO;

public interface clienteService {
    clienteDTO createCliente(clienteDTO clienteDto);

    clienteDTO getClienteById(Integer id);

    List<clienteDTO> getAllCliente();

    clienteDTO updateCliente(Integer id, clienteDTO clienteDto);

    void deleteCliente(Integer id);
    
    boolean existsById(Integer id);

}
