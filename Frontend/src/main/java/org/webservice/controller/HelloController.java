package org.webservice.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.webservice.forms.AddressForm;
import org.webservice.forms.RetrieveAddress;

import javax.validation.Valid;

@Controller
public class HelloController extends WebMvcConfigurerAdapter {

    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/home").setViewName("home");
        registry.addViewController("/").setViewName("home");
        registry.addViewController("/hello").setViewName("hello");
        registry.addViewController("/addressBook").setViewName("addressBook");
        registry.addViewController("/addressBookAddForm").setViewName("addressBookAddForm");
        registry.addViewController("/addressBookAddedResults").setViewName("addressBookAddedResults");
        registry.addViewController("/addressBookRetrievedForm").setViewName("addressBookRetrievedForm");
        registry.addViewController("/addressBookRetrievedResults").setViewName("addressBookRetrievedResults");
        registry.addViewController("/familyTree").setViewName("familyTree");
    }

    @RequestMapping(value="/addressBookAddForm", method= RequestMethod.GET)
    public String showNewAddressForm(@ModelAttribute("address") AddressForm address) {
        //model.addAttribute("address", address);
        return "addressBookAddForm";
    }

    @RequestMapping(value="/addressBookAddForm", method= RequestMethod.POST)
    public String addAddress(@Valid AddressForm address, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addressBookAddForm";
        }

        return "redirect:/addressBookAddedResults";
    }


    @RequestMapping(value="/addressBookRetrievedForm", method= RequestMethod.GET)
    public String showGetOldAddressForm(@ModelAttribute("retrieveAddressForm") RetrieveAddress retrieveAddressForm) {
        return "addressBookRetrievedForm";
    }

    @RequestMapping(value="/addressBookRetrievedForm", method= RequestMethod.POST)
    public String getAddress(@Valid RetrieveAddress lookup, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "addressBookRetrievedForm";
        }

        return "redirect:/addressBookRetrievedResults";
    }
}