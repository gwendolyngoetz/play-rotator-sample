package services;

import com.google.inject.Inject
import play.api.Configuration
import play.api.mvc.{DefaultSessionCookieBaker, Session}

class RotatingSessionCookieBaker @Inject()(
  var configuration: Configuration,
  var customSessionSerializer: CustomSessionSerializer)

  extends DefaultSessionCookieBaker {

  override def serialize(session: Session):
    Map[String, String] = customSessionSerializer.serialize(session)

  override def deserialize(data: Map[String, String]):
    Session = customSessionSerializer.deserialize(data)

  override def encode(data: Map[String, String]): String =
    super.encode(data)

  override def decode(encodedData: String): Map[String, String] =
    super.decode(encodedData)
}
