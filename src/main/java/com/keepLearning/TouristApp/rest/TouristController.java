package com.keepLearning.TouristApp.rest;

import com.keepLearning.TouristApp.exception.TouristNotFoundException;
import com.keepLearning.TouristApp.model.Tourist;
import com.keepLearning.TouristApp.service.ITouristService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;

@RestController
@RequestMapping("/tourist-api")
public class TouristController {

    @Autowired
    private ITouristService service;

    @PostMapping("/api/addTourist")
    public ResponseEntity<String> addTourist(@RequestBody Tourist tourist) {
        String response=service.registerTourist(tourist);
        return new ResponseEntity<String>(response, HttpStatus.CREATED);
    }


    @GetMapping("/api/get-tourists")
    public ResponseEntity<?> getAllTourists() {
        try{
            List<Tourist> tourists= service.fetchAllTouristInfo();
            return new ResponseEntity<List>(tourists, HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<String>("Internal server error",HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/api/update-tourist")
    public ResponseEntity<String> updateTourist(@RequestBody Tourist tourist) {
            String response=service.updateTourist(tourist);
            return new ResponseEntity<String>(response, HttpStatus.OK);
    }

    @PatchMapping("/api/update-tourist/{id}/{budget}")
    public ResponseEntity<String> updateTourist(@PathVariable("id") Integer id, @PathVariable("budget") Double budget) {
        try {
            String Response = service.updateTouristBudget(id, budget);
            return new ResponseEntity<String>(Response, HttpStatus.OK);
        }
        catch (TouristNotFoundException e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/api/update-tourist/{id}/{budget}")
    public ResponseEntity<String> deleteTourist(@PathVariable("id") Integer id) {
        String Response= service.deleteTourist(id);
        return new ResponseEntity<String>(Response, HttpStatus.OK);
    }


}
