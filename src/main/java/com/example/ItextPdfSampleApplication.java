package com.example;

import java.io.FileOutputStream;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.itextpdf.text.Chunk;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Font;
import com.itextpdf.text.Paragraph;
import com.itextpdf.text.pdf.BaseFont;
import com.itextpdf.text.pdf.PdfWriter;

@SpringBootApplication
public class ItextPdfSampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(ItextPdfSampleApplication.class, args);

		try {
			Document document = new Document();
			PdfWriter.getInstance(document, new FileOutputStream("iTextHelloWorld.pdf"));

			document.open();

			BaseFont baseFont = BaseFont.createFont("Poppins-Regular.ttf", BaseFont.WINANSI, BaseFont.NOT_EMBEDDED);
			Font headerFont = new Font(baseFont, 14);
			headerFont.setColor(86, 142, 239);

			Paragraph paragraph1 = new Paragraph("Daily report for Kaylynn Curtis", headerFont);
			paragraph1.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph1);

			Paragraph paragraph2 = new Paragraph("on Sept 03, 2020", headerFont);
			paragraph2.setAlignment(Element.ALIGN_CENTER);
			document.add(paragraph2);

			document.add(Chunk.NEWLINE);
			document.add(Chunk.NEWLINE);

			Font titleFont = new Font(baseFont, 16, Font.BOLD);
			titleFont.setColor(86, 142, 239);

			Chunk notesTitle = new Chunk("Notes:", titleFont);
			document.add(notesTitle);

			document.add(Chunk.NEWLINE);

			Font valueFont = new Font(baseFont, 14);
			valueFont.setColor(67, 76, 142);

			Chunk note1 = new Chunk(
					"Did a really great job sharing with the other kids today!Please bring in the following items:",
					valueFont);
			Chunk note2 = new Chunk("pull-ups", valueFont);
			Chunk note3 = new Chunk("wipes", valueFont);
			document.add(note1);
			document.add(note2);
			document.add(note3);

			document.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
