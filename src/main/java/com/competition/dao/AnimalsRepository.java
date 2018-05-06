package com.competition.dao;


import com.competition.model.Animals;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 14553 on 2018/4/29.
 */
@Repository("animalsDao")
public interface AnimalsRepository extends CrudRepository<Animals, Integer> {
    Animals findByImgName(String img_name);
}