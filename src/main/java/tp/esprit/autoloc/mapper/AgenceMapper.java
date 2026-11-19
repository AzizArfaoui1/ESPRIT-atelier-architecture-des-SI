package tp.esprit.autoloc.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tp.esprit.autoloc.domain.Agence;
import tp.esprit.autoloc.dto.AgenceDto;
import tp.esprit.autoloc.dto.AgenceRequestDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface AgenceMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "idAgence", source = "idAgence")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "ville", source = "ville")
    @Mapping(target = "adresse", source = "adresse")
    @Mapping(target = "telephone", source = "telephone")
    AgenceDto toDto(Agence agence);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "ville", source = "ville")
    @Mapping(target = "adresse", source = "adresse")
    @Mapping(target = "telephone", source = "telephone")
    Agence toEntity(AgenceRequestDto dto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "ville", source = "ville")
    @Mapping(target = "adresse", source = "adresse")
    @Mapping(target = "telephone", source = "telephone")
    void updateEntity(AgenceRequestDto dto, @MappingTarget Agence agence);
}
