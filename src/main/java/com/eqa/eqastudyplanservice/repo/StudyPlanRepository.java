package com.eqa.eqastudyplanservice.repo;

import com.eqa.eqastudyplanservice.model.StudyPlan;
import org.springframework.data.repository.ListCrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StudyPlanRepository extends ListCrudRepository<StudyPlan, Long>, PagingAndSortingRepository<StudyPlan, Long> {



}
