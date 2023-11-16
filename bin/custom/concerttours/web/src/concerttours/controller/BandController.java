package concerttours.controller;

import concerttours.model.BandModel;
import concerttours.service.BandService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/band")
public class BandController {
    @Autowired
    private BandService bandService;

    @GetMapping("/{code}")
    public String getBand(Model model, @PathVariable("code") String code) {
        BandModel band = null;
        if (code != null) {
            band = bandService.getBandForCode(code);
        } else {
            return "404";
        }
        model.addAttribute("band", band);
        return "band";
    }
}
