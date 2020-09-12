package jp.co.foxbit.horikiri.spring.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.InformationModel;

@Repository
public interface InformationRepository extends JpaRepository<InformationModel, String>{

}
