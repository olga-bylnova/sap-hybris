package concerttours.facades.impl;

import concerttours.data.ContactRequestData;
import concerttours.facades.ContactRequestFacade;
import concerttours.model.ContactRequestModel;
import concerttours.service.ContactRequestService;
import org.springframework.stereotype.Component;

@Component("contactRequestFacade")
public class DefaultContactRequestFacade implements ContactRequestFacade {
    private final ContactRequestService contactRequestService;

    public DefaultContactRequestFacade(ContactRequestService contactRequestService) {
        this.contactRequestService = contactRequestService;
    }

    @Override
    public ContactRequestData getContactRequest(String sender) {
        if (sender == null) {
            throw new IllegalArgumentException("Sender cannot be null");
        }
        ContactRequestData contactRequestData = new ContactRequestData();
        ContactRequestModel contactRequestModel = contactRequestService.getContactRequest(sender);

        if (contactRequestModel == null) {
            return null;
        }

        contactRequestData.setMessage(contactRequestModel.getMessage());
        contactRequestData.setSender(contactRequestModel.getSender());

        return contactRequestData;
    }
}
