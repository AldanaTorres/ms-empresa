package com.jhipster.empresa.domain;


import javax.persistence.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

/**
 * A Empresa.
 */
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre")
    private String nombre;

    @Column(name = "direccion")
    private String direccion;

    @Column(name = "c_uit")
    private Integer cUIT;

    @Column(name = "telefono")
    private Integer telefono;

    @OneToMany(mappedBy = "empresa")
    private Set<Cliente> clientes = new HashSet<>();

    // jhipster-needle-entity-add-field - JHipster will add fields here
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public Empresa nombre(String nombre) {
        this.nombre = nombre;
        return this;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public Empresa direccion(String direccion) {
        this.direccion = direccion;
        return this;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Integer getcUIT() {
        return cUIT;
    }

    public Empresa cUIT(Integer cUIT) {
        this.cUIT = cUIT;
        return this;
    }

    public void setcUIT(Integer cUIT) {
        this.cUIT = cUIT;
    }

    public Integer getTelefono() {
        return telefono;
    }

    public Empresa telefono(Integer telefono) {
        this.telefono = telefono;
        return this;
    }

    public void setTelefono(Integer telefono) {
        this.telefono = telefono;
    }

    public Set<Cliente> getClientes() {
        return clientes;
    }

    public Empresa clientes(Set<Cliente> clientes) {
        this.clientes = clientes;
        return this;
    }

    public Empresa addCliente(Cliente cliente) {
        this.clientes.add(cliente);
        cliente.setEmpresa(this);
        return this;
    }

    public Empresa removeCliente(Cliente cliente) {
        this.clientes.remove(cliente);
        cliente.setEmpresa(null);
        return this;
    }

    public void setClientes(Set<Cliente> clientes) {
        this.clientes = clientes;
    }
    // jhipster-needle-entity-add-getters-setters - JHipster will add getters and setters here

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof Empresa)) {
            return false;
        }
        return id != null && id.equals(((Empresa) o).id);
    }

    @Override
    public int hashCode() {
        return 31;
    }

    // prettier-ignore
    @Override
    public String toString() {
        return "Empresa{" +
            "id=" + getId() +
            ", nombre='" + getNombre() + "'" +
            ", direccion='" + getDireccion() + "'" +
            ", cUIT=" + getcUIT() +
            ", telefono=" + getTelefono() +
            "}";
    }
}
