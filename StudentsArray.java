package labs;

import java.util.Scanner;

public class StudentsArray {

    /*public static void main(String[] args) {
        Students bi2 = new Students();
        String[][] rating = bi2.assigh();
        for (int i = 0; i < rating.length; i++) {
            for (int j = 0; j < rating.length; j++)
                System.out.print(rating[i][j]);
            System.out.println();
        }
    }*/
//студент - объект
}

class Students /* implements Sort*/ {

    String[][] student = new String[2][2];

    Students() {
        student[0][0] = "Кургузикова Дарья";
        student[0][1] = "0.0";
        student[1][0] = "Зимина Юлия";
        student[1][1] = "5.0";
    }

    //@Override
   /* public void insertsort() {
        for (int i = 1; i < student.length; i++)
            for (int b = student.length - 1; b >= i; b--)
                if (Double.parseDouble(student[b - 1][1]) < Double.parseDouble(student[b][1])) {
                    String[] t = student[b - 1];
                    student[b - 1] = student[b];
                    student[b] = t;
                }
    }*/

    /*String[][] assigh() {
        insertsort();
        return student;
    }
*/
}


