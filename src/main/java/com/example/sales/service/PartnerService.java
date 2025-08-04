package com.example.sales.service;

import com.example.sales.DTO.PartnerEditRequest;
import com.example.sales.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

import com.example.sales.exception.*;
import com.example.sales.model.Partner;


@Service
public class PartnerService {
    @Autowired
    PartnerRepository partnerRepository;

    @Transactional
    public ResponseEntity<String> addPartner(Partner partner) throws PartnerAlreadyExistsException{
        Partner check = partnerRepository.findByName(partner.getName());

        if(check != null) {
            throw new PartnerAlreadyExistsException("Partner already created");
        }

        partnerRepository.save(partner);

        return ResponseEntity.ok("Partner created successfully");
    }

    public ResponseEntity<String> editPartner(PartnerEditRequest partnerEditRequest)
            throws PartnerNotFoundException, PartnerAlreadyExistsException {
        Partner oldPartner = partnerRepository.findByName(partnerEditRequest.getCurrentName());

        if(oldPartner == null) {
            throw new PartnerNotFoundException("Partner not found");
        }

        Partner newPartner = partnerRepository.findByName(partnerEditRequest.getPartner().getName());

        if(newPartner != null && !newPartner.getName().equals(partnerEditRequest.getPartner().getName())) {
            throw new PartnerAlreadyExistsException("Partner already exists");
        }

        BeanUtils.copyProperties(partnerEditRequest.getPartner(), oldPartner, "id");
        oldPartner.setVersion(LocalDateTime.now());

        partnerRepository.save(oldPartner);

        return ResponseEntity.ok("Partner updated successfully");
    }

    @Transactional
    public ResponseEntity<String> deletePartner(String name) throws PartnerNotFoundException {
        Partner check = partnerRepository.findByName(name);

        if(check == null) {
            throw new PartnerNotFoundException("No such partner found");
        }

        partnerRepository.delete(check);

        return ResponseEntity.ok("Partner deleted successfully");
    }

    public List<Partner> getAllPartners() {
        return partnerRepository.findByDeletedFalse();
    }

//    public ResponseEntity<String> changePartnerName(PartnerEditRequest partnerEditRequest)
//            throws PartnerNotFoundException, PartnerAlreadyExistsException {
//
//        Partner oldPartner = partnerRepository.findByName(partnerEditRequest.getCurrentName());
//
//        if(oldPartner == null) {
//            throw new PartnerNotFoundException("Partner not found");
//        }
//
//        Partner check = partnerRepository.findByName(partnerEditRequest.getPartner().getName());
//
//        if(check != null && check.getActive()) {
//            throw new PartnerAlreadyExistsException("Partner already exists or inactive");
//        }
//
//        check = new Partner();
//
//        BeanUtils.copyProperties(partnerEditRequest.getPartner(), check, "id");
//        System.out.println(check.getName());
//
//        oldPartner.setActive(false);
//
//        partnerRepository.save(check);
//        partnerRepository.save(oldPartner);
//
//        return ResponseEntity.ok("Name changed");
//    }
}
