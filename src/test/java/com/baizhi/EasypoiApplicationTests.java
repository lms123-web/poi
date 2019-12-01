package com.baizhi;


import cn.afterturn.easypoi.excel.ExcelExportUtil;
import cn.afterturn.easypoi.excel.entity.ExportParams;
import com.baizhi.entity.GirlFriend;
import com.baizhi.entity.Student;
import com.baizhi.entity.Teacher;
import org.apache.poi.ss.usermodel.Workbook;
import org.junit.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@SpringBootTest
public class EasypoiApplicationTests {

    @Test
    public void contextLoads() {
        List<Student> students = new ArrayList<>();
        List<Teacher> teachers = new ArrayList<>();


        Student student = new Student("1", "小黑", "1");
        Student student1 = new Student("2", "小白", "2");
        students.add(student);
        students.add(student1);

        GirlFriend friend = new GirlFriend("小花花");
        GirlFriend friend1 = new GirlFriend("小乔");


        Teacher teacher = new Teacher("1", "流水", new Date(), students, friend,
                "D:\\cmfz\\easypoi1\\src\\main\\webapp\\img\\2.jpg");
        Teacher teacher1 = new Teacher("2", "人家", new Date(), students, friend1,
                "D:\\cmfz\\easypoi1\\src\\main\\webapp\\img\\106.jpg");

        teachers.add(teacher);
        teachers.add(teacher1);
        System.out.println(teacher);
        System.out.println(teacher1);
        Workbook sheets = ExcelExportUtil.exportExcel(new ExportParams("计算机一班", "老师", "bb"), Teacher.class, teachers);

        try {
            sheets.write(new FileOutputStream(new File("D:/easypoi.xls")));
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

}
