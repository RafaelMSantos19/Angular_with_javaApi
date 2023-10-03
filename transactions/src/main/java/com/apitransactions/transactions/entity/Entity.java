package com.apitransactions.transactions.entity;


import jakarta.persistence.*;
import java.util.Date;

@jakarta.persistence.Entity
@Table(name = "transactions")
public class Entity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "data_hora")
    private Date data_hora;
    @Column(name = "status")
    private String status;
    @Column(name = "card_bin")
    private String card_bin;
    @Column(name = "cnpj")
    private String cnpj;
    @Column(name = "valor")
    private Float valor;
    @Column(name = "bandeira")
    private String bandeira;

    public Entity(){

    }
    public Date getData_hora() {
        return data_hora;
    }

    public void setData_hora(Date data_hora) {
        this.data_hora = data_hora;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getCard_bin() {
        return card_bin;
    }

    public void setCard_bin(String card_bin) {
        this.card_bin = card_bin;
    }

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Float getValor() {
        return valor;
    }

    public void setValor(Float valor) {
        this.valor = valor;
    }

    public String getBandeira() {
        return bandeira;
    }

    public void setBandeira(String bandeira) {
        this.bandeira = bandeira;
    }
}
