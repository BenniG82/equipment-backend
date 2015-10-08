package org.gniza.biking.equipment.repository;

import org.gniza.biking.equipment.graphmodel.Activity;
import org.gniza.biking.equipment.graphmodel.SourceSystemEnum;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

//@RepositoryRestResource(collectionResourceRel = "athlete", path = "athlete")
@Repository
public interface ActivityRepository extends PagingAndSortingRepository<Activity, Long> {

    Activity findByExternalIdAndSourceSystem(String externalId, SourceSystemEnum sourceSystemEnum);

    List<Activity> findByNameOrderByStartDateUtcAsc(String name);

}