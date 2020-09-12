package jp.co.foxbit.horikiri.spring.jpa.sample.service;

import java.util.List;
import java.util.stream.Collectors;

//import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.db.InformationModel;
import jp.co.foxbit.horikiri.spring.jpa.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.jpa.sample.model.result.InformationResult;
import jp.co.foxbit.horikiri.spring.jpa.sample.repository.InformationRepository;

@Service
public class InformationService {

//    @Autowired
//    InformationRepository informationRepository;    
    private final InformationRepository informationRepository;

    public InformationService(InformationRepository informationRepository) {

        this.informationRepository = informationRepository;
    }

    public List<InformationResult> fetchAllInformation() {

        return informationRepository.findAll()
                .stream()
                .map(i -> new InformationResult(i))
                .collect(Collectors.toList());
    }

    public InformationModel fetchInformation(String userID) {

        return informationRepository.findById(userID).orElse(new InformationModel());
    }

    public InformationModel createInformation(InformationForm informationForm) {

        return informationRepository.save(new InformationModel(informationForm, true));
    }

    public InformationModel updateInformation(InformationForm informationForm) {

        return informationRepository.save(new InformationModel(informationForm, false));
    }

    public void deleteInformation(String userID) {

        informationRepository.deleteById(userID);
    }

}
