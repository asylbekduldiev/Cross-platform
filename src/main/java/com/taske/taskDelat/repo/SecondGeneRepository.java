package com.taske.taskDelat.repo;


import com.taske.taskDelat.model.NewGeneInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface SecondGeneRepository extends JpaRepository<NewGeneInfo,Long> {

    @Query(value="SELECT id,referral_diagnosis,phenotype,conclusion,notes,synthetic_conclusion FROM genes_infos WHERE phenotype = :phenotype",nativeQuery = true)
    List<Object[]> findByPhenotype(@Param("phenotype") String phenotype);
}
