package com.example.sales.service;

import com.example.sales.DTO.PartnerEditRequest;
import com.example.sales.repository.PartnerRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import java.util.List;

import com.example.sales.exception.*;
import com.example.sales.model.Partner;


@Service
public class PartnerService {
    @Autowired
    private PartnerRepository partnerRepository;

    @Transactional
    public ResponseEntity<String> addPartner(Partner partner) throws PartnerAlreadyExistsException{
        Partner check = partnerRepository.findByName(partner.getName());

        if(check != null) {
            throw new PartnerAlreadyExistsException("Partner already created");
        }

        partnerRepository.save(partner);

        return ResponseEntity.ok("Partner created successfully");
    }

    public ResponseEntity<String> editPartner(PartnerEditRequest partnerEditRequest) throws PartnerNotFoundException {
        Partner check = partnerRepository.findByName(partnerEditRequest.getCurrentName());

        if(check == null) {
            throw new PartnerNotFoundException("Partner not found");
        }

        BeanUtils.copyProperties(partnerEditRequest.getPartner(), check);

        partnerRepository.save(check);

        return ResponseEntity.ok("Partner updated successfully");
    }

    @Transactional
    public ResponseEntity<String> deletePartner(String name) throws PartnerNotFoundException {
        Partner partner = partnerRepository.findByName(name);

        if(partner == null) {
            throw new PartnerNotFoundException("No such partner found");
        }

        partnerRepository.delete(partner);

        return ResponseEntity.ok("Partner deleted successfully");
    }

    public List<Partner> getAllPartners() {
        return partnerRepository.findAll();
    }
}
