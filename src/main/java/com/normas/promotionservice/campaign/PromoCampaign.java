package com.normas.promotionservice.campaign;

import com.normas.promotionservice.customer.Customer;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
public class PromoCampaign {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    private String title;
    private String description;
    private String brand;
    private LocalDate startCampaign;
    private LocalDate stopCampaign;

    @ManyToOne
    private Customer creator;

    public PromoCampaign() {
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public LocalDate getStartCampaign() {
        return startCampaign;
    }

    public void setStartCampaign(LocalDate startCampaign) {
        this.startCampaign = startCampaign;
    }

    public LocalDate getStopCampaign() {
        return stopCampaign;
    }

    public void setStopCampaign(LocalDate stopCampaign) {
        this.stopCampaign = stopCampaign;
    }


}
