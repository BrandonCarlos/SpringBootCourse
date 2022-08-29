package br.com.alura.forum.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.alura.forum.modelo.Topico;

//Como é uma interface não precisaremos colocar nenhuma annotation, aqui não precisa porque o Spring boot já encontra automáticamente
public interface TopicoRepository extends JpaRepository<Topico, Long> {//JpaRepository é um interface do Spring Data, parâmetros 1° entidade, 2° tipo do atributo do ID, CHAVE PRIMARIA
	//JpaRepository = já tem todos os método de carregar todos, salvar, excluir etc..
	
	//Agora este método findByCursoNome é novo então declaramos ele aqui, que recebe a QUERY(nomeCurso) = localhost:8080?nomecurso=Spring
	List<Topico> findByCursoNome(String nomeCurso);//Automáticamente fará uma QUERY no BD, assim SELECT * FROM TOPICO WHERE nomeCurso = QUERY(passado pelo usuario na URL)
	//e assim não precisaremos mais utilizar o JPQL
	
	//Se quisermos nos mesmos colocarmos outro nome no método, então vamos precisar escrever toda a QUERY em formato JPQL e ai atribuimos o parâmetro @Param vinculado com o :nomeCurso
//	@Query("SELECT t FROM Topico t WHERE t.curso.nome = :nomeCurso")//:nomeCurso <- vai vir lá da URL, ex: https://localhost:8080?cursoNome=Spring+Boot
//	List<Topico> carregarPorNomeDoCurso(@Param("nomeCurso") String nomeCurso);

	
	
}
 