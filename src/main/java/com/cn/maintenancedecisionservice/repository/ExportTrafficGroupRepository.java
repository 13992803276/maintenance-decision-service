package com.cn.maintenancedecisionservice.repository;

import com.cn.maintenancedecisionservice.model.ExportTrafficGroup;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * @author lexu
 */
@Repository
public interface ExportTrafficGroupRepository extends JpaRepository<ExportTrafficGroup, String> {

    @Query(nativeQuery = true, value = "select *\n" +
            "from (\n" +
            "         select t.year,\n" +
            "                '交通量' as type,\n" +
            "                t.root_no,\n" +
            "                xxhc,\n" +
            "                zxhc,\n" +
            "                dxhc,\n" +
            "                tdhc,\n" +
            "                jzxc,\n" +
            "                zxkc,\n" +
            "                dkc\n" +
            "         from traffic t\n" +
            "         union all\n" +
            "         select t2.year,\n" +
            "                '增长率'                                                      as type,\n" +
            "                t2.root_no,\n" +
            "                concat(round((t2.xxhc - t1.xxhc) / t1.xxhc * 100, 2), '%') as xxhc,\n" +
            "                concat(round((t2.zxhc - t1.zxhc) / t1.zxhc * 100, 2), '%') as zxhc,\n" +
            "                concat(round((t2.dxhc - t1.dxhc) / t1.dxhc * 100, 2), '%') as dxhc,\n" +
            "                concat(round((t2.tdhc - t1.tdhc) / t1.tdhc * 100, 2), '%') as tdhc,\n" +
            "                concat(round((t2.jzxc - t1.jzxc) / t1.jzxc * 100, 2), '%') as jzxc,\n" +
            "                concat(round((t2.zxkc - t1.zxkc) / t1.zxkc * 100, 2), '%') as zxkc,\n" +
            "                concat(round((t2.dkc - t1.dkc) / t1.dkc * 100, 2), '%')    as dkc\n" +
            "         from traffic t1\n" +
            "                  inner join traffic t2\n" +
            "                             on t1.root_no = t2.root_no\n" +
            "                                 and t1.year + 1 = t2.year\n" +
            "         where t2.year > 2016\n" +
            "     ) p\n" +
            "where p.root_no = :rootNo \n" +
            "order by p.year\n")
    List<ExportTrafficGroup> getExportTrafficGroup(@Param("rootNo") String rootNo);
}
