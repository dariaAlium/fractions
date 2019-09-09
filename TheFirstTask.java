package labs;

import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
//import ua.com.prologistic.model.DataModel;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;


class DataModel {

    private String name;
    private String surname;
    Double mark;

    public DataModel(String name, String surname, Double mark) {
        this.name = name;
        this.surname = surname;
        this.mark = mark;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }


    public Double getMark() {
        return mark;
    }

    public void setMark(Double mark) {
        this.mark = mark;
    }

}

class TheFirstTask {
    public static void main(String[] args) throws ParseException {

        // создание самого excel файла в памяти
        HSSFWorkbook workbook = new HSSFWorkbook();
        // создание листа с названием "Просто лист"
        HSSFSheet sheet = workbook.createSheet("Просто лист");

        // заполняем список какими-то данными
        String[][] students = new String[3][3];
        students[0][0] = "Салазар";
        students[1][0] = "Слизерин";
        students[2][0] = "4.902";
        students[0][1] = "Рон";
        students[1][1] = "Уизли";
        students[2][1] = "3.602";
        /*for(int i=0;i<students.length;i++)
            for(int j=0;j<students.length;j++)
                System.out.println("student["+i+"]["+j+"]="+students[i][j]); */
        List<DataModel> dataList = fillData(students);

        // счетчик для строк
        int rowNum = 0;

        // создаем подписи к столбцам (это будет первая строчка в листе Excel файла)
        Row row = sheet.createRow(rowNum);
        row.createCell(0).setCellValue("Имя");
        row.createCell(1).setCellValue("Фамилия");
        row.createCell(2).setCellValue("Оценка");

        // заполняем лист данными
        for (DataModel dataModel : dataList) {
            createSheetHeader(sheet, ++rowNum, dataModel);
        }

        // записываем созданный в памяти Excel документ в файл
        try (FileOutputStream out = new FileOutputStream(new File("D:\\hi.xls"))) {
            workbook.write(out);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println("Excel файл успешно создан!");
    }

    // заполнение строки (rowNum) определенного листа (sheet)
    // данными  из dataModel созданного в памяти Excel файла
    private static void createSheetHeader(HSSFSheet sheet, int rowNum, DataModel dataModel) {
        Row row = sheet.createRow(rowNum);

        row.createCell(0).setCellValue(dataModel.getName());
        row.createCell(1).setCellValue(dataModel.getSurname());
        row.createCell(2).setCellValue(dataModel.getMark());

    }

    // заполняем список рандомными данными
    private static List<DataModel> fillData(String[][] students) {
        List<DataModel> dataModels = new ArrayList<>();
        dataModels.add(new DataModel(students[0][0], students[1][0], Double.parseDouble(students[2][0])));
        dataModels.add(new DataModel(students[0][1], students[1][1], Double.parseDouble(students[2][1])));
        DataModel[] data = new DataModel[dataModels.size()];
     //для себя: сортировка корректна
        for (int i = 0; i < dataModels.size(); i++)
            data[i] = dataModels.get(i);
        sort(data);
        dataModels.clear();
        for (int i = 0; i < dataModels.size(); i++)
            dataModels.add(data[i]);
        return dataModels;
    }

    public static void sort(DataModel[] array) {
        for (int i = 1; i < array.length; i++)
            for (int b = array.length - 1; b >= i; b--)
                if (array[b - 1].getMark() > array[b].getMark()) {
                    DataModel t = array[b - 1];
                    array[b - 1] = array[b];
                    array[b] = t;
                }
    }

}
