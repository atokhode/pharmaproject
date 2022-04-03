package com.web.pharmacy;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.repository.CrudRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;


@SpringBootApplication
public class PharmacyApplication {

	public static void main(String[] args) {
		SpringApplication.run(PharmacyApplication.class, args);
	}

}

interface DrugDataRepository extends CrudRepository<DrugData, String>{}


@RestController
@RequestMapping("/drug")
class DrugDataApiRestController{
	private final DrugDataRepository drugDataRepository;

	public DrugDataApiRestController(DrugDataRepository drugDataRepository){
		this.drugDataRepository = drugDataRepository;
		this.drugDataRepository.saveAll(List.of(
				new DrugData("citro c", 20,20,10),
				new DrugData("Paracetamol", 20,20,10),
				new DrugData("Rapinol", 20,20,10)
		));
	}

	@GetMapping
	Iterable<DrugData> getAllDrugData(){
		return drugDataRepository.findAll();
	}

	@GetMapping("/{id}")
	Optional<DrugData> getDrugById(@PathVariable String id){
		return drugDataRepository.findById(id);
	}

	@PostMapping
	DrugData postDrugData(@RequestBody DrugData drugData){
		return drugDataRepository.save(drugData);
	}
}
