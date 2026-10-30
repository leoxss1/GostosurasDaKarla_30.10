package br.com._denao4de.GostosurasDaKarla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com._denao4de.GostosurasDaKarla.model.Pedido;

public interface PedidoRepository extends JpaRepository < Pedido,Long > {
    
}
