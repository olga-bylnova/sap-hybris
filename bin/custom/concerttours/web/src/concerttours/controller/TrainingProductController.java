package concerttours.controller;

import concerttours.service.TrainingProductService;
import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/trainingProduct")
public class TrainingProductController {
    @Autowired
    private CatalogService catalogService;
    @Autowired
    @Qualifier("productService")
    private TrainingProductService trainingProductService;

    @GetMapping
    public String getProduct(@RequestParam String code,
                             @RequestParam String name,
                             Model model) {
        catalogService.setSessionCatalogVersion("concertToursProductCatalog", "Online");

        ProductModel product = null;
        if (code != null && name != null) {
            product = trainingProductService.getProductForCode(code, name);
        }
        model.addAttribute("product", product);
        return "trainingProduct";
    }
}
