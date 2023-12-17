package concerttours.facades.impl;

import concerttours.data.ConcertSummaryData;
import concerttours.data.ProducerData;
import concerttours.data.TourData;
import concerttours.enums.ConcertType;
import concerttours.facades.TourFacade;
import concerttours.model.ConcertModel;
import de.hybris.platform.core.model.product.ProductModel;
import de.hybris.platform.product.ProductService;
import de.hybris.platform.variants.model.VariantProductModel;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component("tourFacade")
public class DefaultTourFacade implements TourFacade {
    private final ProductService productService;

    public DefaultTourFacade(@Qualifier("defaultProductService") ProductService productService) {
        this.productService = productService;
    }

    @Override
    public TourData getTourDetails(final String tourId) {
        if (tourId == null) {
            throw new IllegalArgumentException("Tour id cannot be null");
        }
        final ProductModel product = productService.getProductForCode(tourId);
        if (product == null) {
            return null;
        }

        final List<ConcertSummaryData> concerts = new ArrayList<>();
        if (product.getVariants() != null) {
            for (final VariantProductModel variant : product.getVariants()) {
                if (variant instanceof ConcertModel) {
                    final ConcertModel concert = (ConcertModel) variant;
                    final ConcertSummaryData summary = new ConcertSummaryData();
                    summary.setId(concert.getCode());
                    summary.setDate(concert.getDate());
                    summary.setVenue(concert.getVenue());
                    summary.setType(concert.getConcertType() == ConcertType.OPENAIR ? "Outdoors" : "Indoors");
                    concerts.add(summary);
                }
            }
        }

        final TourData tourData = new TourData();
        final ProducerData producerData = new ProducerData();

        producerData.setName(product.getProducer().getName());

        tourData.setId(product.getCode());
        tourData.setTourName(product.getName());
        tourData.setDescription(product.getDescription());
        tourData.setProducer(producerData);
        tourData.setConcerts(concerts);

        return tourData;
    }
}