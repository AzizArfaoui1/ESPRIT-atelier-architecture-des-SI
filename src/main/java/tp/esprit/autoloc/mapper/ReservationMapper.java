package tp.esprit.autoloc.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.ReportingPolicy;
import tp.esprit.autoloc.domain.Reservation;
import tp.esprit.autoloc.dto.ReservationResponseDTO;

@Mapper(componentModel = "spring", unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface ReservationMapper {
    @Mapping(target = "idClient", source = "client.idClient")
    @Mapping(target = "nomClient", source = "client.nom")
    @Mapping(target = "prenomClient", source = "client.prenom")
    @Mapping(target = "statut", source = "statut")
    ReservationResponseDTO toDto(Reservation reservation);
}
