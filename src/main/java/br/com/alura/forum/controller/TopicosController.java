package br.com.alura.forum.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.alura.forum.controller.dto.TopicoDto;
import br.com.alura.forum.modelo.Topico;
import br.com.alura.forum.repository.TopicoRepository;

@RestController //Assim já não precisamos mais colocar aquele @RequestBody pois o Eclipse já entende que é para isso mesmo
public class TopicosController {
	
	@Autowired //Para injetar esse repository, usamos está annotation, ou seja não precisamos dar NEW apenas desta maneira já temos o objeto para uso
	private TopicoRepository topicoRepository;
	
	@RequestMapping("/topicos")//Mapeando lá para /topicos
	//Vamos trazer os registros do banco de dados de verdade lá do H2
	public List<TopicoDto> lista(String nomeCurso) {//aqui é a QUERY, ex -> localhost:8080/topicos?nomeCurso=Spring <- esse "Spring" é enviado como QUERY
		System.out.println(nomeCurso);
		if (nomeCurso == null) {//se não passar nem uma QUERY na URL, retornar todos os Topicos
			List<Topico> topicos = topicoRepository.findAll();//método findAll() e vários outros métodos já vem do JpaRepository(interface), e assim vamos carregar todos os tópicos do banco de dados
			return TopicoDto.converter(topicos);
		} else {//se eu passar algo, ai busca atráves do nome do curso
			List<Topico> topicos = topicoRepository.findByCursoNome(nomeCurso);
			return TopicoDto.converter(topicos);
		}
	}

}
