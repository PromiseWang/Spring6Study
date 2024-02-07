package org.example.spring6.iocxml.dimap;

import java.util.List;
import java.util.Map;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 00:05
 * Description:
 */

public class Student {
    private String studentId;
    private String studentName;

    private Map<String, Teacher> teacherMap;

    private List<Lesson> lessonList;

    public List<Lesson> getLessonList() {
        return lessonList;
    }

    public void setLessonList(List<Lesson> lessonList) {
        this.lessonList = lessonList;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public Map<String, Teacher> getTeacherMap() {
        return teacherMap;
    }

    public void setTeacherMap(Map<String, Teacher> teacherMap) {
        this.teacherMap = teacherMap;
    }

    public void run() {
        System.out.println("学生编号: " + studentId + "学生名: " + studentName);
        System.out.println(teacherMap);
        System.out.println(lessonList);
    }

    @Override
    public String toString() {
        return "Student{" +
                "studentId='" + studentId + '\'' +
                ", studentName='" + studentName + '\'' +
                ", teacherMap=" + teacherMap +
                '}';
    }


}
