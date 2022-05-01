package com.bsd.demo.domain;

import lombok.*;
import org.hibernate.annotations.NotFound;
import org.hibernate.annotations.NotFoundAction;

import javax.persistence.*;
import java.util.Set;

@Entity
@Data

@Table(name = "tbl_class")
/**
 * Lớp lớp học được kết nối với bảng lớp học trong cơ sở dữ liệu
 * Có trường id tự tăng
 * Có quan hệ 1-n với lớp sinh viên
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since 2021-11-06
 */
public class Classes {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @EqualsAndHashCode.Exclude // không sử dụng trường này trong equals và hashcode
    @ToString.Exclude // Khoonhg sử dụng trong toString()
    private Integer id;

    @Column(name = "name")
    private String name;

    @OneToMany(fetch = FetchType.EAGER, cascade = CascadeType.ALL,mappedBy = "classes")

    private Set<Student> student;

}
