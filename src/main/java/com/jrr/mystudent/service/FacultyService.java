package com.jrr.mystudent.service;

import com.jrr.mystudent.domain.Faculty;
import com.jrr.mystudent.repository.FacultyRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.List;

/**
 * Service Implementation for managing Faculty.
 */
@Service
@Transactional
public class FacultyService {

    private final Logger log = LoggerFactory.getLogger(FacultyService.class);
    
    @Inject
    private FacultyRepository facultyRepository;

    /**
     * Save a faculty.
     *
     * @param faculty the entity to save
     * @return the persisted entity
     */
    public Faculty save(Faculty faculty) {
        log.debug("Request to save Faculty : {}", faculty);
        Faculty result = facultyRepository.save(faculty);
        return result;
    }

    /**
     *  Get all the faculties.
     *  
     *  @return the list of entities
     */
    @Transactional(readOnly = true) 
    public List<Faculty> findAll() {
        log.debug("Request to get all Faculties");
        List<Faculty> result = facultyRepository.findAll();

        return result;
    }

    /**
     *  Get one faculty by id.
     *
     *  @param id the id of the entity
     *  @return the entity
     */
    @Transactional(readOnly = true) 
    public Faculty findOne(Long id) {
        log.debug("Request to get Faculty : {}", id);
        Faculty faculty = facultyRepository.findOne(id);
        return faculty;
    }

    /**
     *  Delete the  faculty by id.
     *
     *  @param id the id of the entity
     */
    public void delete(Long id) {
        log.debug("Request to delete Faculty : {}", id);
        facultyRepository.delete(id);
    }
}
