package com.app.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.WhUserType;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class WhUserTypePfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attcahment;filename=WarehouseUSERs.pdf");
		List<WhUserType> whUserTypes = (List<WhUserType>) model.get("users");
		PdfPTable headTable = new PdfPTable(1);
		headTable.setWidthPercentage(90);
		headTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell headCell = new PdfPCell(new Phrase("ALL Ware House USER DATA"));
		headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headCell.setVerticalAlignment(Element.ALIGN_CENTER);
		headCell.setBackgroundColor(Color.LIGHT_GRAY);
		headTable.addCell(headCell);
		document.add(headTable);
		PdfPTable table = new PdfPTable(9);
		table.setWidthPercentage(90);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Type"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Code"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ForType"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Email"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Contact"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID Type"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Other ID"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID Number"))));
		whUserTypes.forEach(order -> {
			table.addCell(order.getId().toString());
			table.addCell(order.getType());
			table.addCell(order.getCode());
			table.addCell(order.getForType());
			table.addCell(order.getEmail());
			table.addCell(order.getContact());
			table.addCell(order.getIdType());
			table.addCell(order.getIfOther());
			table.addCell(order.getIdNum());
		});
		document.add(table);
	}

	private PdfPCell getModifiedFactoryCell(PdfPCell cell) {
		cell.setHorizontalAlignment(Element.ALIGN_CENTER);
		cell.setVerticalAlignment(Element.ALIGN_CENTER);
		cell.setBackgroundColor(Color.CYAN);
		return cell;
	}
}