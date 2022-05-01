package com.bsd.demo.dto;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.domain.Student;
import lombok.Data;

import java.util.Set;

/**
 * Lớp dùng để trả về vừa đủ dữ liệu lớp học cho người dùng từ các Rest API mà không làm lộ dữ liệu nhạy cảm
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Data
public class ClassDto {
    private Integer id;
    private String name;
    private Set<StudentDto> studentDtoSet;

    /**
     *Constructor
     */
    public ClassDto(){};

    /**
     * Constructor khởi tạo một lớp học
     * @param entity Một lớp học
     */
    public ClassDto(Classes entity){
        this.id = entity.getId();
        this.name = entity.getName();

        if(entity.getStudent() != null && entity.getStudent().size()>0){
            for(Student student : entity.getStudent()){
                this.studentDtoSet.add(new StudentDto(student,false));
            }
        }

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
