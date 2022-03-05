package br.com.businesstec.servicetotvs.dto;

import javax.xml.bind.annotation.XmlElement;

public class Marca {

    @XmlElement(name = "NAME")
    private String name;
    @XmlElement(name = "FEATURED")
    private Boolean featured;
    @XmlElement(name = "EXTERNALID")
    private Integer externalId;
    @XmlElement(name = "ACTIVE")
    private Boolean active;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getFeatured() {
        return featured;
    }

    public void setFeatured(Boolean featured) {
        this.featured = featured;
    }

    public Integer getExternalId() {
        return externalId;
    }

    public void setExternalId(Integer externalId) {
        this.externalId = externalId;
    }

    public Boolean getActive() {
        return active;
    }

    public void setActive(Boolean active) {
        this.active = active;
    }
}
