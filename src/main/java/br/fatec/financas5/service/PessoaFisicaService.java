package br.fatec.financas5.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.fatec.financas5.model.PessoaFisica;
import br.fatec.financas5.repository.PessoaFisicaRepository;

@Service
public class PessoaFisicaService implements ServiceInterface<PessoaFisica> {
	
	@Autowired
	private PessoaFisicaRepository repository;
	
	//métodos
	@Override
	public PessoaFisica create(PessoaFisica obj) {
		repository.save(obj);
		return obj;
	}

	@Override
	public PessoaFisica findById(Long id) {
		Optional<PessoaFisica> obj = repository.findById(id);
		return obj.orElse(null);
	}

	@Override
	public List<PessoaFisica> findAll() {
		return repository.findAll();
	}

	@Override
	public boolean update(PessoaFisica obj) {
		if (repository.existsById(obj.getId())) {
			repository.save(obj);
			return true;
		}
		return false;
	}

	@Override
	public boolean delete(Long id) {
		if (repository.existsById(id)) {
			repository.deleteById(id);
			return true;
		}
		return false;
	}
}
