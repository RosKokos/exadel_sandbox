package com.exadel.sandbox.controllers.location_controller;

import com.exadel.sandbox.dto.request.CityRequest;
import com.exadel.sandbox.dto.response.user.AuthenticationResponse;
import com.exadel.sandbox.security.utill.JwtUtil;
import com.exadel.sandbox.service.CityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/location")
public class CityController {

    private final CityService cityService;
    private final JwtUtil jwtUtil;

    @Autowired
    public CityController(CityService cityService, JwtUtil jwtUtil) {
        this.cityService = cityService;
        this.jwtUtil = jwtUtil;
    }

    @GetMapping(produces = {"application/json"}, path = "/allCities")
    public ResponseEntity<?> getAllCity() {
        return new ResponseEntity<>(cityService.findAll(), HttpStatus.OK);
    }

    @PostMapping(produces = {"application/json"},
            consumes = {"application/json"},
            path = "/newCity")
    public ResponseEntity<?> createCity(@RequestBody final CityRequest cityRequest) {

        final var cityResponse = cityService.create(cityRequest);

        return new ResponseEntity<>(cityResponse, HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"}, path = "/allActiveCities")
    public ResponseEntity<?> findCitiesByEventStatusActive() {
        return new ResponseEntity<>(cityService.findCitiesByEventStatusActive(), HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"}, path = "/allFavoriteCities")
    public ResponseEntity<?> findCitiesByFavoriteEvent(@RequestHeader("Authorization") AuthenticationResponse authenticationResponse) {

        Long userId = Long.parseLong(jwtUtil.extractUserId(authenticationResponse.getJwt().substring(7)));
        var cities = cityService.findCitiesByFavoriteEvent(userId);

        return new ResponseEntity<>(cities, HttpStatus.OK);
    }

    @GetMapping(produces = {"application/json"}, path = "/allCitiesByCountry")
    public ResponseEntity<?> getAllCityByCountry(@RequestParam(name = "countryName") String countryName) {
        return new ResponseEntity<>(cityService.findCitiesByCountryNameOrderByName(countryName), HttpStatus.OK);
    }

}