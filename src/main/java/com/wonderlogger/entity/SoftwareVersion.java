package com.wonderlogger.entity;

import javax.persistence.*;

@Entity
@Table(name = "softwareVersion")
public class SoftwareVersion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_software", referencedColumnName = "id")
    private Software software;
    private String version;

    public SoftwareVersion(Software software, String version) {
        this.software = software;
        this.version = version;
    }

    public SoftwareVersion() {
    }

}
