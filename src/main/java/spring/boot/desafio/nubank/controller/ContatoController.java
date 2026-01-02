package spring.boot.desafio.nubank.controller;


import com.sun.net.httpserver.HttpsConfigurator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import spring.boot.desafio.nubank.dto.ContatoDTO;
import spring.boot.desafio.nubank.model.Clientes;
import spring.boot.desafio.nubank.model.Contato;
import spring.boot.desafio.nubank.repository.ClientesRepository;
import spring.boot.desafio.nubank.repository.ContatoRepository;

import java.util.Objects;
import java.util.Optional;

@RestController
@RequestMapping
public class ContatoController {

    @Autowired
    private ContatoRepository contatoRepository;

    @Autowired
    private ClientesRepository clientesRepository;



    public ResponseEntity<?> Criar(@RequestBody ContatoDTO dto){

        Optional<Clientes> clientesOpt = clientesRepository.findById(dto.getClienteId());
        if (clientesOpt.isPresent()){
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Cliente nao encontrado");
        }
        Contato contato = new Contato();

        contato.setClientes(clientesOpt.get());
        contato.setEmail(dto.getEmail());
        contato.setTelefone(dto.getTelefone());

        contatoRepository.save(contato);

        return ResponseEntity.status(HttpStatus.CREATED).body(contato);
    }


}
