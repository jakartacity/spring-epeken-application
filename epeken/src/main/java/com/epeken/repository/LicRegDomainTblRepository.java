package com.epeken.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.epeken.model.LicRegDomainTbl;

//Repository of LicRegDomainTbl with Id Type is String (License Key).
public interface LicRegDomainTblRepository extends JpaRepository<LicRegDomainTbl, String>{

}
