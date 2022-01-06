package br.com.core.profiles.gateways.http;

import br.com.core.profiles.gateways.http.request.ProfileRequest;
import br.com.core.profiles.gateways.http.response.ProfileResponse;
import br.com.core.profiles.usecase.CreateProfile;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Api(value = "Profile")
@RestController
@RequestMapping("/api/profile")
@RequiredArgsConstructor
@CrossOrigin("*")
public class ProfileController {

  private final CreateProfile createProfile;

  @ResponseStatus(HttpStatus.CREATED)
  @PostMapping
  public ProfileResponse save(@RequestBody @Valid final ProfileRequest profileRequest) {
    return new ProfileResponse(createProfile.execute(profileRequest.toDomain()));
  }


}
