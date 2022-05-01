package com.bsd.demo.restController;

import com.bsd.demo.dto.StudentDto;
import com.bsd.demo.service.ClassService;
import com.bsd.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotEmpty;
import java.util.List;

//@Controller

/**
 * Lớp chứa các API của lớp sinh viên, nhận các yêu cầu từ người dùng và trả về kết quả
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Controller
@Validated
public class RestStudentController {
    @Autowired
    private StudentService studentService;
    @Autowired
    private ClassService classService;

    /**
     * API thêm mới danh sách sinh viên
     * @param dto Danh sách sinh viên
     * @return Danh sách sinh viên nếu thành công
     */
    @PostMapping("/listStudents")
    public ResponseEntity<List<StudentDto>> createListStudent(@RequestBody @NotEmpty(message = "Input movie list cannot be empty.") List< @Valid StudentDto> dto){
       List<StudentDto> result = studentService.saveList(dto);
        return new ResponseEntity<List<StudentDto>>(result, HttpStatus.OK);
    }


    /**
     * API kiểm tra sinh viên thêm vào có tên và ngày tháng năm sinh trùng lặp với sinh viên đã có trong cơ sở dữ liệu
     * @param dto Danh sách sinh viên
     * @return True nếu sinh viên đó không bị trùng lặp hoặc false nếu sinh viên đó bị trùng lặp
     */
    @PutMapping("inputCheck")
    public ResponseEntity<Boolean> check(@RequestBody StudentDto dto){

        Boolean result = studentService.InputCheck(dto);
        return new ResponseEntity<Boolean>(result, (result != null) ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
    }
}
