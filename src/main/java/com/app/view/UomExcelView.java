package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Uom;

public class UomExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=UOMS.xlsx");
		Sheet sheet = workbook.createSheet("uoms");
		@SuppressWarnings("unchecked")
		List<Uom> uoms = (List<Uom>) model.get("uoms");
		setHead(sheet);
		setBody(sheet, uoms);
	}

	private void setBody(Sheet sheet, List<Uom> uoms) {
		int rownum = 1;
		for (Uom uom : uoms) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(uom.getId());
			row.createCell(1).setCellValue(uom.getType());
			row.createCell(2).setCellValue(uom.getModel());
			row.createCell(3).setCellValue(uom.getDsc());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("TYPE");
		row.createCell(2).setCellValue("MODEL");
		row.createCell(3).setCellValue("DESCRIPTION");
	}

}
