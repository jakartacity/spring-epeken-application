package com.epeken.controller;

import java.util.ArrayList;
import java.util.Date;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Optional;

import org.slf4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.epeken.model.LicKeyTbl;
import com.epeken.model.LicRegDomainTbl;
import com.epeken.repository.LicKeyTblRepository;
import com.epeken.repository.LicRegDomainTblRepository;


@RestController
@RequestMapping("/api")
public class LicKeyTblController {
	
	@Autowired
	LicKeyTblRepository licKeyTblRepo;
	
	@Autowired 
	LicRegDomainTblRepository licRegDomainTblRepo;
	
	private static final org.slf4j.Logger log = 
		    org.slf4j.LoggerFactory.getLogger(LicKeyTblController.class);
	
	@GetMapping("/license/info/{license_key}")
	public String getLicenseInfo(@PathVariable(value="license_key") String licenseKey) {
		log.info("/license/info/"+licenseKey);
		LicKeyTbl lickey = null;
		LicRegDomainTbl regDomain = null;
		try {
				lickey = licKeyTblRepo.findById(licenseKey).get();
				ArrayList<String> list = new ArrayList<String>();
				list.add(licenseKey);
				regDomain = (LicRegDomainTbl)licRegDomainTblRepo.findAllById(list).get(0);
		}catch(Exception e) {
			log.warn("/license/info/"+licenseKey+" nothing returned.");
		}
		
		if (lickey == null)
			return "{\"status\":401,\"message\":\"License key is not found.\"}";
		
		String domain = "";
		if (regDomain != null)
			domain = regDomain.getRegisteredDomain();

		String s = "{\"status\":200,\"message\":\"ok\",\"license_key\":\""+lickey.getLicenseKey()+"\", "
				+ "\"website\":\""+domain+"\",\"dateexpiry\":\""+lickey.getDateExpiry()+"\"}";
		return s;
	}
	
	@PostMapping("/license/activate")
	public String update (
			@RequestParam("license_key") String licenseKey,
			@RequestParam("registered_domain") String registeredDomain,
			@RequestParam("item_reference") String itemReference
			) {
		
		Optional<LicKeyTbl> l = licKeyTblRepo.findById(licenseKey);
		LicKeyTbl lickey = null;
		if(l != null) {
			lickey = l.get();
		}else {
			return "{\"status\":401,\"message\":\"License key is not found.\"}";
		}
		
		if(lickey.getLicStatus().equals("active")) {
		    Optional<LicRegDomainTbl> o = licRegDomainTblRepo.findById(licenseKey);
		    LicRegDomainTbl reg = null;
		    String regDomain = "";
		    if(o != null) {
		    	reg = o.get();
		    	regDomain = reg.getRegisteredDomain();
		    }
			return "{\"status\":401,\"message\":\"License is already active on " + regDomain + ".\"}";
		}
		
		lickey.setLicStatus("active");
		String lastActivated = lickey.getLastActivated();
		if (lastActivated == null) {
			DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
			Date date = new Date();
			lickey.setLastActivated(dateFormat.format(date));
		}
		LicRegDomainTbl licRegDomainTbl = new LicRegDomainTbl();
		licRegDomainTbl.setLicKey(licenseKey);
		licRegDomainTbl.setLicKeyId(lickey.getId());
		licRegDomainTbl.setRegisteredDomain(registeredDomain);
		licRegDomainTbl.setItemReference(itemReference);
		licRegDomainTblRepo.save(licRegDomainTbl);
		licKeyTblRepo.save(lickey);
		log.info("/license/activate "+licenseKey+" was activated successfully on "+ registeredDomain);
		return "{\"status\":200,\"message\":\"License key " + licenseKey + " is successfully activated on " + registeredDomain+".\"}";
	}
}
