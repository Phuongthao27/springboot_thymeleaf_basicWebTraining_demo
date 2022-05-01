package com.bsd.demo.service.ServiceImpl;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.dto.ClassDto;
import com.bsd.demo.repository.ClassRepository;
import com.bsd.demo.service.ClassService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Lớp thực thi những hàm chức năng đã khai báo trong interface ClassService
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Service
public class ClassServiceImpl implements ClassService {
    @Autowired
    private ClassRepository classRepository;

    /**
     * Hàm lấy ra danh sách lớp học
     * @return danh sách lớp học
     *
     */

    @Override
    public List<Classes> getClasses() {
        List<Classes> classes = classRepository.findAll();
        if(classes!=null && classes.size()>0){
            return classes;
        }
        return  null;
    }

}
