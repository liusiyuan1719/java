import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFCell;
import java.io.FileOutputStream;
public class CreateOrderExcel {
    /** Excel 文件要存放的位置，假定在F盘下*/
    public static String outputFile = "D:\\1\\order.xls";
    public static void main(String argv[]) {
        try {
            // 创建新的Excel 工作簿
            HSSFWorkbook workbook = new HSSFWorkbook();
            // 在Excel工作簿中建一工作表，其名为缺省值
            // 如要新建一名为"效益指标"的工作表，其语句为：
            HSSFSheet sheet = workbook.createSheet("学生成绩");
            // 在索引0的位置创建行（最顶端的行）
            String xf[][] ={{"科目","分数"},{"语文","92"},{"数学","99"},{"英语","88"}};
            for(int i=0;i<xf.length;i++)
            {
                HSSFRow row = sheet.createRow((short)i);
                for (int j=0;j<xf[i].length;j++)
                {
                    HSSFCell cell01 = row.createCell((short)j);
                    cell01.setCellValue(xf[i][j]);
                }

            }
            FileOutputStream fOut = new FileOutputStream(outputFile);
            // 把相应的Excel 工作簿存盘
            workbook.write(fOut);
            fOut.flush();
            // 操作结束，关闭文件
            fOut.close();
            System.out.println("文件生成...");
        } catch (Exception e) {
            System.out.println("已运行 xlCreate() : " + e);
        }
    }
}
