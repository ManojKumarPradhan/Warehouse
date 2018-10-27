package com.app.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Uom;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class UomPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attcahment;filename=UOMS.pdf");
		List<Uom> uoms = (List<Uom>) model.get("uoms");
		PdfPTable headTable = new PdfPTable(1);
		headTable.setWidthPercentage(80);
		headTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell headCell = new PdfPCell(new Phrase("ALL UOM DATA"));
		headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headCell.setVerticalAlignment(Element.ALIGN_CENTER);
		headCell.setBackgroundColor(Color.LIGHT_GRAY);
		headTable.addCell(headCell);
		document.add(headTable);
		PdfPTable table = new PdfPTable(4);
		table.setWidthPercentage(80);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("TYPE"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("MODEL"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("DESCRIPTION"))));
		uoms.forEach(uom -> {
			table.addCell(uom.getId().toString());
			table.addCell(uom.getType());
			table.addCell(uom.getModel());
			table.addCell(uom.getDsc());
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
