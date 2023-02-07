import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FileWriter {

    private FileWriter() {

    }

    public static void XLSXWriter (File file, List<Statistics> statisticsList) throws IOException {
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        XSSFWorkbook myBook = new XSSFWorkbook();
        XSSFSheet mySheet = myBook.createSheet("Статистика");

        Font myFontStyle = myBook.createFont();
        myFontStyle.setBold(true);
        myFontStyle.setFontHeightInPoints((short) 10);
        myFontStyle.setItalic(true);

        CellStyle cellStyle = myBook.createCellStyle();
        cellStyle.setFont(myFontStyle);
        cellStyle.setBorderBottom(BorderStyle.DOTTED);
        cellStyle.setBorderTop(BorderStyle.DOTTED);
        cellStyle.setBorderLeft(BorderStyle.DOTTED);
        cellStyle.setBorderRight(BorderStyle.DOTTED);


        int rowCounter = 0;
        Row row = mySheet.createRow(rowCounter);
        rowCounter++;
        Cell profileCellHeader = row.createCell(0);
        profileCellHeader.setCellValue("Профиль обучения");
        profileCellHeader.setCellStyle(cellStyle);
        Cell avgScoreCellHeader = row.createCell(1);
        avgScoreCellHeader.setCellStyle(cellStyle);
        avgScoreCellHeader.setCellValue("Средний балл за экзамены по профилю");
        Cell numberOfStudentsCellHeader = row.createCell(2);
        numberOfStudentsCellHeader.setCellStyle(cellStyle);
        numberOfStudentsCellHeader.setCellValue("Количество студентов по профилю");
        Cell numberOfUniversitiesCellHeader = row.createCell(3);
        numberOfUniversitiesCellHeader.setCellStyle(cellStyle);
        numberOfUniversitiesCellHeader.setCellValue("Количество университетов по профилю");
        Cell universitiesCellHeader = row.createCell(4);
        universitiesCellHeader.setCellValue("Университеты");
        universitiesCellHeader.setCellStyle(cellStyle);


        for (Statistics statistics:statisticsList){
            Row dataRow = mySheet.createRow(rowCounter);
            rowCounter++;
            Cell profileCell = dataRow.createCell(0);
            profileCell.setCellValue(statistics.getStudyProfile().getProfileName());
            Cell avgScoreCell = dataRow.createCell(1);
            avgScoreCell.setCellValue(statistics.getAvgExamScore());
            Cell numberOfStudentsCell = dataRow.createCell(2);
            numberOfStudentsCell.setCellValue(statistics.getStudentsCountByProfile());
            Cell numberOfUniversitiesCell = dataRow.createCell(3);
            numberOfUniversitiesCell.setCellValue(statistics.getUniCountByProfile());
            Cell universitiesCell = dataRow.createCell(4);
            universitiesCell.setCellValue(statistics.getUniNames());
        }

        myBook.write(fileOutputStream);
        fileOutputStream.close();
    }
}
