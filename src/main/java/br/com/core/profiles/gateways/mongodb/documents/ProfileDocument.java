package br.com.core.profiles.gateways.mongodb.documents;

import br.com.core.profiles.domains.Profile;
import br.com.core.profiles.domains.ProfileId;
import br.com.core.profiles.domains.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "profiles")
@AllArgsConstructor
@NoArgsConstructor
public class ProfileDocument {

  @Id private ProfileIdDocument id;
  private String name;
  private ProfileType type;

  public ProfileDocument(final Profile profile) {
    name = profile.getName();
    id = new ProfileIdDocument(profile.getId());
    type = profile.getType();
  }

  public Profile toDomain() {
    return Profile.builder().id(new ProfileId(id)).name(name).type(type).build();
  }
}
