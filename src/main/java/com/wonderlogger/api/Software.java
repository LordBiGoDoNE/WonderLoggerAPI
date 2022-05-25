package com.wonderlogger.api;

import javax.persistence.*;

@Entity
@Table(name = "software", uniqueConstraints={@UniqueConstraint(columnNames = {"software"})})
public class Software {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String software;
    
    public Software(String pSoftware) {
        this.software = pSoftware;
    }

    public Software() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSoftware() {
        return software;
    }

    public void setSoftware(String software) {
        this.software = software;
    }

}
