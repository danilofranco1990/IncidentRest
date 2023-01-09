package br.com.api.incidents.repository.interfaces;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.api.incidents.model.Incidents;
@Repository
public interface IncidentsRepository extends JpaRepository<Incidents, Long>{

	public List<Incidents> findTop3ByOrderByIdincidentDesc();

}
