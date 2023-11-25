package concerttours.service;

import concerttours.model.TokenTypeModel;

public interface TokenTypeService {
    TokenTypeModel getToken();
    void saveToken(String newToken);
}