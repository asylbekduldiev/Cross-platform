package com.taske.taskDelat.repo;

import com.taske.taskDelat.model.GeneInfo;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface GeneRepository extends JpaRepository<GeneInfo,Long> {

    //Optional<GeneInfo> findBySymbol(String gene);

    @Query(value = "SELECT \"VariationID\", \"GeneSymbol\", \"SyntheticConclusion\" FROM gene_info WHERE \"GeneSymbol\" = :geneSymbol",
            nativeQuery = true)
    List<Object[]> findIdAndNameAndSymbolByGeneSymbol(@Param("geneSymbol") String geneSymbol);


    // Фильтрация по клинической значимости
    @Query(value = "SELECT \"VariationID\", \"GeneSymbol\", \"SyntheticConclusion\" FROM gene_info WHERE \"ClinicalSignificance\" = :significance"
            ,nativeQuery = true)
    List<Object[] > findByClinicalSignificance(@Param("significance")String clinincSignificance);


    // Фильтрация по сборке
    @Query(value = "SELECT \"GeneSymbol\", \"SyntheticConclusion\" FROM gene_info WHERE \"Assembly\" = :assembly"
            ,nativeQuery = true)
    List<Object[]> findByAssembly(@Param("assembly") String assembly);


    List<GeneInfo> findByClinicalSignificanceAndAssembly(
            String clinicalSignificance,
            String assembly
    );


}
