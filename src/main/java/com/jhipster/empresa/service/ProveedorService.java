package com.jhipster.empresa.service;

import com.jhipster.empresa.domain.Proveedor;
import com.jhipster.empresa.repository.ProveedorRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

/**
 * Service Implementation for managing {@link Proveedor}.
 */
@Service
@Transactional
public class ProveedorService {

    private final Logger log = LoggerFactory.getLogger(ProveedorService.class);

    private final ProveedorRepository proveedorRepository;

    public ProveedorService(ProveedorRepository proveedorRepository) {
        this.proveedorRepository = proveedorRepository;
    }

    /**
     * Save a proveedor.
     *
     * @param proveedor the entity to save.
     * @return the persisted entity.
     */
    public Proveedor save(Proveedor proveedor) {
        log.debug("Request to save Proveedor : {}", proveedor);
        return proveedorRepository.save(proveedor);
    }

    /**
     * Get all the proveedors.
     *
     * @return the list of entities.
     */
    @Transactional(readOnly = true)
    public List<Proveedor> findAll() {
        log.debug("Request to get all Proveedors");
        return proveedorRepository.findAll();
    }


    /**
     * Get one proveedor by id.
     *
     * @param id the id of the entity.
     * @return the entity.
     */
    @Transactional(readOnly = true)
    public Optional<Proveedor> findOne(Long id) {
        log.debug("Request to get Proveedor : {}", id);
        return proveedorRepository.findById(id);
    }

    /**
     * Delete the proveedor by id.
     *
     * @param id the id of the entity.
     */
    public void delete(Long id) {
        log.debug("Request to delete Proveedor : {}", id);
        proveedorRepository.deleteById(id);
    }
}
