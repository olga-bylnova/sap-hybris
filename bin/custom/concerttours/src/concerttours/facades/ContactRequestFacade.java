package concerttours.facades;

import concerttours.data.ContactRequestData;

public interface ContactRequestFacade {
    ContactRequestData getContactRequest(String sender);
}
