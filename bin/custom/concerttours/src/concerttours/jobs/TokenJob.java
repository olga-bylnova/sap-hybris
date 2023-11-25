package concerttours.jobs;

import concerttours.model.TokenTypeModel;
import concerttours.service.TokenTypeService;
import de.hybris.platform.cronjob.enums.CronJobResult;
import de.hybris.platform.cronjob.enums.CronJobStatus;
import de.hybris.platform.cronjob.model.CronJobModel;
import de.hybris.platform.servicelayer.cronjob.AbstractJobPerformable;
import de.hybris.platform.servicelayer.cronjob.PerformResult;
import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

@Component
public class TokenJob extends AbstractJobPerformable<CronJobModel> {
    private static final Logger LOG = Logger.getLogger(TokenJob.class);
    private final TokenTypeService tokenService;

    public TokenJob(TokenTypeService tokenService) {
        this.tokenService = tokenService;
    }

    @Override
    public PerformResult perform(CronJobModel cronJob) {
        TokenTypeModel tokenTypeModel = tokenService.getToken();
        tokenService.saveToken(tokenTypeModel.getToken() + "_newValue");
        LOG.info("Setting new token value");

        return new PerformResult(CronJobResult.SUCCESS, CronJobStatus.FINISHED);
    }
}
