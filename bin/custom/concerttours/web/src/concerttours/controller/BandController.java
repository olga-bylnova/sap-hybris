package concerttours.controller;

import concerttours.model.BandModel;
import concerttours.service.BandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/band")
public class BandController {
    private final BandService bandService;

    public BandController(BandService bandService) {
        this.bandService = bandService;
    }

    @GetMapping
    public String getBand(Model model, @RequestParam("code") String code) {
        BandModel band = null;
        if (code != null && !code.isBlank()) {
            try {
                band = bandService.getBandForCode(code);
            } catch (RuntimeException e) {
                return "404";
            }
        }
        model.addAttribute("band", band);
        return "band";
    }
}
