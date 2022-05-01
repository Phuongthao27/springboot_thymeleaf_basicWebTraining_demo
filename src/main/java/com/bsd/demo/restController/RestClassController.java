package com.bsd.demo.restController;

import com.bsd.demo.domain.Classes;
import com.bsd.demo.domain.Student;
import com.bsd.demo.dto.ClassDto;
import com.bsd.demo.service.ClassService;
import com.bsd.demo.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Lớp chứa các API của lớp lớp học, nhận các yêu cầu từ người dùng và trả về kết quả
 * @author GMO ThaoNTP1
 * @version 1.0
 * @since   2021-11-06
 */
@Controller
public class RestClassController {
    @Autowired
    private ClassService classService;
    @Autowired
    StudentService studentService;

    /**
     * API trả về giao diện html
     *
     * @param model the model of class
     * @return trang html
     */
    @RequestMapping(path = "/classname", method = RequestMethod.GET)
    public String getClass(Model model){
        List<Classes> classes = classService.getClasses();
        model.addAttribute("classes",classes);
        return "StudentCreation-3";
    }

    /**
     * API lấy ra danh sách các lớp
     * @return danh sách lớp
     */
    @GetMapping(path = "/class")
    @ResponseBody
    public List<Classes> getclasses(){
        List<Classes> classes = classService.getClasses();
        return classes;
    }




}
