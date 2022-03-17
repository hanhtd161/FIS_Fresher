package fis.java.exc01;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.FormulaEvaluator;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class Record {
	public static final int COLUMN_INDEX_ID = 0;
	public static final int COLUMN_INDEX_ACCOUNT_NUMBER = 1;
	public static final int COLUMN_INDEX_MESSAGE = 2;
	public static final int COLUMN_INDEX_AMOUNT = 3;
	public static final int COLUMN_INDEX_DATE = 4;
	
	private List<Transaction> transactions = new ArrayList<>();

	public Record() {
	}
	
	// Kiem tra so tien chuyen vao tu so tai khoan gui "accountNumber" bat dau tu ngay "date" tro di co dat "amount"
	public boolean checkTransaction(String accountNumber,double amount,Date date) {
		double totalAmount = this.transactions.stream()
				.filter(t -> accountNumber.equals(t.getAccountNumberSender())&& t.getDate().after(date))
				.map(t -> t.getAmount())
				.mapToDouble(Double::valueOf)
				.sum();
		
		return totalAmount >= amount;
	}
	public void test() {
		System.out.println(transactions.get(0));
	}
	
	final String filePath = "E:\\FIS_Fresher\\Topic_03\\src\\fis\\java\\exc01\\Book1.xlsx";
	
	public void setTransactionsByReadExcelFile() {
		try(InputStream inputStream = new FileInputStream(filePath);){
			Workbook workbook = getWorkbook(inputStream, filePath);
			Sheet sheet = workbook.getSheetAt(0);
			Iterator<Row> rowIterator = sheet.iterator();
			while(rowIterator.hasNext()) {
				Row row = rowIterator.next();
				if(row.getRowNum() == 0) {
					continue;
				}
				Iterator<Cell> cellIterator = row.iterator();
				Transaction transaction = new Transaction();
				while(cellIterator.hasNext()) {
					Cell cell = cellIterator.next();
					Object cellValue = getCellValue(cell);
					if (cellValue == null || cellValue.toString().isEmpty()) {
	                    continue;
	                }
					int columIndex = cell.getColumnIndex();
					switch (columIndex){
					case COLUMN_INDEX_ID: {
						transaction.setId(new BigDecimal((double) cellValue).intValue());
						break;
					}
					case COLUMN_INDEX_ACCOUNT_NUMBER: {
						transaction.setAccountNumberSender(String.valueOf((int)((double) cellValue)));
						break;
					}
					case COLUMN_INDEX_MESSAGE: {
						transaction.setMessage((String) cellValue);
						break;
					}
					case COLUMN_INDEX_AMOUNT: {
						transaction.setAmount((double) cellValue);
						break;
					}
					case COLUMN_INDEX_DATE: {
						transaction.setDate(cell.getDateCellValue());
						break;
					}
					default:
						break;
					}
				}
				this.transactions.add(transaction);
			}
		}
		catch (IOException e) {
	
		}
		
	}
	public Workbook getWorkbook(InputStream inputStream, String excelFilePath) throws IOException {
        Workbook workbook = null;
        if (excelFilePath.endsWith("xlsx")) {
            workbook = new XSSFWorkbook(inputStream);
        } else if (excelFilePath.endsWith("xls")) {
            workbook = new HSSFWorkbook(inputStream);
        } else {
            throw new IllegalArgumentException("The specified file is not Excel file");
        }
 
        return workbook;
    }
	public Object getCellValue(Cell cell) {
        CellType cellType = cell.getCellType();
        Object cellValue = null;
        switch (cellType) {
        case BOOLEAN:
            cellValue = cell.getBooleanCellValue();
            break;
        case FORMULA:
            Workbook workbook = cell.getSheet().getWorkbook();
            FormulaEvaluator evaluator = workbook.getCreationHelper().createFormulaEvaluator();
            cellValue = evaluator.evaluate(cell).getNumberValue();
            break;
        case NUMERIC:
            cellValue = cell.getNumericCellValue();
            break;
        case STRING:
            cellValue = cell.getStringCellValue();
            break;
        case _NONE:
        case BLANK:
        case ERROR:
            break;
        default:
            break;
        }
 
        return cellValue;
    }	
}
