package br.com.core.profiles.gateways.mongodb;

import br.com.core.profiles.domains.Profile;
import br.com.core.profiles.gateways.ProfileGateway;
import br.com.core.profiles.gateways.mongodb.documents.ProfileDocument;
import br.com.core.profiles.gateways.mongodb.repository.ProfileRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

import static org.apache.commons.collections4.CollectionUtils.emptyIfNull;

@Component
@RequiredArgsConstructor
public class ProfileGatewayMongoImpl implements ProfileGateway {

  private final ProfileRepository profileRepository;

  @Override
  public Profile findById(final String id) {
    return profileRepository.findByUuid(id).orElseThrow(RuntimeException::new).toDomain();
  }

  @Override
  public Profile save(final Profile profile) {
    return profileRepository.save(new ProfileDocument(profile)).toDomain();
  }

  @Override
  public List<Profile> findAll() {
    return emptyIfNull(profileRepository.findAll()).stream()
        .map(ProfileDocument::toDomain)
        .collect(Collectors.toList());
  }

  @Override
  public Boolean contains(String personalDocument) {
    return profileRepository.findByPersonalDocument(personalDocument).isPresent();
  }
}
