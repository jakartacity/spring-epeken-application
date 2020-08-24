package com.epeken.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.epeken.model.LicKeyTbl;

//Repository of LicKeyTbl with Id Type is String.
public interface LicKeyTblRepository extends JpaRepository<LicKeyTbl, String> {
	
}
