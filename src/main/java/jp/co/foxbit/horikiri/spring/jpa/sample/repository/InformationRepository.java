package jp.co.foxbit.horikiri.spring.jpa.sample.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.DBInformationModel;

@Repository
public interface InformationRepository extends JpaRepository<DBInformationModel, String>{

}
