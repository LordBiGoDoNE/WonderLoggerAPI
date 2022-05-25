package com.wonderlogger.api;

import java.util.Date;
import javax.persistence.*;

@Entity
@Table(name = "wonderexception")
public class WonderException {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_software", referencedColumnName = "id")
    private Software software;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_version", referencedColumnName = "id")
    private SoftwareVersion softwareVersion;
    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "id_class", referencedColumnName = "id")
    private SoftwareClass softwareClass;
    @OneToOne(targetEntity = ExceptionType.class, fetch = FetchType.EAGER)
    @JoinColumn(name = "id_exceptiontype", referencedColumnName = "id")
    private ExceptionType exceptionType;
    private Date dateHour;
    @Lob
    private String message;
    @Lob
    private String stacktrace;

    public WonderException(Software software, SoftwareVersion softwareVersion, SoftwareClass softwareClass, ExceptionType exceptionType, Date dateHour, String message, String stacktrace) {
        this.software = software;
        this.softwareVersion = softwareVersion;
        this.softwareClass = softwareClass;
        this.exceptionType = exceptionType;
        this.dateHour = dateHour;
        this.message = message;
        this.stacktrace = stacktrace;
    }

    public WonderException() {
    }
}
