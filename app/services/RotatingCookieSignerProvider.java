package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.api.http.SecretConfiguration;

import javax.inject.Provider;
import javax.inject.Singleton;

@Singleton
public class RotatingCookieSignerProvider implements Provider<RotatingCookieSigner> {
    private static final Logger logger = LoggerFactory.getLogger(RotatingCookieSignerProvider.class);

    @Override
    public RotatingCookieSigner get() {
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("*** RotatingCookieSignerProvider.get entered ***");
        logger.info("");
        logger.info("");
        logger.info("");
        String newSecret = "newSecret";
        return new RotatingCookieSigner(new SecretConfiguration(newSecret, null));
    }
}
