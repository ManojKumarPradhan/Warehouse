package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.ShipmentType;

public class ShipmentTypeExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=SHIPMENTTYPEs.xlsx");
		Sheet sheet = workbook.createSheet("Shipments");
		@SuppressWarnings("unchecked")
		List<ShipmentType> shipmentTypes = (List<ShipmentType>) model.get("shipments");
		setHead(sheet);
		setBody(sheet, shipmentTypes);
	}

	private void setBody(Sheet sheet, List<ShipmentType> shipmentTypes) {
		int rownum = 1;
		for (ShipmentType shipmentType : shipmentTypes) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(shipmentType.getId());
			row.createCell(1).setCellValue(shipmentType.getMode());
			row.createCell(2).setCellValue(shipmentType.getCode());
			row.createCell(2).setCellValue(shipmentType.getEnabled());
			row.createCell(2).setCellValue(shipmentType.getGrade());
			row.createCell(3).setCellValue(shipmentType.getDsc());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Mode");
		row.createCell(1).setCellValue("Code");
		row.createCell(1).setCellValue("Enabled");
		row.createCell(2).setCellValue("Grade");
		row.createCell(3).setCellValue("DESCRIPTION");
	}

}
