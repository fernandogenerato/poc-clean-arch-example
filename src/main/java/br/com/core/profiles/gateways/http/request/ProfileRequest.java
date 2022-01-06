package br.com.core.profiles.gateways.http.request;

import br.com.core.profiles.domains.Profile;
import br.com.core.profiles.domains.ProfileId;
import br.com.core.profiles.domains.ProfileType;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Getter;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;

@Getter
@ApiModel
public class ProfileRequest {

  @Min(11)
  @ApiModelProperty(value = "document", example = "12345678910", required = true)
  private String personalDocument;

  @NotBlank
  @ApiModelProperty(value = "name", example = "Jonh Doe", required = true)
  private String name;

  private ProfileType type;

  public Profile toDomain() {
    return Profile.builder().id(new ProfileId(personalDocument)).type(type).name(name).build();
  }
}
