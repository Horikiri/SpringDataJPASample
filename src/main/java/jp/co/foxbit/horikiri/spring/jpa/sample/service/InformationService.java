package jp.co.foxbit.horikiri.spring.jpa.sample.service;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.DBInformationModel;
import jp.co.foxbit.horikiri.spring.jpa.sample.model.parameter.ParameterInformationModel;
import jp.co.foxbit.horikiri.spring.jpa.sample.model.result.ResultInformationModel;
import jp.co.foxbit.horikiri.spring.jpa.sample.repository.InformationRepository;

@Service
public class InformationService {

//    @Autowired
//    InformationRepository informationRepository;    
    private final InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {

        this.informationRepository = informationRepository;
    }

    public List<ResultInformationModel> fetchAllInformation() {

        return informationRepository.findAll()
                .stream()
                .map(i -> new ResultInformationModel(i))
                .collect(Collectors.toList());
    }

    public DBInformationModel fetchInformation(String userID) {

        return informationRepository.findById(userID).orElse(new DBInformationModel());
    }

    public DBInformationModel createInformation(ParameterInformationModel informationModel) {

        return informationRepository.save(new DBInformationModel(informationModel, true));
    }

    public DBInformationModel updateInformation(ParameterInformationModel informationModel) {

        return informationRepository.save(new DBInformationModel(informationModel, false));
    }

    public void deleteInformation(String userID) {

        informationRepository.deleteById(userID);
    }

}
