package com.normas.promotionservice.campaign;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CampaignService {
    private  CampaignRepository repository;

    @Autowired
    public CampaignService(CampaignRepository repository){
        this.repository=repository;
    }

    public void save(PromoCampaign campaign) {
        repository.save(campaign);
    }

    public List<PromoCampaign> getAll () {
        return repository.findAll();
    }

    public List<PromoCampaign> getCurrentByBrand(String brand){
        return repository.findAll().stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStartCampaign().isBefore(LocalDate.now()))
                .filter(campaign -> campaign.getStopCampaign().isAfter(LocalDate.now()))
                .collect(Collectors.toList());
    }

    public List<PromoCampaign> getHistoricalCampaign(String brand){
        return repository.findAll().stream()
                .filter(campaign -> campaign.getBrand().equals(brand))
                .filter(campaign -> campaign.getStopCampaign().isBefore(LocalDate.now()))
                .collect(Collectors.toList());
    }
}