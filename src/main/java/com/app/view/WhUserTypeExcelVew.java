package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.WhUserType;

public class WhUserTypeExcelVew extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=WAREHOUSEUSERs.xlsx");
		Sheet sheet = workbook.createSheet("users");
		@SuppressWarnings("unchecked")
		List<WhUserType> whUserTypes = (List<WhUserType>) model.get("users");
		setHead(sheet);
		setBody(sheet, whUserTypes);
	}

	private void setBody(Sheet sheet, List<WhUserType> whUserTypes) {
		int rownum = 1;
		for (WhUserType whUserType : whUserTypes) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(whUserType.getId());
			row.createCell(1).setCellValue(whUserType.getType());
			row.createCell(2).setCellValue(whUserType.getCode());
			row.createCell(2).setCellValue(whUserType.getForType());
			row.createCell(2).setCellValue(whUserType.getEmail());
			row.createCell(2).setCellValue(whUserType.getContact());
			row.createCell(2).setCellValue(whUserType.getIdType());
			row.createCell(2).setCellValue(whUserType.getIfOther());
			row.createCell(3).setCellValue(whUserType.getIdNum());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Type");
		row.createCell(1).setCellValue("Code");
		row.createCell(1).setCellValue("For Type");
		row.createCell(1).setCellValue("Email");
		row.createCell(1).setCellValue("Contact");
		row.createCell(1).setCellValue("ID Type");
		row.createCell(2).setCellValue("If Other");
		row.createCell(3).setCellValue("Id Number");
	}

}
