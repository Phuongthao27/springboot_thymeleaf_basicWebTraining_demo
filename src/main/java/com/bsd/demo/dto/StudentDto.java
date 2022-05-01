package com.bsd.demo.dto;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.domain.Student;
import lombok.Data;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.text.MessageFormat;
import java.util.Date;
import java.util.Properties;


 /**
 *Lớp dùng để trả về vừa đủ dữ liệu sinh viên cho người dùng từ các Rest API mà không làm lộ dữ liệu nhạy cảm
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06

 */
@Data
public class StudentDto {
    private ClassDto class_id;

    @NotBlank(
    message = "name {C-001}")
    @Size( max = 25 ,message = "{L-001}")
    private String fullname;
    @NotNull(message = "Date {C-001}")
    @DateTimeFormat(pattern = "dd/mm/yyyy")
    private String dateofbirth;
    @NotNull(message = "{Sex {C-001}}")
    private String sex;
    @NotNull(message = "Phone {C-001}")
    @Pattern(regexp = "0\\d{9}",message = "{P-001}")
    @Size( max = 10 ,message = "Phone {L-001}")
    private String phone;
    @Size(min =0, max = 50 ,message = "Note {L-001}")
    private String note;

    /**
     * The contructor of class
     */
    public StudentDto(){};

    /**
     * Constructor khởi tạo thông tin sinh viên
     * @param entity Một sinh viên
     * @param check Có muốn tạo một lớp mới khi khởi tạo sinh viên hay không
     */
    public StudentDto(Student entity,Boolean check){

        this.fullname = entity.getFullname();

        this.sex = entity.getSex();
        this.phone = entity.getPhone();
        this.note = entity.getNote();
        this.dateofbirth = entity.getDateofbirth();
        if(check) {
            this.class_id = new ClassDto(entity.getClasses());

        }
    }


}
