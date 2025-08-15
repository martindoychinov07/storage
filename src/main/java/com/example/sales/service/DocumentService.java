package com.example.sales.service;

import com.example.sales.exception.PartnerAlreadyExistsException;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.example.sales.model.Document;
import com.example.sales.model.PartnerLog;
import com.example.sales.DTO.DocumentCreateRequest;
import com.example.sales.repository.DocumentRepository;
import com.example.sales.repository.PartnerLogRepository;
import com.example.sales.repository.PartnerRepository;
import com.example.sales.model.Partner;
import com.example.sales.exception.PartnerNotFoundException;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@Service
public class DocumentService {
    @Autowired
    PartnerRepository partnerRepository;

    @Autowired
    PartnerLogRepository partnerLogRepository;

    @Autowired
    DocumentRepository documentRepository;

    @Autowired
    PartnerService partnerService;

    @Transactional
    public ResponseEntity<String> createDocument(DocumentCreateRequest documentCreateRequest)
            throws PartnerAlreadyExistsException, PartnerNotFoundException {
        Partner partner = partnerRepository.findByName(String.valueOf(documentCreateRequest.getName()));

        if (partner == null) {
            throw new PartnerNotFoundException("Partner not found");
        }

        PartnerLog partnerLog = partnerLogRepository.findByRefIdAndVersion(partner.getId(), partner.getVersion());
//        System.out.println(partnerLog.getId());

        if (partnerLog == null) {
            partnerLog = new PartnerLog();
            BeanUtils.copyProperties(partner, partnerLog, "id");
            partnerLog.setRefId(partner.getId());

            partnerLogRepository.save(partnerLog);
        }
//        else {
//            Partner newPartner = new Partner();
//
//            if (partnerRepository.findByName(partner.getName()) != null) {
//                partner.setVersion(LocalDateTime.now());
//                PartnerEditRequest partnerEditRequest = new PartnerEditRequest();
//                partnerEditRequest.setPartner(partner);
//                partnerEditRequest.setCurrentName(partner.getName());
//                partnerService.editPartner(partnerEditRequest);
//            }
//            else {
//                BeanUtils.copyProperties(partner, newPartner, "version");
//                newPartner.setId(partner.getId());
//
//                partnerRepository.save(newPartner);
//            }
//
//            return ResponseEntity.ok("Partner updated");
//        }


        Document document = documentCreateRequest.getDocument();
        document.setCustomerId(partnerLog.getId());
        documentRepository.save(document);

        return ResponseEntity.ok("Document created");
    }

    public List<Document> getAllDocuments() {
        return documentRepository.findAll();
    }
}
