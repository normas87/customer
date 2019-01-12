package com.normas.promotionservice.campaign;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CampaignRepository extends CrudRepository<PromoCampaign, Long> {

    List<PromoCampaign>findAll();

}
