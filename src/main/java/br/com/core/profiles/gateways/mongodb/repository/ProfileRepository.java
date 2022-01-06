package br.com.core.profiles.gateways.mongodb.repository;

import br.com.core.profiles.gateways.mongodb.documents.ProfileDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ProfileRepository extends MongoRepository<ProfileDocument, String> {

  @Query("{ '_id.personalDocument' : ?0 }")
  Optional<ProfileDocument> findByPersonalDocument(String personalDocument);

  @Query("{ '_id.uuid' : ?0 }")
  Optional<ProfileDocument> findByUuid(String uuid);
}
