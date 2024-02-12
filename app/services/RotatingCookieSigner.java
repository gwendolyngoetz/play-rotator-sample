package services;

import modules.RotatorModule;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.api.http.SecretConfiguration;
import play.api.libs.crypto.DefaultCookieSigner;

import javax.inject.Inject;

public class RotatingCookieSigner extends DefaultCookieSigner {
    private static final Logger logger = LoggerFactory.getLogger(RotatingCookieSigner.class);

    @Inject
    public RotatingCookieSigner(SecretConfiguration secretConfiguration) {
        super(secretConfiguration);
        logger.info("");
        logger.info("");
        logger.info("");
        logger.info("*** RotatingCookieSigner.ctor entered ***");
        logger.info("");
        logger.info("");
        logger.info("");
    }
}

