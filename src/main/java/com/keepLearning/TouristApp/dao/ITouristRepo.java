package com.keepLearning.TouristApp.dao;

import com.keepLearning.TouristApp.model.Tourist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITouristRepo extends JpaRepository<Tourist,Integer> {

}
