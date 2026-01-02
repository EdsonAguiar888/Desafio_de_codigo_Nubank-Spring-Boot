package spring.boot.desafio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

//@Getter
//@Setter
//@NoArgsConstructor
//@AllArgsConstructor


public class ContatoResponseDTO {


    private Long id;
    private String telefone;
    private String email;
    private Long clienteId;


    public ContatoResponseDTO() {
    }


    public ContatoResponseDTO(Long id, String telefone, String email, Long clienteId) {
        this.id = id;
        this.telefone = telefone;
        this.email = email;
        this.clienteId = clienteId;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getClienteId() {
        return clienteId;
    }

    public void setClienteId(Long clienteId) {
        this.clienteId = clienteId;
    }


}
