package itch.comida.service.Imp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import itch.comida.dto.clienteDTO;
import itch.comida.entity.Cliente;
import itch.comida.mapper.clienteMapper;
import itch.comida.repository.clienteRepository;
import itch.comida.service.clienteService;
import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class clienteServiceImp implements clienteService {

    private clienteRepository clienteRepository;

    @Override
    public clienteDTO createCliente(clienteDTO clienteDto) {
        Cliente cliente = clienteMapper.mapToCliente(clienteDto);
        Cliente savedCliente = clienteRepository.save(cliente);
        return clienteMapper.mapToClienteDTO(savedCliente);
    }

    @Override
    public clienteDTO getClienteById(Integer id) {
        Cliente cliente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
        return clienteMapper.mapToClienteDTO(cliente);
    }

    @Override
    public List<clienteDTO> getAllCliente() {
        List<Cliente> clientes = clienteRepository.findAll();
        return clientes.stream()
                .map(clienteMapper::mapToClienteDTO)
                .collect(Collectors.toList());
    }

    @Override
    public clienteDTO updateCliente(Integer id, clienteDTO clienteDto) {
        Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
        
        // Actualizar solo campos necesarios
        clienteExistente.setNombreCliente(clienteDto.getNombreCliente());
        clienteExistente.setTelefono(clienteDto.getTelefono());
        clienteExistente.setCorreo(clienteDto.getCorreo());

        Cliente clienteActualizado = clienteRepository.save(clienteExistente);
        return clienteMapper.mapToClienteDTO(clienteActualizado);
    }

    @Override
    public void deleteCliente(Integer id) {
        Cliente clienteExistente = clienteRepository.findById(id)
            .orElseThrow(() -> new RuntimeException("Cliente no encontrado con id " + id));
        clienteRepository.delete(clienteExistente);
    }
    
    @Override
    public boolean existsById(Integer id) {
        return clienteRepository.existsById(id);
    }

}