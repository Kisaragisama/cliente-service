package itch.comida.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import itch.comida.entity.Cliente;

public interface clienteRepository extends JpaRepository<Cliente, Integer> {

}