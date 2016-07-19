/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.ninjav.encryptpdf;

import com.itextpdf.text.DocumentException;
import com.itextpdf.text.pdf.PdfReader;
import com.itextpdf.text.pdf.PdfStamper;
import com.itextpdf.text.pdf.PdfWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import org.junit.Test;

/**
 *
 * @author ninjav
 */
public class EncryptPdfTest {
    public static byte[] USER = "user".getBytes();
    public static byte[] OWNER = "owner".getBytes();
 
    @Test
    public void canPasswordProtectPdf() throws DocumentException, IOException {
        String src = "/tmp/in.pdf";
        String dest = "/tmp/out.pdf";
        
        PdfReader reader = new PdfReader(src);
        PdfStamper stamper = new PdfStamper(reader, new FileOutputStream(dest));
        stamper.setEncryption(USER, OWNER,
            PdfWriter.ALLOW_PRINTING, PdfWriter.ENCRYPTION_AES_128 | PdfWriter.DO_NOT_ENCRYPT_METADATA);
        stamper.close();
        reader.close();        
    }
}
