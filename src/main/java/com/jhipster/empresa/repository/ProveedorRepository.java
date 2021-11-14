package com.jhipster.empresa.repository;

import com.jhipster.empresa.domain.Proveedor;

import org.springframework.data.jpa.repository.*;
import org.springframework.stereotype.Repository;

/**
 * Spring Data  repository for the Proveedor entity.
 */
@SuppressWarnings("unused")
@Repository
public interface ProveedorRepository extends JpaRepository<Proveedor, Long> {
}
