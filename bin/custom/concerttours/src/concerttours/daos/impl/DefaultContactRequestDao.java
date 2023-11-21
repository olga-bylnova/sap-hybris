package concerttours.daos.impl;


import concerttours.daos.ContactRequestDao;
import concerttours.jalo.ContactRequest;
import concerttours.model.ContactRequestModel;
import de.hybris.platform.servicelayer.internal.dao.AbstractItemDao;
import de.hybris.platform.servicelayer.search.FlexibleSearchQuery;
import de.hybris.platform.servicelayer.search.FlexibleSearchService;
import de.hybris.platform.servicelayer.search.SearchResult;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DefaultContactRequestDao extends AbstractItemDao implements ContactRequestDao {
    private final FlexibleSearchService flexibleSearchService;

    public DefaultContactRequestDao(FlexibleSearchService flexibleSearchService) {
        this.flexibleSearchService = flexibleSearchService;
    }

    public List<ContactRequestModel> findBySender(final String sender) {
        final String queryString = String.format("SELECT {%s} FROM {%s} WHERE {%s} = ?sender",
                ContactRequest.PK, "ContactRequest",
                ContactRequest.SENDER);
        final FlexibleSearchQuery query = new FlexibleSearchQuery(queryString);
        query.addQueryParameter("sender", sender);
        final SearchResult<ContactRequestModel> result = flexibleSearchService.search(query);
        return result.getResult();
    }
}