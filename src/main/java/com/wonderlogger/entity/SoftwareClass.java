package com.wonderlogger.entity;

import javax.persistence.*;

@Entity
@Table(name = "softwareclass")
public class SoftwareClass {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_software", referencedColumnName = "id")
    private Software software;

    @Column(name = "classname")
    private String className;

    public SoftwareClass(long id, Software software, String className) {
        this.id = id;
        this.software = software;
        this.className = className;
    }

    public SoftwareClass(Software software, String className) {
        this.software = software;
        this.className = className;
    }

    public SoftwareClass() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public Software getSoftware() {
        return software;
    }

    public void setSoftware(Software software) {
        this.software = software;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
    }
}
