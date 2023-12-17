package concerttours.controller;

import concerttours.data.BandData;
import concerttours.facades.BandFacade;
import de.hybris.platform.catalog.CatalogVersionService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/bands")
public class BandController {
    private static final String CATALOG_ID = "concertoursProductCatalog";
    private static final String CATALOG_VERSION_NAME = "Online";

    private final CatalogVersionService catalogVersionService;
    private final BandFacade bandFacade;

    public BandController(CatalogVersionService catalogVersionService, BandFacade bandFacade) {
        this.catalogVersionService = catalogVersionService;
        this.bandFacade = bandFacade;
    }

    @GetMapping("/{code}")
    public String getBand(Model model, @PathVariable String code) {
        catalogVersionService.setSessionCatalogVersion(CATALOG_ID, CATALOG_VERSION_NAME);
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
