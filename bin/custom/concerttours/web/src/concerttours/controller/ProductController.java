package concerttours.controller;

import de.hybris.platform.catalog.CatalogService;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/product")
public class ProductController {
    private final ProductService productService;
    private final CatalogService catalogService;

    public ProductController(ProductService productService, CatalogService catalogService) {
        this.productService = productService;
        this.catalogService = catalogService;
    }

    @GetMapping
    public String getProduct(Model model, @RequestParam("code") String code) {
        ProductModel product = null;

        catalogService.setSessionCatalogVersion("concertToursProductCatalog", "Online");
        if (code != null && !code.isBlank()) {
            try {
                product = productService.getProductForCode(code);
            } catch (RuntimeException e) {
                return "404";
            }
        }
        model.addAttribute("product", product);
        return "product";
    }
}
