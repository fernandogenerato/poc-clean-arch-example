package br.com.core.profiles.gateways;

import br.com.core.profiles.domains.Profile;

import java.util.List;

public interface ProfileGateway {

  Profile findById(String id);

  Profile save(Profile profile);

  List<Profile> findAll();

  Boolean contains(String personalDocument);
}
