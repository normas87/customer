package com.normas.promotionservice.campaign;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Objects;

@RestController
public class CampaignController {

    private CampaignService service;

@Autowired
    public CampaignController(CampaignService service) {
        this.service = Objects.requireNonNull(service);
    }

    @PostMapping("/campaigns")
    ResponseEntity save(@RequestBody PromoCampaign promoCampaign) {
        service.save(promoCampaign);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/campaigns/{type}")
    ResponseEntity<List<PromoCampaign>> get(@PathVariable String type,
                                            @RequestParam String brand) {
        if (type.equals("current")) {
            return ResponseEntity.ok(service.getCurrentByBrand(brand));
        } else if (type.equals("historic")) {
            return ResponseEntity.ok(service.getHistoricalCampaign(brand));
        }
        return ResponseEntity.notFound().build();
    }
}
