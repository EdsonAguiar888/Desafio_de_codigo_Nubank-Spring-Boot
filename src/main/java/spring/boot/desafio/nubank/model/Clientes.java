package spring.boot.desafio.nubank.model;

import java.util.ArrayList;
import java.util.List;

import ch.qos.logback.core.joran.spi.NoAutoStart;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity

//@Getter
//@Setter
//@AllArgsConstructor
//@NoArgsConstructor

 public class Clientes {

     @Id
     @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Long id;
     
     private String nome;
     
     @OneToMany(mappedBy = "clientes", cascade = CascadeType.ALL, orphanRemoval = true)
     @JsonManagedReference
    
     private List<Contato> contatos = new ArrayList<Contato>();
     
     
    //Constructors 

     public Clientes() {
    }
    
    public Clientes(Long id, String nome, List<Object> contatos) {
        this.id = id;
        this.nome = nome;
        this.contatos = contatos;
    }


    //Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Object> getContatos() {
        return contatos;
    }

    public void setContatos(List<Object> contatos) {
        this.contatos = contatos;
    }





}

