package com.rsanchos.clientmanagement.clients.models.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

/**
 * User
 */
@Entity
@Table(name = "clients")
@Data
public class Client {

    @Id
    @Column
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column
    private String email;

    @Column
    private String name;

    @Column
    private String surname;

    @Column(name = "birth_date")
    private Long birthDate;

    /**
     * 
     */
    public Client() {
    }


}
