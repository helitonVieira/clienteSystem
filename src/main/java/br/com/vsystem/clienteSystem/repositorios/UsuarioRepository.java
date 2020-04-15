package br.com.vsystem.clienteSystem.repositorios;

import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import br.com.vsystem.clienteSystem.doman.Usuario;

@Repository
@Transactional
public interface UsuarioRepository extends CrudRepository<Usuario, Long>{

	@Query("select u from Usuario u where u.nom_usuario Like %?1% ")
	List<Usuario> findByNomUsuario(String nom_usuario);	
}


