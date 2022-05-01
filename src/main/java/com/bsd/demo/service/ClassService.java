package com.bsd.demo.service;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.dto.ClassDto;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Interface khai báo các hàm chức năng nghiệp vụ của lớp lớp học
 *  @author GMO ThaoNTP1
 *  @version 1.0
 *  @since   2021-11-6
 */
@Service
public interface ClassService {
    /**
     * Hàm lấy toàn bộ class trong DB đổ vào pulldown list trong font-end
     * @return danh sách lớp học
     */


    List<Classes> getClasses();
}
