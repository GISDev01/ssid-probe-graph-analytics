package com.gd01.model;

import java.util.Date;
import java.util.List;

import org.neo4j.ogm.annotation.GeneratedValue;
import org.neo4j.ogm.annotation.Id;
import org.neo4j.ogm.annotation.NodeEntity;
import org.neo4j.ogm.annotation.Relationship;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@NodeEntity
public class Client {

    @Id
    @GeneratedValue
    private Long id;

    private String macAddress;
    private Date earliestDetectionTime;

    @JsonIgnoreProperties("ssid")
    @Relationship(type = "PROBED_FOR", direction = Relationship.OUTGOING)
    private List<AccessPoint> accessPoints;

    public Client() {
    }

    public Client(String macAddress, Date earliestDetectionTime) {
        this.macAddress = macAddress;
        this.earliestDetectionTime = earliestDetectionTime;
    }

    public Long getId() {
        return id;
    }

    public Date getEarliestDetectionTime() {
        return earliestDetectionTime;
    }

}
