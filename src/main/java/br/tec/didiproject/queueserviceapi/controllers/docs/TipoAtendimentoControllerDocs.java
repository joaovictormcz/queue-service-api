package br.tec.didiproject.queueserviceapi.controllers.docs;

import br.tec.didiproject.queueserviceapi.dtos.request.RequisicaoTipoAtendimentoDTO;
import br.tec.didiproject.queueserviceapi.dtos.response.RespostaTipoAtendimentoDTO;
import br.tec.didiproject.queueserviceapi.utils.annotations.swagger.*;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.enums.ParameterIn;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import static br.tec.didiproject.queueserviceapi.enums.constants.OpenApiSchemes.*;
import static br.tec.didiproject.queueserviceapi.enums.constants.OpenApiTypes.SCHEMA_TYPE_STRING;
import static br.tec.didiproject.queueserviceapi.enums.constants.v1.ControllerAnnotationsV1.*;

@SecurityRequirement(name = SECURITY_SCHEME_NAME)
@Tag(name = TIPO_ATENDIMENTO_CONTROLER_TAG)
public interface TipoAtendimentoControllerDocs {

    @Tag(name = TAG_POST)
    @Operation(summary = TIPO_ATENDIMENTO_CONTROLLER_CREATE_OPERATION_SUMMARY
            , description = TIPO_ATENDIMENTO_CONTROLLER_CREATE_OPERATION_DESCRIPTION)
    @ApiResponse(responseCode = "201"
            , description = TIPO_ATENDIMENTO_CONTROLLER_CREATE_201_DESCRIPTION)
    @ApiResponse400
    @ApiResponse403
    ResponseEntity<RespostaTipoAtendimentoDTO> novoTipoAtendimento(
            RequisicaoTipoAtendimentoDTO requisicaoTipoAtendimentoDTO
            , BindingResult bindingResult);

    @Tag(name = TAG_GET)
    @Operation(summary = TIPO_ATENDIMENTO_CONTROLLER_FIND_ALL_OPERATION_SUMMARY
            , description = TIPO_ATENDIMENTO_CONTROLLER_FIND_ALL_OPERATION_DESCRIPTION)
    @PageParams
    @ApiResponse(responseCode = "200"
            , description = TIPO_ATENDIMENTO_CONTROLLER_FIND_ALL_200_DESCRIPTION)
    @ApiResponse403
    ResponseEntity<Page<RespostaTipoAtendimentoDTO>> listarTiposAtendimento(
            Pageable pageable
    );

    @Tag(name = TAG_GET)
    @Operation(summary = TIPO_ATENDIMENTO_CONTROLLER_FIND_BY_ID_OPERATION_SUMMARY
            , description = TIPO_ATENDIMENTO_CONTROLLER_FIND_BY_ID_OPERATION_DESCRIPTION)
    @Parameter(in = ParameterIn.PATH
            , schema = @Schema(type = SCHEMA_TYPE_STRING)
            , name = "id"
            , description = TIPO_ATENDIMENTO_CONTROLLER_FIND_BY_ID_PARAMETER_ID_DESCRIPTION
            , example = TIPO_ATENDIMENTO_CONTROLLER_FIND_BY_ID_PARAMETER_ID_EXAMPLE)
    @ApiResponse(responseCode = "200"
            , description = TIPO_ATENDIMENTO_CONTROLLER_FIND_BY_ID_200_DESCRIPTION)
    @ApiResponse403
    @ApiResponse404
    ResponseEntity<RespostaTipoAtendimentoDTO> findById(String id);

    @Tag(name = TAG_PUT)
    @Operation(summary = TIPO_ATENDIMENTO_CONTROLLER_UPDATE_OPERATION_SUMMARY
            , description = TIPO_ATENDIMENTO_CONTROLLER_UPDATE_OPERATION_DESCRIPTION)
    @Parameter(in = ParameterIn.PATH
            , schema = @Schema(type = SCHEMA_TYPE_STRING)
            , name = "id"
            , description = TIPO_ATENDIMENTO_CONTROLLER_UPDATE_PARAMETER_ID_DESCRIPTION
            , example = TIPO_ATENDIMENTO_CONTROLLER_UPDATE_PARAMETER_ID_EXAMPLE)
    @ApiResponse(responseCode = "200"
            , description = TIPO_ATENDIMENTO_CONTROLLER_UPDATE_200_DESCRIPTION)
    @ApiResponse400
    @ApiResponse403
    @ApiResponse404
    @ApiResponse409
    ResponseEntity<RespostaTipoAtendimentoDTO> atualizaTipoAtendimento(String id
            , RequisicaoTipoAtendimentoDTO requisicaoTipoAtendimentoDTO
            , BindingResult bindingResult);

    @Tag(name = TAG_DELETE)
    @Operation(summary = TIPO_ATENDIMENTO_CONTROLLER_DELETE_BY_ID_OPERATION_SUMMARY
            , description = TIPO_ATENDIMENTO_CONTROLLER_DELETE_BY_ID_OPERATION_DESCRIPTION)
    @Parameter(in = ParameterIn.PATH
            , schema = @Schema(type = SCHEMA_TYPE_STRING)
            , name = "id"
            , description = TIPO_ATENDIMENTO_CONTROLLER_DELETE_BY_ID_PARAMETER_ID_DESCRIPTION
            , example = TIPO_ATENDIMENTO_CONTROLLER_DELETE_BY_ID_PARAMETER_ID_EXAMPLE)
    @ApiResponse(responseCode = "204"
            , description = TIPO_ATENDIMENTO_CONTROLLER_DELETE_BY_ID_204_DESCRIPTION
            , content = @Content(schema = @Schema(hidden = true)))
    @ApiResponse403
    @ApiResponse404
    @ApiResponse409
    ResponseEntity<Void> deletarTipoAtendimento(String id);
}