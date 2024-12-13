package com.keepLearning.TouristApp.service;

import com.keepLearning.TouristApp.exception.TouristNotFoundException;
import com.keepLearning.TouristApp.model.Tourist;
import org.springframework.stereotype.Component;

import java.util.List;

public interface ITouristService {

    String registerTourist(Tourist tourist);
    Tourist fetchTouristById(Integer touristId) throws TouristNotFoundException;
    List<Tourist> fetchAllTouristInfo();
    String updateTourist(Tourist tourist) throws TouristNotFoundException;
    String updateTouristBudget(Integer id,Double budget) throws TouristNotFoundException ;
    String deleteTourist(Integer touristId)throws TouristNotFoundException ;

}
