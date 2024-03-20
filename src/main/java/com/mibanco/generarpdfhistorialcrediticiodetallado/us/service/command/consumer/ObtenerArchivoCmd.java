package com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.command.consumer;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.dao.entity.ArchivoEntity;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.facade.IArchivoUS;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.command.ICommand;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.service.command.IParam;
import com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.exceptions.ApplicationException;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import org.eclipse.microprofile.rest.client.inject.RestClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
public class ObtenerArchivoCmd implements ICommand {
    private final Logger logger = LoggerFactory.getLogger(ObtenerArchivoCmd.class);

    @Inject
    @RestClient
    IArchivoUS archivo;

    @Override
    public Object execute(IParam parametro) {
        try {
            logger.info("Inicia consultarViabilidadCrediticia GuardarArchivoCmd");

            if (!(parametro instanceof ArchivoEntity)) {
                logger.error("Error al ejecutar ObtenerArchivoCmd. El parámetro debe ser del tipo ArchivoEntity");
                throw new IllegalArgumentException("El parámetro debe ser del tipo ArchivoEntity");
            }

            ArchivoEntity archivoData = (ArchivoEntity) parametro;
            logger.info("Finaliza consultarViabilidadCrediticia GuardarArchivoCmd");
            return archivo.consultarArchivoPorUbicacion(archivoData.getRutaXml(), archivoData.getNombreArchivoXml());
        } catch (Exception e) {
            logger.error("Error al ejecutar GuardarArchivoCmd", e);
            throw new ApplicationException("Error al ejecutar GuardarArchivoCmd");
        }
    }


    @Override
    public Object execute() {
        return null;
    }
}
