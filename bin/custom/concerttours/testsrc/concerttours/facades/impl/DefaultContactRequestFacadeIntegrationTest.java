package concerttours.facades.impl;

import concerttours.data.ContactRequestData;
import concerttours.facades.ContactRequestFacade;
import concerttours.model.ContactRequestModel;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.exceptions.UnknownIdentifierException;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

@IntegrationTest
public class DefaultContactRequestFacadeIntegrationTest extends ServicelayerTransactionalTest {
    @Resource
    private ContactRequestFacade contactRequestFacade;
    @Resource
    private ModelService modelService;
    /**
     * Test contact request
     */
    private ContactRequestModel contactRequestModel;
    /**
     * Message of contact request.
     */
    private static final String CONTACT_REQUEST_MESSAGE = "some message";
    /**
     * Sender of contact request.
     */
    private static final String CONTACT_REQUEST_SENDER = "some sender";

    @Before
    public void setUp() {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            new JdbcTemplate(Registry.getCurrentTenant().getDataSource()).execute("CHECKPOINT");
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException exc) {
        }
        contactRequestModel = modelService.create(ContactRequestModel.class);
        contactRequestModel.setMessage(CONTACT_REQUEST_MESSAGE);
        contactRequestModel.setSender(CONTACT_REQUEST_SENDER);
    }

    /**
     * Tests exception behavior by getting a contact request which doesn't exist
     */
    @Test(expected = UnknownIdentifierException.class)
    public void testInvalidParameter() {
        contactRequestFacade.getContactRequest(CONTACT_REQUEST_SENDER);
    }

    /**
     * Tests exception behavior by passing in a null parameter
     */
    @Test(expected = IllegalArgumentException.class)
    public void testNullParameters() {
        contactRequestFacade.getContactRequest(null);
    }

    /**
     * Tests and demonstrates the Facade's methods
     */
    @Test
    public void testContactRequestFacade() {
        modelService.save(contactRequestModel);
        ContactRequestData contactRequestData = contactRequestFacade.getContactRequest(CONTACT_REQUEST_SENDER);

        assertNotNull(contactRequestData);
        assertEquals(CONTACT_REQUEST_MESSAGE, contactRequestData.getMessage());
        assertEquals(CONTACT_REQUEST_SENDER, contactRequestData.getSender());
    }

    @After
    public void teardown() {

    }
}