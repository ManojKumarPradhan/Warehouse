package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Vendor;

public class VendorExcelVew extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=VENDORs.xlsx");
		Sheet sheet = workbook.createSheet("Vendor");
		@SuppressWarnings("unchecked")
		List<Vendor> vendors = (List<Vendor>) model.get("customers");
		setHead(sheet);
		setBody(sheet, vendors);
	}

	private void setBody(Sheet sheet, List<Vendor> vendors) {
		int rownum = 1;
		for (Vendor vendor : vendors) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(vendor.getId());
			row.createCell(1).setCellValue(vendor.getVenName());
			row.createCell(2).setCellValue(vendor.getVenCode());
			row.createCell(3).setCellValue(vendor.getVenDesg());
			row.createCell(4).setCellValue(vendor.getVenPreserve().toString());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Name");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("Designation");
		row.createCell(4).setCellValue("Preserve");
	}

}