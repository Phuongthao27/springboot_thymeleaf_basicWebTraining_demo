package com.bsd.demo.service;

import com.bsd.demo.domain.Student;
import com.bsd.demo.dto.StudentDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 *Interface khai báo các hàm chức năng nghiệp vụ của lớp sinh viên
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Service
public interface StudentService {
    /**
     * Hàm thêm mới một danh sinh viên
     * @param dto Danh sách sinh viên
     * @return Danh sách sinh viên
     */
    List<StudentDto> saveList (List<StudentDto> dto);

    /**
     * Hàm check trùng lặp sinh viên trong database
     * @param dto trả về một sinh viên
     * @return true nếu sinh viên với nhập vào không bị trùng lặp tên và ngày tháng năm sinh với sinh viên
     * trong cơ sở dữ liệu  và trả về  false nếu bị trùng lặp
     */
    Boolean InputCheck(StudentDto dto);
}
