package org.gniza.biking.equipment.repository;

import org.gniza.biking.equipment.graphmodel.Athlete;
import org.gniza.biking.equipment.graphmodel.SourceSystemEnum;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

//@RepositoryRestResource(collectionResourceRel = "athlete", path = "athlete")
@Repository
public interface AthleteRepository extends PagingAndSortingRepository<Athlete, Long> {

    Athlete findByExternalIdAndSourceSystem(String externalId, SourceSystemEnum sourceSystemEnum);

}