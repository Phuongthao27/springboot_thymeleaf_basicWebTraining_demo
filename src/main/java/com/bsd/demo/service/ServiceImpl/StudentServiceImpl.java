package com.bsd.demo.service.ServiceImpl;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.domain.Student;
import com.bsd.demo.dto.StudentDto;
import com.bsd.demo.repository.ClassRepository;
import com.bsd.demo.repository.StudentRepository;
import com.bsd.demo.service.StudentService;
import org.aspectj.apache.bcel.classfile.SourceFile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
/**
 * Lớp thực thi những hàm chức năng đã khai báo trong interface StudentService
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Service
public class StudentServiceImpl implements StudentService {
    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ClassRepository classRepository;


    /**
     *
     * Hàm thêm mới một danh sách sinh viên
     * Trả về một danh sách sinh viên được thêm mới thành công.
     * <p>
     * Hàm kiểm tra sinh viên được thêm mới có tồn tại trong cơ sở dữ liệu hay không
     * @param  dto  danh sách sinh viên
     * @return Giá trị null nếu không thỏa mãn điều kiện.
     * Trả về một danh sách sinh viên  nếu thêm vào cơ sở dữ liệu thành công
     */

    @Override
    public List<StudentDto> saveList(List<StudentDto> dto) {

        if(dto != null && dto.size()>0){

            List<StudentDto> studentDtoList = new ArrayList<>();
            Integer checkInput = 0;
            List<Student> studentList = new ArrayList<>();
            //kiểm tra trùng lặp db
            for(StudentDto var : dto) {
                if( var.getDateofbirth() !=  null) {
                    List<StudentDto> checkList = studentRepository.checkstudentNameAndDate(var.getFullname(), var.getDateofbirth());
                    if (checkList.size() > 0) {
                        checkInput++;
                    }
                }else {
                    return null;
                }
            }
            //insert dữ liệu vào db
            if(checkInput == 0){

                for(StudentDto var : dto){
                    Student entity = new Student();
                    Classes classes = null;
                    //lấy class id
                    if (var.getClass_id() != null && var.getClass_id().getId() != null) {
                        classes = classRepository.getById(var.getClass_id().getId());
                    }

                    entity.setClasses(classes);
                    entity.setFullname(var.getFullname());
                    entity.setDateofbirth(var.getDateofbirth());
                    entity.setSex(var.getSex());
                    entity.setPhone(var.getPhone());
                    entity.setNote(var.getNote());
                    entity = studentRepository.save(entity);
                    studentList.add(entity);
                }
            }

            if(studentList != null && studentList.size()>0){
                for(Student item : studentList){
                    StudentDto studentDto = new StudentDto(item,false);
                    studentDtoList.add(studentDto);

                }
                if(studentDtoList != null){
                    return studentDtoList;
                }

            }
        }

        return null;
    }

    /**
     * <p>
     * Kiểm tra sinh viên thêm vào có tên và ngày tháng năm sinh
     * trùng lặp với sinh viên đã tồn tại trong cơ sở dữ liệu hay không.
     * @param  dto  là một danh sách sinh viên
     * @return True nêu sinh viên thêm vào không bị trùng lặp
     *và trả về false nếu sinh viên đó đã bị trùng lặp
     */
    @Override
    public Boolean InputCheck(StudentDto dto) {
      if(dto != null){

          List<StudentDto> checkList = studentRepository.checkstudentNameAndDate(dto.getFullname(), dto.getDateofbirth());
          if (checkList.size() > 0){
              System.out.println("Trùng lặp dữ liệu!");
              return false;
          }else {
              return true;
          }

      }

        return false;
    }
}
