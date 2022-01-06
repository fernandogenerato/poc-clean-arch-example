package br.com.core.profiles.gateways.mongodb.documents;

import br.com.core.profiles.domains.ProfileId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProfileIdDocument {
  private String personalDocument;
  private String uuid;

  public ProfileIdDocument(final ProfileId id) {
    this.personalDocument = id.getPersonalDocument();
    this.uuid = id.getUuid();
  }
}
