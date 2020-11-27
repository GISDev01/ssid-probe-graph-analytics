package com.gd01.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NodeEntity
public class AccessPoint {

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private Date earliestDetectionTime;

    @JsonIgnoreProperties("ssid")
    @Relationship(type = "PROBED_FOR", direction = Relationship.INCOMING)
    private List<Client> clients;

    public AccessPoint() {
    }

    public AccessPoint(String name, Date earliestDetectionTime) {
        this.name = name;
        this.earliestDetectionTime = earliestDetectionTime;
    }

    public Long getId() {
        return id;
    }

    public Date getEarliestDetectionTime() {
        return earliestDetectionTime;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void addClient(Client client) {
        if (this.clients == null) {
            this.clients = new ArrayList<>();
        }
        this.clients.add(client);
    }

}
