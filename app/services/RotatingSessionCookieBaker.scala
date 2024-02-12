package services;

import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.{DefaultSessionCookieBaker, Session}

class RotatingSessionCookieBaker @Inject()(
  var configuration: Configuration,
  var customEncryptor: CustomEncryptor)

  extends DefaultSessionCookieBaker {

  override def serialize(session: Session):

    Map[String, String] = customEncryptor.encrypt(session)

  override def deserialize(data: Map[String, String]):
    Session = customEncryptor.decrypt(data)
}
