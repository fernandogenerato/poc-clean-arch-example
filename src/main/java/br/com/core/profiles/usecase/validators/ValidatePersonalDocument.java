package br.com.core.profiles.usecase.validators;

import br.com.core.profiles.gateways.ProfileGateway;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class ValidatePersonalDocument {

  private final ProfileGateway profileGateway;

  public boolean execute(final String personalDocument) {
    return profileGateway.contains(personalDocument);
  }
}
