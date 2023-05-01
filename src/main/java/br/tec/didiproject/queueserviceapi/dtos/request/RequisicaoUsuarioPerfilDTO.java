package br.tec.didiproject.queueserviceapi.dtos.request;

import br.tec.didiproject.queueserviceapi.enums.Perfil;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.validator.constraints.UUID;

import java.io.Serializable;
import java.util.List;

import static br.tec.didiproject.queueserviceapi.enums.constants.OpenApiSchemes.*;
import static br.tec.didiproject.queueserviceapi.enums.constants.OpenApiTypes.SCHEMA_TYPE_BOOLEAN;
import static br.tec.didiproject.queueserviceapi.enums.constants.OpenApiTypes.SCHEMA_TYPE_STRING;
import static br.tec.didiproject.queueserviceapi.enums.constants.v1.JsonPropertyDTOs.PERFIL;
import static br.tec.didiproject.queueserviceapi.enums.constants.v1.ValidationMessagesV1.USUARIO_PERFIL_PERFIL_NOT_BLANK;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequisicaoUsuarioPerfilDTO implements Serializable {
    @Schema(implementation = Perfil.class
            , title = SCHEMA_USUARIO_PERFIL_TITLE
            , description = SCHEMA_USUARIO_PERFIL_DESCRIPTION
            , example = SCHEMA_USUARIO_PERFIL_EXAMPLE)
    @JsonProperty(PERFIL)
    @NotBlank(message = USUARIO_PERFIL_PERFIL_NOT_BLANK)
    @Valid
    Perfil perfil;
}
