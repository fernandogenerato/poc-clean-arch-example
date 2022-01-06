package br.com.core.profiles.domains;

import br.com.core.profiles.gateways.mongodb.documents.ProfileIdDocument;
import lombok.Data;

import java.util.UUID;

@Data
public class ProfileId {
  private String uuid;
  private String personalDocument;

  public ProfileId(final ProfileIdDocument id) {
    this.uuid = id.getUuid();
    this.personalDocument = id.getPersonalDocument();
  }

  public ProfileId(final String personalDocument) {
    this.uuid = UUID.randomUUID().toString();
    this.personalDocument = personalDocument;
  }
}
