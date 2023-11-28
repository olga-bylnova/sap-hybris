package concerttours.jobs;

import concerttours.model.TokenTypeModel;
import de.hybris.bootstrap.annotations.IntegrationTest;
import de.hybris.platform.core.Registry;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.servicelayer.ServicelayerTransactionalTest;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import de.hybris.platform.servicelayer.model.ModelService;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.annotation.Resource;
import java.util.concurrent.TimeUnit;

@IntegrationTest
public class TokenJobIntegrationTest extends ServicelayerTransactionalTest {
    @Resource
    private TokenJob tokenJob;
    @Resource
    private ModelService modelService;

    @Before
    public void setUp() throws Exception {
        try {
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
            new JdbcTemplate(Registry.getCurrentTenant().getDataSource()).execute("CHECKPOINT");
            Thread.sleep(TimeUnit.SECONDS.toMillis(1));
        } catch (InterruptedException exc) {
        }

        TokenTypeModel tokenTypeModel = modelService.create(TokenTypeModel.class);
        tokenTypeModel.setToken("A000");
        modelService.save(tokenTypeModel);
    }

    @Test
    public void testCronJob() {
        final PerformResult result = tokenJob.perform(null);
        Assert.assertEquals("Job did not perform correctly", CronJobResult.SUCCESS, result.getResult());
    }
}