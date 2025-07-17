package com.example.sales.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.example.sales.model.Partner;
import com.example.sales.service.PartnerService;
import com.example.sales.DTO.PartnerEditRequest;

import java.util.List;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/partner")
public class PartnerController {
    @Autowired
    PartnerService partnerService;

    @PostMapping("/add")
    public ResponseEntity<String> addPartner(@RequestBody Partner partner) {
        return partnerService.addPartner(partner);
    }

    @PatchMapping("/edit")
    public ResponseEntity<String> editPartner(@RequestBody PartnerEditRequest partnerEditRequest) {
        return partnerService.editPartner(partnerEditRequest);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<String> deletePartner(@RequestBody String name) {
        return partnerService.deletePartner(name);
    }

    @GetMapping("/all")
    public List<Partner> getAllPartners() {
        return partnerService.getAllPartners();
    }
}
