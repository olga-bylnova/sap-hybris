package concerttours.facades.impl;

import concerttours.data.ContactRequestData;
import concerttours.facades.ContactRequestFacade;
import concerttours.model.ContactRequestModel;
import concerttours.service.ContactRequestService;
import de.hybris.bootstrap.annotations.UnitTest;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

@UnitTest
public class DefaultContactRequestFacadeUnitTest {
    private ContactRequestFacade contactRequestFacade;
    private ModelService modelService;
    private ContactRequestService contactRequestService;
    private static final String CONTACT_REQUEST_MESSAGE = "some message";
    private static final String CONTACT_REQUEST_SENDER = "some sender";

    @Before
    public void setUp() {
        modelService = mock(ModelService.class);
        contactRequestService = mock(ContactRequestService.class);
        contactRequestFacade = new DefaultContactRequestFacade(contactRequestService);
    }

    @Test
    public void testGetBand() {
        final ContactRequestModel contactRequestModel = configTestContactRequest();

        when(contactRequestService.getContactRequest(CONTACT_REQUEST_SENDER)).thenReturn(contactRequestModel);
        final ContactRequestData dto = contactRequestFacade.getContactRequest(CONTACT_REQUEST_SENDER);

        Assert.assertNotNull(dto);
        Assert.assertEquals(contactRequestModel.getSender(), dto.getSender());
        Assert.assertEquals(contactRequestModel.getMessage(), dto.getMessage());
    }

    private ContactRequestModel configTestContactRequest() {
        final ContactRequestModel contactRequestModel = new ContactRequestModel();
        contactRequestModel.setSender(CONTACT_REQUEST_SENDER);
        contactRequestModel.setMessage(CONTACT_REQUEST_MESSAGE);

        modelService.attach(contactRequestModel);

        return contactRequestModel;
    }
}