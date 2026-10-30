package br.com._denao4de.GostosurasDaKarla.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com._denao4de.GostosurasDaKarla.model.Pagamento;

public interface PagamentoRepository extends JpaRepository < Pagamento, Long > {
    
}
