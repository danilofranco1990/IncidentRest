package br.com.api.incidents.controller;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import br.com.api.incidents.model.Incidents;
import br.com.api.incidents.repository.interfaces.IncidentsRepository;

@RestController
public class IncidentsController {

	private IncidentsRepository incidentsRepository;
	@Autowired
	public IncidentsController(IncidentsRepository incidentsRepository) {
		super();
		this.incidentsRepository = incidentsRepository;
	}
	
	@PostMapping(value = "save")
	public ResponseEntity<Incidents> save(@RequestBody Incidents incident){
		incidentsRepository.save(incident);
		return new ResponseEntity<>(incident,HttpStatus.OK);
	}
	
	@GetMapping (value = "getAll")
	@ResponseBody
	public ResponseEntity<List<Incidents>> getAll(){
		List<Incidents> incidents = new ArrayList<>();
		incidents = incidentsRepository.findAll();
		return new ResponseEntity<>(incidents,HttpStatus.OK);	
		
	}
	
	@GetMapping (value = "getTop20")
	@ResponseBody
	public ResponseEntity<List<Incidents>> getTop20(){
		List<Incidents> incidents = new ArrayList<>();
		incidents = incidentsRepository.findTop3ByOrderByIdincidentDesc();
		return new ResponseEntity<>(incidents,HttpStatus.OK);		
	}
	
	@GetMapping(value ="getById")
	@ResponseBody
	public ResponseEntity<Optional<Incidents>> getById(@RequestParam Long id){
		Optional<Incidents> incident;
		try {
			incident = incidentsRepository.findById(id);
			return new ResponseEntity<Optional<Incidents>>(incident,HttpStatus.OK); 
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Incidents>>(HttpStatus.NOT_FOUND); 
		}				
	}
	
	@DeleteMapping(value ="delete")
	public ResponseEntity<Optional<Incidents>> deleteById(@RequestParam Long id){
		try {
			incidentsRepository.deleteById(id);
			return new ResponseEntity<Optional<Incidents>>(HttpStatus.OK); 
		}catch (NoSuchElementException e) {
			return new ResponseEntity<Optional<Incidents>>(HttpStatus.NOT_FOUND); 
		}				
	}
	
	@PutMapping(value= "update")
	public ResponseEntity<Incidents> update( @RequestBody Incidents newIncident){
		return incidentsRepository.findById(newIncident.getIdincident())
				.map(incident ->{
					 incident.setName(newIncident.getName());
					 incident.setDescription(newIncident.getDescription());
					 incident.setCreatedAt(newIncident.getCreatedAt());
					 incident.setUpdateAt(new Date());
					 incident.setCloseAt(newIncident.getCloseAt());
					 Incidents incidentUpdate = incidentsRepository.save(incident);
					 return ResponseEntity.ok().body(incidentUpdate);
				}).orElse(ResponseEntity.notFound().build());
	}
	

}
