package cl.generador.generacartas.util;

import cl.generador.generacartas.exception.FormatoObjetoException;
import org.docx4j.model.fields.merge.DataFieldName;
import org.docx4j.model.fields.merge.MailMerger;
import org.docx4j.openpackaging.exceptions.Docx4JException;
import org.docx4j.openpackaging.packages.WordprocessingMLPackage;
import org.springframework.core.io.ClassPathResource;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.Map;

public class Util {

    private static final String FORMATO_FECHA = "dd-MM-yyyy";
    public static final String ARCHIVO_ENTRADA= "carta.docx";

    public byte[] generaArchivo(String ciudad, String destinatario, String direccionDestinatario, String correo, String remitente, String direccionRemitente) {

        Map<DataFieldName, String> item = new HashMap<>();

        item.put(new DataFieldName("Ciudad"), ciudad);
        item.put(new DataFieldName("Fecha"), generaFechaActual());
        item.put(new DataFieldName("Destinatario"), destinatario);
        item.put(new DataFieldName("DireccionDest"), direccionDestinatario);
        item.put(new DataFieldName("Correo"), correo);
        item.put(new DataFieldName("Remitente"), remitente);
        item.put(new DataFieldName("DireccionRemit"), direccionRemitente);

        try {
            return generaWord(item);
        } catch (Docx4JException | IOException e) {
            throw new FormatoObjetoException(e.getMessage());
        }

    }

    private byte[] generaWord(Map<DataFieldName, String> item) throws Docx4JException, IOException {

        WordprocessingMLPackage paqueteWord = WordprocessingMLPackage.load(new ClassPathResource(Util.ARCHIVO_ENTRADA).getInputStream());

        MailMerger.setMERGEFIELDInOutput(MailMerger.OutputField.KEEP_MERGEFIELD);
        MailMerger.performMerge(paqueteWord, item, true);

        ByteArrayOutputStream os = new ByteArrayOutputStream();
        paqueteWord.save(os);

        return os.toByteArray();

    }

    private static String generaFechaActual() {
        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDate localDate = localDateTime.toLocalDate();

        DateTimeFormatter formatters = DateTimeFormatter.ofPattern(FORMATO_FECHA);
        return localDate.format(formatters);
    }
}
