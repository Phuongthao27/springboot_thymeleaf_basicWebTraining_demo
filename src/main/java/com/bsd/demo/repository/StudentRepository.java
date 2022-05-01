package com.bsd.demo.repository;

import com.bsd.demo.domain.Student;
import com.bsd.demo.dto.StudentDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Thao tác với bảng sinh viên trong cơ sở dữ liệu
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Repository
public interface StudentRepository extends JpaRepository<Student,Integer> {
    /**
     * Truy vấn dữ liệu lấy danh sách sinh viên có tên và ngày tháng năm sinh
     * trùng với tên và ngày tháng năm sinh truyền vào
     * @param name Tên sinh viên
     * @param date Ngày tháng năm sinh của sinh viên
     * @return Danh sách sinh viên
     */
    @Query(" select new com.bsd.demo.dto.StudentDto(entity,false ) from Student as entity where entity.fullname = ?1 and entity.dateofbirth = ?2")
    List<StudentDto> checkstudentNameAndDate(String name,String date);

}
