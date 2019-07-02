package com.leandrooliveira.cursomc.repositories;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.leandrooliveira.cursomc.domain.Categoria;
import com.leandrooliveira.cursomc.domain.Produto;

@Repository
public interface ProdutoRepository extends JpaRepository<Produto, Integer>{
 
	/* Dá no mesmo 
	
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> search(@Param("nome") String nome, @Param("categorias") List<Categoria> caregorias, Pageable pageRequest);
	
	o @Query sobrepõe o nome do método então tbm dá no msm
	@Query("SELECT DISTINCT obj FROM Produto obj INNER JOIN obj.categorias cat WHERE obj.nome LIKE %:nome% AND cat IN :categorias")
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(@Param("nome") String nome, @Param("categorias") List<Categoria> caregorias, Pageable pageRequest);
	 */
	
	@Transactional(readOnly = true)
	Page<Produto> findDistinctByNomeContainingAndCategoriasIn(String nome, List<Categoria> caregorias, Pageable pageRequest);
}
