package com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.contract;


import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlInput;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.HistorialCreditoBaseArchivoXmlOutput;
import net.sf.jasperreports.engine.JRException;

import javax.xml.bind.JAXBException;
import java.io.IOException;

public interface IGenerarPdfHistorialCrediticioDetalladoMiBancoService {
    HistorialCreditoBaseArchivoXmlOutput generarPDFHistorialCreditoBaseArchivoXml(HistorialCreditoBaseArchivoXmlInput input) throws IOException, JAXBException, JRException;
}
