package jp.co.foxbit.horikiri.spring.jpa.sample.controller;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import jp.co.foxbit.horikiri.spring.jpa.sample.model.form.InformationForm;
import jp.co.foxbit.horikiri.spring.jpa.sample.service.InformationService;

@Controller
public class InformationController {

//    @Autowired
//    InformationService informationService;
    private final InformationService informationService;

    public InformationController(InformationService informationService) {

        this.informationService = informationService;
    }

    @RequestMapping(value = "/information/fetch/all", method = RequestMethod.GET)
    public String fetchAllInformation(Model model) {

        model.addAttribute("informationResult", informationService.fetchAllInformation());

        return "information/fetch_all_information";
    }

    @RequestMapping(value = "/information/create", method = RequestMethod.GET)
    public String createInformation(Model model) {

        model.addAttribute("informationForm", new InformationForm());

        return "information/create_information";
    }

    @RequestMapping(value = "/information/db/create", method = RequestMethod.POST)
//    public String createDBInformation(@Valid @ModelAttribute ParameterInformationModel informationModel, BindingResult result, Model model) {
    public String createDBInformation(@Validated InformationForm informationForm, BindingResult result, Model model) {

        if (result.hasErrors()) {
            model.addAttribute("informationForm", informationForm);
            return "information/create_information";
        }

        informationService.createInformation(informationForm);

        return "redirect:/information/fetch/all";
    }

    @RequestMapping(value = "/information/update/{userID}", method = RequestMethod.GET)
    public String updateInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationForm", new InformationForm(informationService.fetchInformation(userID)));

        return "information/update_information";
    }

    @RequestMapping(value = "/information/db/update", method = RequestMethod.PUT)
//    public String updateDBInformation(@Valid @ModelAttribute ParameterInformationModel informationModel, BindingResult result, Model model) {
      public String updateDBInformation(@Validated InformationForm informationForm, BindingResult result, Model model) {
        
        if (result.hasErrors()) {
            model.addAttribute("informationForm", informationForm);
            return "information/update_information";
        }

        informationService.updateInformation(informationForm);

        return "redirect:/information/fetch/all";
    }

    @RequestMapping(value = "/information/delete/{userID}", method = RequestMethod.GET)
    public String deleteInformation(@PathVariable String userID, Model model) {

        model.addAttribute("informationForm", new InformationForm(informationService.fetchInformation(userID)));

        return "information/delete_information";
    }

    @RequestMapping(value = "/information/db/delete/{userID}", method = RequestMethod.DELETE)
    public String deleteDBInformation(@PathVariable String userID) {

        informationService.deleteInformation(userID);

        return "redirect:/information/fetch/all";
    }
}
