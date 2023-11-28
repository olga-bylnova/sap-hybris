package concerttours.daos.impl;

import concerttours.daos.TokenDAO;
import concerttours.model.TokenTypeModel;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import org.springframework.stereotype.Component;

@Component
public class DefaultTokenDAO implements TokenDAO {
    private final FlexibleSearchService flexibleSearchService;

    public DefaultTokenDAO(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    @Override
    public TokenTypeModel getToken() {
        final String queryString =
                "SELECT {p:" + TokenTypeModel.PK + "} "
                        + "FROM {" + TokenTypeModel._TYPECODE + " AS p} ";
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        return flexibleSearchService.<TokenTypeModel>search(query).getResult().get(0);
    }
}