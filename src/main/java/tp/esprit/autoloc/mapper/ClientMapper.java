package tp.esprit.autoloc.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tp.esprit.autoloc.domain.Client;
import tp.esprit.autoloc.dto.ClientDto;
import tp.esprit.autoloc.dto.ClientRequestDto;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ClientMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "idClient", source = "idClient")
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "dateInscription", source = "dateInscription", dateFormat = "dd/MM/yyyy")
    ClientDto toDto(Client client);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "numPermis", source = "numPermis")
    @Mapping(target = "dateInscription", source = "dateInscription", dateFormat = "dd/MM/yyyy")
    Client toEntity(ClientRequestDto dto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "nom", source = "nom")
    @Mapping(target = "prenom", source = "prenom")
    @Mapping(target = "email", source = "email")
    @Mapping(target = "telephone", source = "telephone")
    @Mapping(target = "numPermis", source = "numPermis")
    @Mapping(target = "dateInscription", source = "dateInscription", dateFormat = "dd/MM/yyyy")
    void updateEntity(ClientRequestDto dto, @MappingTarget Client client);
}
