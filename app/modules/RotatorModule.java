package modules;

import java.util.Arrays;
import java.util.List;

import com.typesafe.config.Config;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import play.Environment;
import play.api.mvc.DefaultFlashCookieBaker;
import play.api.mvc.FlashCookieBaker;
import play.api.mvc.SessionCookieBaker;
import play.inject.ApplicationLifecycle;
import play.api.libs.crypto.CookieSigner;
import play.inject.Binding;
import play.inject.DelegateApplicationLifecycle;
import play.inject.Module;
import play.libs.Files;
import play.libs.concurrent.DefaultFutures;
import play.libs.concurrent.Futures;
import services.RotatingCookieSigner;
import services.RotatingCookieSignerProvider;
import services.RotatingSessionCookieBaker;

public class RotatorModule extends Module {
  private static final Logger logger = LoggerFactory.getLogger(RotatorModule.class);

  @Override
  public List<Binding<?>> bindings(final Environment environment, final Config config) {
    logger.info("");
    logger.info("");
    logger.info("");
    logger.info("*** RotatorModule.bindings entered ***");
    logger.info("");
    logger.info("");
    logger.info("");




    return Arrays.asList(
      bindClass(RotatingCookieSigner.class).toProvider(RotatingCookieSignerProvider.class),
      bindClass(ApplicationLifecycle.class).to(DelegateApplicationLifecycle.class),
      //bindClass(play.Environment.class).toSelf(),
      bindClass(CookieSigner.class).to(RotatingCookieSigner.class),
      bindClass(Files.TemporaryFileCreator.class).to(Files.DelegateTemporaryFileCreator.class),
      bindClass(Futures.class).to(DefaultFutures.class),
      bindClass(FlashCookieBaker.class).to(DefaultFlashCookieBaker.class),
      bindClass(SessionCookieBaker.class).to(RotatingSessionCookieBaker.class)
    );
  }
}
