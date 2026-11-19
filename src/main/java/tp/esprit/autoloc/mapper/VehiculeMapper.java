package tp.esprit.autoloc.mapper;

import org.mapstruct.BeanMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.ReportingPolicy;
import tp.esprit.autoloc.domain.Vehicule;
import tp.esprit.autoloc.dto.VehiculeDto;
import tp.esprit.autoloc.dto.VehiculeRequestDto;

@Mapper(componentModel = "spring", uses = AgenceReferenceMapper.class,
        unmappedTargetPolicy = ReportingPolicy.IGNORE)
public interface VehiculeMapper {
    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "idVehicule", source = "idVehicule")
    @Mapping(target = "immatriculation", source = "immatriculation")
    @Mapping(target = "marque", source = "marque")
    @Mapping(target = "modele", source = "modele")
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "tarifJournalier", source = "tarifJournalier")
    @Mapping(target = "statut", source = "statut")
    @Mapping(target = "agenceId", source = "agence.idAgence")
    @Mapping(target = "agenceNom", source = "agence.nom")
    VehiculeDto toDto(Vehicule vehicule);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "immatriculation", source = "immatriculation")
    @Mapping(target = "marque", source = "marque")
    @Mapping(target = "modele", source = "modele")
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "tarifJournalier", source = "tarifJournalier")
    @Mapping(target = "statut", source = "statut")
    @Mapping(target = "agence", source = "agenceId", qualifiedByName = "agenceById")
    Vehicule toEntity(VehiculeRequestDto dto);

    @BeanMapping(ignoreByDefault = true)
    @Mapping(target = "immatriculation", source = "immatriculation")
    @Mapping(target = "marque", source = "marque")
    @Mapping(target = "modele", source = "modele")
    @Mapping(target = "categorie", source = "categorie")
    @Mapping(target = "tarifJournalier", source = "tarifJournalier")
    @Mapping(target = "statut", source = "statut")
    @Mapping(target = "agence", source = "agenceId", qualifiedByName = "agenceById")
    void updateEntity(VehiculeRequestDto dto, @MappingTarget Vehicule vehicule);
}
