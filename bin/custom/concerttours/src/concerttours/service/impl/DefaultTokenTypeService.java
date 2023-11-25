package concerttours.service.impl;

import concerttours.daos.TokenDAO;
import concerttours.model.TokenTypeModel;
import concerttours.service.TokenTypeService;
import de.hybris.platform.servicelayer.model.ModelService;
import org.springframework.stereotype.Component;

@Component
public class DefaultTokenTypeService implements TokenTypeService {
    private final TokenDAO tokenDAO;
    private final ModelService modelService;

    public DefaultTokenTypeService(TokenDAO tokenDAO, ModelService modelService) {
        this.tokenDAO = tokenDAO;
        this.modelService = modelService;
    }

    @Override
    public TokenTypeModel getToken() {
        return tokenDAO.getToken();
    }

    @Override
    public void saveToken(String newToken) {
        TokenTypeModel tokenTypeModel = getToken();
        tokenTypeModel.setToken(newToken);
        modelService.save(tokenTypeModel);
    }
}