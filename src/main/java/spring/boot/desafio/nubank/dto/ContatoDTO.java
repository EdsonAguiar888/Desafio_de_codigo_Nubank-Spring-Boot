package spring.boot.desafio.nubank.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Service;

//@Setter
//@Getter
//@AllArgsConstructor
//@NoArgsConstructor

public class ContatoDTO {

    private String telefone;
    private String email;
    private Long clienteId;

    public String getTelefone() {
        return telefone;
    }

    public ContatoDTO(String telefone, String email, Long clienteId) {
        this.telefone = telefone;
        this.email = email;
        this.clienteId = clienteId;
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
