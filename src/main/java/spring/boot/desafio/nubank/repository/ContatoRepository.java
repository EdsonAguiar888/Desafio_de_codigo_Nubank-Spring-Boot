package spring.boot.desafio.nubank.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.boot.desafio.nubank.model.Contato;

public interface ContatoRepository extends JpaRepository<Contato, Long> {


}
