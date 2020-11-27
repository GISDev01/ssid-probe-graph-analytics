package com.gd01.repositories;

import com.gd01.model.AccessPoint;
import org.springframework.data.neo4j.repository.Neo4jRepository;

public interface AccessPointRepository extends Neo4jRepository<AccessPoint, Long> {

    AccessPoint getAccessPointByName(String ssid);

    Iterable<AccessPoint> findAccessPointByNameLike(String ssid);

}
