package com.app.view;

import java.awt.Color;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.view.document.AbstractPdfView;

import com.app.model.Item;
import com.lowagie.text.Document;
import com.lowagie.text.Element;
import com.lowagie.text.Phrase;
import com.lowagie.text.pdf.PdfPCell;
import com.lowagie.text.pdf.PdfPTable;
import com.lowagie.text.pdf.PdfWriter;

public class ItemPdfView extends AbstractPdfView {

	@SuppressWarnings("unchecked")
	@Override
	protected void buildPdfDocument(Map<String, Object> model, Document document, PdfWriter writer,
			HttpServletRequest request, HttpServletResponse response) throws Exception {

		response.addHeader("Content-Disposition", "attcahment;filename=ITEMs.pdf");
		List<Item> items = (List<Item>) model.get("items");
		PdfPTable headTable = new PdfPTable(1);
		headTable.setWidthPercentage(95);
		headTable.setHorizontalAlignment(Element.ALIGN_CENTER);
		PdfPCell headCell = new PdfPCell(new Phrase("ALL ITEMS DATA"));
		headCell.setHorizontalAlignment(Element.ALIGN_CENTER);
		headCell.setVerticalAlignment(Element.ALIGN_CENTER);
		headCell.setBackgroundColor(Color.LIGHT_GRAY);
		headTable.addCell(headCell);
		document.add(headTable);
		PdfPTable table = new PdfPTable(11);
		table.setWidthPercentage(95);
		table.setHorizontalAlignment(Element.ALIGN_CENTER);
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("ID"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Code"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Height"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Length"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Width"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Cost"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Currency"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("UOM"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Sale"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Purchase"))));
		table.addCell(getModifiedFactoryCell(new PdfPCell(new Phrase("Note"))));
		items.forEach(item -> {
			table.addCell(item.getId().toString());
			table.addCell(item.getItemCode());
			table.addCell(item.getHeight().toString());
			table.addCell(item.getLength().toString());
			table.addCell(item.getWidth().toString());
			table.addCell(item.getItemCost().toString());
			table.addCell(item.getCurrency());
			table.addCell(item.getUom().getModel());
			table.addCell(item.getSaleType().getMode());
			table.addCell(item.getPurchaseType().getMode());
			table.addCell(item.getDsc());
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
