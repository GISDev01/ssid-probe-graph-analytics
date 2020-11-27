package com.gd01.controllers;

import com.gd01.model.AccessPoint;
import com.gd01.repositories.AccessPointRepository;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/accesspoints")
public class AccessPointController {
    private final AccessPointRepository accessPointRepository;

    public AccessPointController(AccessPointRepository accessPointRepository) {
        this.accessPointRepository = accessPointRepository;
    }

    @GetMapping
    public Iterable<AccessPoint> findAll() {
        return accessPointRepository.findAll();
    }

    @GetMapping("/{ssid}")
    public AccessPoint getAccessPointBySSID(@PathVariable String ssid) {
        return accessPointRepository.getAccessPointByName(ssid);
    }

    @GetMapping("/search/{ssid}")
    public Iterable<AccessPoint> findAccessPointBySSIDLike(@PathVariable String ssid) {
        return accessPointRepository.findAccessPointByNameLike(ssid);
    }
}
