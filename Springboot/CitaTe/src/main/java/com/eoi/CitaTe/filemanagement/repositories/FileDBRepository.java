package com.eoi.CitaTe.filemanagement.repositories;



import com.eoi.CitaTe.filemanagement.entities.FileDB;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * The interface File db repository.
 */
@Repository
public interface FileDBRepository extends JpaRepository<FileDB, String> {



}
