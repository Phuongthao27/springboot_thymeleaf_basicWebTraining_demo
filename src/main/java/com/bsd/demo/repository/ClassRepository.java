package com.bsd.demo.repository;

import com.bsd.demo.domain.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Thao tác với bảng lớp học trong cơ sở dữ liệu
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Repository
public interface ClassRepository extends JpaRepository<Classes,Integer> {

}
