package com.app.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import com.app.model.OrderMethod;

public class OrderMethodExcelView extends AbstractXlsxView {

	@Override
	protected void buildExcelDocument(Map<String, Object> model, Workbook workbook, HttpServletRequest request,
			HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attachment;filename=ORDERMETHODs.xlsx");
		Sheet sheet = workbook.createSheet("Orders");
		@SuppressWarnings("unchecked")
		List<OrderMethod> orderMethods = (List<OrderMethod>) model.get("orders");
		setHead(sheet);
		setBody(sheet, orderMethods);
	}

	private void setBody(Sheet sheet, List<OrderMethod> orderMethods) {
		int rownum = 1;
		for (OrderMethod orderMethod : orderMethods) {
			Row row = sheet.createRow(rownum++);
			row.createCell(0).setCellValue(orderMethod.getId());
			row.createCell(1).setCellValue(orderMethod.getMode());
			row.createCell(2).setCellValue(orderMethod.getCode());
			row.createCell(3).setCellValue(orderMethod.getMethod());
			row.createCell(4).setCellValue(orderMethod.getAccept().toString());
			row.createCell(5).setCellValue(orderMethod.getDsc());
		}
	}

	private void setHead(Sheet sheet) {
		Row row = sheet.createRow(0);
		row.createCell(0).setCellValue("ID");
		row.createCell(1).setCellValue("Mode");
		row.createCell(2).setCellValue("Code");
		row.createCell(3).setCellValue("Method");
		row.createCell(4).setCellValue("Accept");
		row.createCell(5).setCellValue("DESCRIPTION");
	}

}
