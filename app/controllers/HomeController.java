package controllers;

import com.google.common.collect.ImmutableMap;
import org.slf4j.LoggerFactory;
import org.slf4j.Logger;
import play.mvc.Controller;
import play.mvc.Http.Request;
import play.mvc.Result;
import java.time.Instant;

public class HomeController extends Controller {
    private final Logger LOGGER = LoggerFactory.getLogger(HomeController.class);

    public Result index(Request request) {

        var key = "testkey";

        String previousMS = "";
        if (request.session().get(key).isPresent()) {
            String sessionValue = request.session().get(key).get();
            previousMS = String.format("OK %s", sessionValue);
        }

        String newMS = String.format("%d", Instant.now().toEpochMilli());
        String output = String.format("%s - %s", previousMS, newMS);
        LOGGER.warn(output);

        return ok(output).withSession(ImmutableMap.of(key, newMS));
    }
}
