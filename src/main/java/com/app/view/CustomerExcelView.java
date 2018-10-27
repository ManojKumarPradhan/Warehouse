package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.Customer;

public class CustomerExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=CUSTOMERs.xlsx");
		Sheet sheet = workbook.createSheet("Customers");
		@SuppressWarnings("unchecked")
		List<Customer> customers = (List<Customer>) model.get("customers");
		setHead(sheet);
		setBody(sheet, customers);
	}

	private void setBody(Sheet sheet, List<Customer> customers) {
		int rownum = 1;
		for (Customer customer : customers) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(customer.getCustId());
			row.createCell(1).setCellValue(customer.getCustCode());
			row.createCell(2).setCellValue(customer.getCustAddr());
			row.createCell(3).setCellValue(customer.getCustLocs().toString());
			row.createCell(4).setCellValue(customer.getCustEnabled());
			row.createCell(5).setCellValue(customer.getCustEmail());
			row.createCell(6).setCellValue(customer.getCustContact());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Code");
		row.createCell(2).setCellValue("Address");
		row.createCell(3).setCellValue("Locations");
		row.createCell(4).setCellValue("Enabled");
		row.createCell(5).setCellValue("Email");
		row.createCell(6).setCellValue("Contact");
	}

}