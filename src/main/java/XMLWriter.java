import lombok.extern.log4j.Log4j;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Date;

@Log4j
public class XMLWriter {
    private XMLWriter() {

    }

    public static void makeXML(AllInfo allInfo) throws JAXBException {
        log.debug("Конвертация в xml стартовала");
        JAXBContext jaxbContext = JAXBContext.newInstance(AllInfo.class);
        Marshaller marshaller = jaxbContext.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
        try {
            Files.createDirectory(Paths.get("xmlReqs"));
        } catch (IOException e) {
            log.debug("Директория уже существует" + " " + e);
        }

        File fileToWrite = new File("xmlReqs/infoReq" + new Date().getTime() + ".xml");

        marshaller.marshal(allInfo, fileToWrite);

        log.debug("Конвертация в xml завершена");

    }
}
