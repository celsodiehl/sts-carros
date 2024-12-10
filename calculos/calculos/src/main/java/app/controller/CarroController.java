package app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import app.entity.Carro;
import app.service.CarroService;

@RestController
@RequestMapping("/api/carro")
public class CarroController {

	@Autowired
	private CarroService carroService;

	@PostMapping("/save")
	public ResponseEntity<String> save(@RequestBody Carro carro) {

		// TODA CLASSE CONTROLLER TEM QUE TER ESTRUTURA TRY CATCH
		try {
			String mensagem = this.carroService.save(carro);
			// SE DEU TUDO CERTO
			return new ResponseEntity<String>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<String>("Algo deu Errado ao Salvar", HttpStatus.BAD_REQUEST);
		}
	}

	@PutMapping("/update/{id}") // @PathVariable("id") Long id
	public ResponseEntity<String> update(@RequestBody Carro carro, @PathVariable("id") Long id) {
		try {
			String mensagem = this.carroService.update(carro, id);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(mensagem, HttpStatus.CREATED);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@DeleteMapping("/delete/{id}")
	public ResponseEntity<String> delete(@PathVariable("id") Long id) {
		try {
			String mensagem = this.carroService.delete(id);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(mensagem, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>("Algo deu Errado ao Excluir", HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findAll")
	public ResponseEntity<List<Carro>> findAll() {
		try {
			List<Carro> lista = this.carroService.findAll();
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findById/{id}")
	public ResponseEntity<Carro> findById(@PathVariable("id") Long id) {

		try {
			Carro carro = this.carroService.findById(id);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(carro, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByNome")
	public ResponseEntity<List<Carro>> findByNome(@RequestParam("nome") String nome) {

		try {
			List<Carro> lista = this.carroService.findByNome(nome);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

	@GetMapping("/findByMarca")
	public ResponseEntity<List<Carro>> findByMarca(@RequestParam("id") Long idMarca) {

		try {
			List<Carro> lista = this.carroService.findByMarca(idMarca);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}
	
	@GetMapping("/findAcimaAno")
	public ResponseEntity<List<Carro>> findAcimaAno(@RequestParam("ano") int ano) {

		try {
			List<Carro> lista = this.carroService.findAcimaAno(ano);
			// SE DEU TUDO CERTO
			return new ResponseEntity<>(lista, HttpStatus.OK);
		} catch (Exception e) {
			// SE DEU TUDO ERRADO
			return new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);
		}
	}

}
