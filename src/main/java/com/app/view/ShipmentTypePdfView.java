package com.app.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.ShipmentType;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ShipmentTypePdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attcahment;filename=SHIPMENTTYPEs.pdf");
		List<ShipmentType> shipmentTypes = (List<ShipmentType>) model.get("shipments");
		PdfPTable headTable = new PdfPTable(1);
		headTable.setWidthPercentage(90);
		headTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell headCell = new PdfPCell(new Phrase("ALL Shipment Type DATA"));
		headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headCell.setVerticalAlignment(Element.ALIGN_CENTER);
		headCell.setBackgroundColor(Color.LIGHT_GRAY);
		headTable.addCell(headCell);
		document.add(headTable);
		PdfPTable table = new PdfPTable(6);
		table.setWidthPercentage(90);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Mode"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Code"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Enable Shipment"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Grade"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("DESCRIPTION"))));
		shipmentTypes.forEach(shipmentType -> {
			table.addCell(shipmentType.getId().toString());
			table.addCell(shipmentType.getMode());
			table.addCell(shipmentType.getCode());
			table.addCell(shipmentType.getEnabled());
			table.addCell(shipmentType.getGrade());
			table.addCell(shipmentType.getDsc());
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