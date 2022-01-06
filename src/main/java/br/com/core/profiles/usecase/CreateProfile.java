package br.com.core.profiles.usecase;

import br.com.core.profiles.domains.Profile;
import br.com.core.profiles.gateways.ProfileGateway;
import br.com.core.profiles.usecase.validators.ValidatePersonalDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CreateProfile {

  private final ProfileGateway profileGateway;
  private final ValidatePersonalDocument validatePersonalDocument;

  public Profile execute(final Profile profile) {
    if (validatePersonalDocument.execute(profile.getPersonalDocument())) {
      throw new DuplicateKeyException(
          String.format("Personal Document is duplicated: %s", profile.getPersonalDocument()));
    }
    return profileGateway.save(profile);
  }
}
