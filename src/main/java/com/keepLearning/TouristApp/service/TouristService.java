package com.keepLearning.TouristApp.service;


import com.keepLearning.TouristApp.dao.ITouristRepo;
import com.keepLearning.TouristApp.exception.TouristNotFoundException;
import com.keepLearning.TouristApp.model.Tourist;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class TouristService implements ITouristService {

    @Autowired
    private ITouristRepo repo;

    @Override
    public String registerTourist(Tourist tourist) {
        Tourist t = repo.save(tourist);
        return "Tourist info saved with id" + t.getId();
    }

    @Override
    public Tourist fetchTouristById(Integer touristId) throws TouristNotFoundException {
//       Optional<Tourist> optional= repo.findById(touristId);
//       if(optional.isPresent()){
//           return optional.get();
//       }
//       else
//       {
//           throw new TouristNotFoundException("Tourist not found");
//       }

        return repo.findById(touristId).orElseThrow(() -> new TouristNotFoundException("Tourist not found"));

    }

    @Override
    public List<Tourist> fetchAllTouristInfo() {
        return repo.findAll();
    }

    @Override
    public String updateTourist(Tourist tourist) throws TouristNotFoundException {
        Optional<Tourist> optional = repo.findById(tourist.getId());
        if (optional.isPresent()) {
            repo.save(tourist);
            return "Data saved successfully";
        } else {
            throw new TouristNotFoundException("Tourist not found with the given id");
        }

    }

    @Override
    public String updateTouristBudget(Integer id, Double budget) throws TouristNotFoundException {
        Optional<Tourist> optional = repo.findById(id);
        if (optional.isPresent()) {
            Tourist tourist = optional.get();
            tourist.setBudget(budget);
            repo.save(tourist);
            return "Data updated with the given info";
        } else {
            throw new TouristNotFoundException("Tourist not found with the given id");
        }

    }

    @Override
    public String deleteTourist(Integer touristId) throws TouristNotFoundException  {
        Optional<Tourist> optional = repo.findById(touristId);
        if(optional.isPresent()) {
            repo.deleteById(touristId);
            return "Data deleted successfully";
        }else
        {
            throw new TouristNotFoundException("Tourist not found with the given id");
        }
    }

}
