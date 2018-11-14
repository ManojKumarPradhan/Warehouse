package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Item;

public class ItemExcelView extends AbstractXlsxView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=ITEMs.xlsx");
		Sheet sheet = workbook.createSheet("Items");
		List<Item> items = (List<Item>) model.get("items");
		System.out.println(items.size());
		System.out.println(items.get(0).toString());
		setHead(sheet);
		setBody(sheet, items);
	}

	private void setBody(Sheet sheet, List<Item> items) {
		int rownum = 1;
		for (Item item : items) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(item.getId());
			row.createCell(1).setCellValue(item.getItemCode());
			row.createCell(2).setCellValue(item.getHeight());
			row.createCell(3).setCellValue(item.getLength());
			row.createCell(4).setCellValue(item.getWidth());
			row.createCell(5).setCellValue(item.getItemCost());
			row.createCell(6).setCellValue(item.getCurrency());
			row.createCell(7).setCellValue(item.getUom().getModel());
			row.createCell(8).setCellValue(item.getSaleType().getMode());
			row.createCell(9).setCellValue(item.getPurchaseType().getMode());
			row.createCell(10).setCellValue(item.getDsc());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Code");
		row.createCell(3).setCellValue("Height");
		row.createCell(2).setCellValue("Length");
		row.createCell(4).setCellValue("Width");
		row.createCell(5).setCellValue("Cost");
		row.createCell(6).setCellValue("Currency");
		row.createCell(7).setCellValue("UOM");
		row.createCell(8).setCellValue("Sale");
		row.createCell(9).setCellValue("Purchase");
		row.createCell(10).setCellValue("Note");
	}

}
