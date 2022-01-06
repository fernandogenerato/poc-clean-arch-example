package br.com.core.profiles.gateways.http.response;

import br.com.core.profiles.domains.Profile;
import br.com.core.profiles.domains.ProfileId;
import br.com.core.profiles.domains.ProfileType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import static java.util.Optional.ofNullable;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProfileResponse {

  private ProfileId id;
  private String name;
  private ProfileType type;

  public ProfileResponse(final Profile profile) {
    this.id = ofNullable(profile.getId()).orElse(null);
    this.name = ofNullable(profile.getName()).orElse(null);
    this.type = ofNullable(profile.getType()).orElse(null);
  }
}
