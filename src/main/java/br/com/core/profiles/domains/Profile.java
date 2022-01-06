package br.com.core.profiles.domains;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Profile {

  private ProfileId id;
  private String name;
  private ProfileType type;

  public String getPersonalDocument() {
    return id.getPersonalDocument();
  }
}
