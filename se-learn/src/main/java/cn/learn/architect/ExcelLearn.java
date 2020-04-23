package cn.learn.architect;

import java.io.File;
import java.io.FileOutputStream;
import org.apache.poi.common.usermodel.Hyperlink;
import org.apache.poi.common.usermodel.HyperlinkType;
import org.apache.poi.hssf.util.HSSFColor;
import org.apache.poi.ss.usermodel.CreationHelper;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFCellStyle;
import org.apache.poi.xssf.usermodel.XSSFFont;
import org.apache.poi.xssf.usermodel.XSSFHyperlink;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

/**
 * ProjectName : architect-learn
 * Description : []
 *
 * @author : Fly365
 * CreateDate : 2020年-03月-13日
 */
public class ExcelLearn {

    public static void main(String[] args) throws Exception {
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet spreadsheet = workbook.createSheet("Hyperlinks");
        XSSFCell cell;
        CreationHelper createHelper = workbook.getCreationHelper();
        XSSFCellStyle hlinkstyle = workbook.createCellStyle();
        XSSFFont hlinkfont = workbook.createFont();
        hlinkfont.setUnderline(XSSFFont.U_SINGLE);
        hlinkfont.setColor(HSSFColor.BLUE.index);
        hlinkstyle.setFont(hlinkfont);
        //URL Link
        cell = spreadsheet.createRow(1).createCell((short) 1);
        //cell.setCellValue("URL Link");
        cell.setCellValue("Absolutely pic Link");
        XSSFHyperlink link = (XSSFHyperlink)createHelper.createHyperlink(HyperlinkType.URL);
        //XSSFHyperlink link = (XSSFHyperlink)createHelper.createHyperlink(HyperlinkType.FILE);
        //link.setAddress("https://www.baidu.com/");
        /*link.setAddress("D:\\own_github\\java_code\\architect-learn\\timg.jpg");
        //cell.setHyperlink((XSSFHyperlink) link);
        cell.setHyperlink(link);
        cell.setCellStyle(hlinkstyle);*/
        //Hyperlink to a file in the current directory
        cell = spreadsheet.createRow(2).createCell((short) 1);
        cell.setCellValue("Relative pic Link");
        //Hyperlink.LINK_FILE
        link = (XSSFHyperlink)createHelper.createHyperlink(HyperlinkType.FILE);
        link.setAddress("./timg.jpg");
        cell.setHyperlink(link);
        cell.setCellStyle(hlinkstyle);
        //e-mail link
        /*cell = spreadsheet.createRow(3).createCell((short) 1);
        cell.setCellValue("Email Link");
        //Hyperlink.LINK_EMAIL
        link = (XSSFHyperlink)createHelper.createHyperlink(HyperlinkType.EMAIL);
        link.setAddress("mailto:contact@iowiki.com?" + "subject = Hyperlink");
        cell.setHyperlink(link);
        cell.setCellStyle(hlinkstyle);*/
        FileOutputStream out = new FileOutputStream(new File("hyperlink.xlsx"));
        workbook.write(out);
        out.close();
        System.out.println("hyperlink.xlsx written successfully");
    }

}
