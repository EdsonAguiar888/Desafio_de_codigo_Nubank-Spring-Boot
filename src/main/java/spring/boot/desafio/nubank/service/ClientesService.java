package spring.boot.desafio.nubank.service;



import lombok.Getter;
import lombok.Setter;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import spring.boot.desafio.nubank.dto.ClientesDTO;
import spring.boot.desafio.nubank.dto.ClientesResponseDTO;
import spring.boot.desafio.nubank.dto.ContatoResponseDTO;
import spring.boot.desafio.nubank.model.Clientes;
import spring.boot.desafio.nubank.model.Contato;
import spring.boot.desafio.nubank.repository.ClientesRepository;

import java.util.List;
import java.util.function.LongToDoubleFunction;
import java.util.stream.Collectors;

@Service



public class ClientesService {

    private ClientesRepository clientesRepository;

    public Clientes salvarCliente(ClientesDTO dto){
        Clientes clientes = new Clientes();
        clientes.setNome(dto.getNome());

        if (dto.getContatos() != null && dto.getContatos().size() > 0){

            List<Contato> contatos = dto.getContatos().stream().map(c ->{
                Contato contato = new Contato();
                contato.setTelefone(c.getTelefone());
                contato.setEmail(c.getEmail());
                contato.setClientes(clientes);
                return contato;
            }).collect(Collectors.toList());
        }
        return clientesRepository.save(clientes);
    }

    public List<ClientesResponseDTO> listarTodos(){
        return clientesRepository.findAll().stream().map(this::toDTO)
                .collect(Collectors.toList());

    }

    public List<ContatoResponseDTO> listarContatosPorCliente(Long clienteId){

        Clientes cliente = clientesRepository.findById(clienteId)
                .orElseThrow( () -> new RuntimeException("Cliente nao encontrado"));

        return cliente.getContatos().stream().map( c -> {
            ContatoResponseDTO dto = new ContatoResponseDTO();
            dto.setId(c.getId());
            dto.setTelefone(c.getTelefone());
            dto.setEmail(c.getEmail());
            return dto;
        }).collect(Collectors.toList());


    }



    private ClientesResponseDTO toDTO(Clientes cliente){
        ClientesResponseDTO dto = new ClientesResponseDTO();
        dto.setId(cliente.getId());
        dto.setNome(cliente.getNome());

        List<ContatoResponseDTO> contatos = cliente.getContatos().stream().map(c ->{
            ContatoResponseDTO contatoDTO = new ContatoResponseDTO();
            contatoDTO.setId(c.getId());
            contatoDTO.setTelefone(c.getTelefone());
            contatoDTO.setEmail(c.getEmail());
            return contatoDTO;
        }).collect(Collectors.toList());

        return dto;


    }

}
