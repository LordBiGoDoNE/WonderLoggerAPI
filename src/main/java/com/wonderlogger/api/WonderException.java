package com.wonderlogger.api;

import com.google.gson.Gson;

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "wonderexception")
public class WonderException {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String software;
    private String versao;
    private String classe;
    private Date dateHour;
    private String causa;
    private String message;

    public WonderException() {
    }

    public WonderException(String software, String versao, String classe, Date dateHour, String causa, String message) {
        this.software = software;
        this.versao = versao;
        this.classe = classe;
        this.dateHour = dateHour;
        this.causa = causa;
        this.message = message;
    }

    public int getId() {
        return id;
    }

    public WonderException setId(int id) {
        this.id = id;
        return this;
    }

    public String getSoftware() {
        return software;
    }

    public WonderException setSoftware(String software) {
        this.software = software;
        return this;
    }

    public String getVersao() {
        return versao;
    }

    public WonderException setVersao(String versao) {
        this.versao = versao;
        return this;
    }

    public String getClasse() {
        return classe;
    }

    public WonderException setClasse(String classe) {
        this.classe = classe;
        return this;
    }

    public Date getDateHour() {
        return dateHour;
    }

    public WonderException setDateHour(Date dateHour) {
        this.dateHour = dateHour;
        return this;
    }

    public String getCausa() {
        return causa;
    }

    public WonderException setCausa(String causa) {
        this.causa = causa;
        return this;
    }

    public String getMessage() {
        return message;
    }

    public WonderException setMessage(String message) {
        this.message = message;
        return this;
    }
}
