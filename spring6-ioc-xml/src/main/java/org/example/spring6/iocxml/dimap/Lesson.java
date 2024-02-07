package org.example.spring6.iocxml.dimap;

/**
 * Author: Wang Xinran
 * Date: 2024-02-07 00:29
 * Description:
 */

public class Lesson {
    private String lessonName;

    public String getLessonName() {
        return lessonName;
    }

    public void setLessonName(String lessonName) {
        this.lessonName = lessonName;
    }

    @Override
    public String toString() {
        return "Lesson{" +
                "lessonName='" + lessonName + '\'' +
                '}';
    }
}
