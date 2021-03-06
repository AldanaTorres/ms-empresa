package com.jhipster.empresa.web.rest;

import com.jhipster.empresa.domain.Proveedor;
import com.jhipster.empresa.service.ProveedorService;
import com.jhipster.empresa.web.rest.errors.BadRequestAlertException;

import io.github.jhipster.web.util.HeaderUtil;
import io.github.jhipster.web.util.ResponseUtil;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

/**
 * REST controller for managing {@link com.jhipster.empresa.domain.Proveedor}.
 */
@RestController
@RequestMapping("/api")
public class ProveedorResource {

    private final Logger log = LoggerFactory.getLogger(ProveedorResource.class);

    private static final String ENTITY_NAME = "empresaProveedor";

    @Value("${jhipster.clientApp.name}")
    private String applicationName;

    private final ProveedorService proveedorService;

    public ProveedorResource(ProveedorService proveedorService) {
        this.proveedorService = proveedorService;
    }

    /**
     * {@code POST  /proveedors} : Create a new proveedor.
     *
     * @param proveedor the proveedor to create.
     * @return the {@link ResponseEntity} with status {@code 201 (Created)} and with body the new proveedor, or with status {@code 400 (Bad Request)} if the proveedor has already an ID.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PostMapping("/proveedors")
    public ResponseEntity<Proveedor> createProveedor(@Valid @RequestBody Proveedor proveedor) throws URISyntaxException {
        log.debug("REST request to save Proveedor : {}", proveedor);
        if (proveedor.getId() != null) {
            throw new BadRequestAlertException("A new proveedor cannot already have an ID", ENTITY_NAME, "idexists");
        }
        Proveedor result = proveedorService.save(proveedor);
        return ResponseEntity.created(new URI("/api/proveedors/" + result.getId()))
            .headers(HeaderUtil.createEntityCreationAlert(applicationName, true, ENTITY_NAME, result.getId().toString()))
            .body(result);
    }

    /**
     * {@code PUT  /proveedors} : Updates an existing proveedor.
     *
     * @param proveedor the proveedor to update.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the updated proveedor,
     * or with status {@code 400 (Bad Request)} if the proveedor is not valid,
     * or with status {@code 500 (Internal Server Error)} if the proveedor couldn't be updated.
     * @throws URISyntaxException if the Location URI syntax is incorrect.
     */
    @PutMapping("/proveedors")
    public ResponseEntity<Proveedor> updateProveedor(@Valid @RequestBody Proveedor proveedor) throws URISyntaxException {
        log.debug("REST request to update Proveedor : {}", proveedor);
        if (proveedor.getId() == null) {
            throw new BadRequestAlertException("Invalid id", ENTITY_NAME, "idnull");
        }
        Proveedor result = proveedorService.save(proveedor);
        return ResponseEntity.ok()
            .headers(HeaderUtil.createEntityUpdateAlert(applicationName, true, ENTITY_NAME, proveedor.getId().toString()))
            .body(result);
    }

    /**
     * {@code GET  /proveedors} : get all the proveedors.
     *
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and the list of proveedors in body.
     */
    @GetMapping("/proveedors")
    public List<Proveedor> getAllProveedors() {
        log.debug("REST request to get all Proveedors");
        return proveedorService.findAll();
    }

    /**
     * {@code GET  /proveedors/:id} : get the "id" proveedor.
     *
     * @param id the id of the proveedor to retrieve.
     * @return the {@link ResponseEntity} with status {@code 200 (OK)} and with body the proveedor, or with status {@code 404 (Not Found)}.
     */
    @GetMapping("/proveedors/{id}")
    public ResponseEntity<Proveedor> getProveedor(@PathVariable Long id) {
        log.debug("REST request to get Proveedor : {}", id);
        Optional<Proveedor> proveedor = proveedorService.findOne(id);
        return ResponseUtil.wrapOrNotFound(proveedor);
    }

    /**
     * {@code DELETE  /proveedors/:id} : delete the "id" proveedor.
     *
     * @param id the id of the proveedor to delete.
     * @return the {@link ResponseEntity} with status {@code 204 (NO_CONTENT)}.
     */
    @DeleteMapping("/proveedors/{id}")
    public ResponseEntity<Void> deleteProveedor(@PathVariable Long id) {
        log.debug("REST request to delete Proveedor : {}", id);
        proveedorService.delete(id);
        return ResponseEntity.noContent().headers(HeaderUtil.createEntityDeletionAlert(applicationName, true, ENTITY_NAME, id.toString())).build();
    }
}
