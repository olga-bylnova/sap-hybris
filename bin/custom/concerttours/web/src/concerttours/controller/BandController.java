package concerttours.controller;

import concerttours.data.BandData;
import concerttours.facades.BandFacade;
import concerttours.model.BandModel;
import concerttours.service.BandService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/bands")
public class BandController {
    private final BandFacade bandFacade;

    public BandController(BandFacade bandFacade) {
        this.bandFacade = bandFacade;
    }

    @GetMapping("/{code}")
    public String getBand(Model model, @PathVariable String code) {
        BandData band = null;
        if (code != null && !code.isBlank()) {
            try {
                band = bandFacade.getBand(code);
            } catch (RuntimeException e) {
                return "404";
            }
        }
        model.addAttribute("band", band);
        return "BandDetails";
    }

    @GetMapping
    public String getBands(Model model) {
        model.addAttribute("bands", bandFacade.getBands());
        return "BandList";
    }
}
