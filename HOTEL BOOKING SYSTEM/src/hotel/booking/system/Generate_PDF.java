/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hotel.booking.system;
import java.io.FileOutputStream;
import com.itextpdf.text.Document;
import com.itextpdf.text.Element;
import com.itextpdf.text.Image;
import com.itextpdf.text.Paragraph;

import com.itextpdf.text.pdf.PdfPCell;
import com.itextpdf.text.pdf.PdfPTable;
import com.itextpdf.text.pdf.PdfWriter;
import com.itextpdf.text.Font;
import com.itextpdf.text.FontFactory;
import java.text.SimpleDateFormat;
import java.util.Date;
import com.itextpdf.text.BaseColor;
import com.itextpdf.text.Phrase;

/**
 *
 * @author qi xian
 */
public class Generate_PDF {
    
    public void SavePdf(String bookingidx, String customerNamex, 
            String emailx, String roomxx, String checkindayxx, String durationxx, 
            String checkoutdayxx, String TotalChargexx, String Totalpaymentxx, String totalChangex ){
        try {
            String file_name = "BookingReceipt.pdf";
            Document document = new Document();
            
            PdfWriter.getInstance(document, new FileOutputStream(file_name));
            
            
            document.open();
               
                   
 
      // Setting font of the text       
       Font fontSize_16 =  FontFactory.getFont(FontFactory.TIMES, 30f);  
       Font f1 = new Font(Font.FontFamily.TIMES_ROMAN,18f);
       
       Font fontStyle_Bold =  FontFactory.getFont(FontFactory.TIMES, 18f);
            
            
            
            document.add(new Paragraph("Booking Invoice",fontSize_16 ));
            document.add(new Paragraph(" "));
            document.add(new Paragraph(new Date().toString()));
            document.add(new Paragraph("-------------------------------------------------------------------------"));
            document.add(new Paragraph(" "));
            PdfPTable table = new PdfPTable(2);  
            PdfPCell cell = new PdfPCell (new Paragraph("Invoice"));
            cell.setColspan(4);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            cell.setBackgroundColor(BaseColor.GREEN);
            
            
            table.setWidths(new int[]{300,520});
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Booking Id:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(bookingidx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Customer Name:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(customerNamex));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Customer Email:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(emailx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Booked Room:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(roomxx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase("Check In Day:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(checkindayxx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
             cell = new PdfPCell(new Phrase("Duration Of Staying (Day):"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(durationxx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
              
            cell = new PdfPCell(new Phrase("Check Out Day:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(checkoutdayxx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
             cell = new PdfPCell(new Phrase("Total Charges:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(TotalChargexx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
             cell = new PdfPCell(new Phrase("Total Payment:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(Totalpaymentxx));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
             cell = new PdfPCell(new Phrase("Total Change:"));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            cell = new PdfPCell(new Phrase(totalChangex));
            cell.setFixedHeight(45f);
            cell.setHorizontalAlignment(Element.ALIGN_CENTER);
            cell.setVerticalAlignment(Element.ALIGN_CENTER);
            table.addCell(cell);
            
            
            document.add(table);
             document.close();
            
            
        }catch (Exception e){
            System.err.println(e);
        }
    }
    
    
    
}
