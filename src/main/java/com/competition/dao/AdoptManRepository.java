package com.competition.dao;

import com.competition.model.AdoptMan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by 14553 on 2018/5/7.
 */
@Repository("adoptManDao")
public interface AdoptManRepository extends CrudRepository<AdoptMan, Integer> {
    
}
