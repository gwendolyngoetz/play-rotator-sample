package services;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.api.mvc.Session;

import java.util.Map;

public class CustomSessionSerializer {
    private static final Logger logger = LoggerFactory.getLogger(CustomSessionSerializer.class);

    public scala.collection.immutable.Map<String, String> serialize(Session session){    logger.info("");
        logger.info("");
        logger.info("");
        logger.info("*** CustomEncryptor.encrypt entered ***");
        logger.info("");
        logger.info("");
        logger.info("");

        var javaMap = Map.of("", "");
        return scala.collection.immutable.Map.from(scala.jdk.CollectionConverters.MapHasAsScala(javaMap).asScala());
    }

    public Session deserialize(scala.collection.immutable.Map<String, String> cookie){    logger.info("");
        logger.info("");
        logger.info("");
        logger.info("*** CustomEncryptor.decrypt entered ***");
        logger.info("");
        logger.info("");
        logger.info("");

        return Session.emptyCookie();
    }
}
