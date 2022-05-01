package com.bsd.demo.domain;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.util.Date;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "tbl_student")
/**
 * Lớp sinh viên được kết nối với bảng sinh viên trong cơ sở dữ liệu
 * Có trường id tự tăng
 * Có quan hệ n-1 với lớp lớp học
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
public class Student {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "class_id")
    @NotFound(action = NotFoundAction.IGNORE)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Classes classes;

    @NotBlank(
            message = "name {C-001}")
    @Column(name = "fullname")
    private String fullname;

    @Column(name = "sex")
    private String sex;

    @Column(name = "phone")
    private String phone;

    @Column(name = "note")
    private String note;
    @Column(name = "dateofbirth")
    private String dateofbirth;



}
