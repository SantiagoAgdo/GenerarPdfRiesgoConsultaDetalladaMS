package com.mibanco.generarpdfhistorialcrediticiodetallado.us.util.mappers;

import com.mibanco.generarpdfhistorialcrediticiodetallado.us.gen.type.*;
import jakarta.enterprise.context.ApplicationScoped;
import org.modelmapper.ModelMapper;

@ApplicationScoped
public class XMLMapper {

    public CalificacionCreditoYCarteraXmlEnum   numToCalificacion(String num){
        try {
            if (num == null || num.isEmpty() || num.equals("_0") || num.equals("_null")){
                return CalificacionCreditoYCarteraXmlEnum._10;
            }
            return new ModelMapper().map(num, CalificacionCreditoYCarteraXmlEnum.class);
        }catch (Exception e){
            return CalificacionCreditoYCarteraXmlEnum._10;
        }
    }

    public ClaseAhorroCorrienteXmlEnum codToTipoCuentaAhorro(String cod){
            return new ModelMapper().map(cod, ClaseAhorroCorrienteXmlEnum.class);
    }
    public GaranteXmlEnum codToGarante(String cod){
            return new ModelMapper().map(cod, GaranteXmlEnum.class);
    }

    public TipoDeCuentaEnum codToTipoCuenta(String cod){
        return new ModelMapper().map(cod, TipoDeCuentaEnum.class);
    }

    public EstadoCorrienteAhorroXmlEnum codToEstadoCuenta(String cod){
        return new ModelMapper().map(cod, EstadoCorrienteAhorroXmlEnum.class);
    }
   public EstadoDeCuentaXmlEnum codToEstadoCuentaTarjetaOCartera(String cod){
        return new ModelMapper().map(cod, EstadoDeCuentaXmlEnum.class);
    }

    public ClaseCreditoXmlEnum codToClaseTC(String cod){
        return new ModelMapper().map(cod, ClaseCreditoXmlEnum.class);
    }
    public FranquiciaCreditoXmlEnum codToFranquicia(String cod){
        return new ModelMapper().map(cod, FranquiciaCreditoXmlEnum.class);
    }

    public GatantiaXmlEnum codToGarantia(String cod){
        return new ModelMapper().map(cod, GatantiaXmlEnum.class);
    }

    public ModalidadPagoXmlEnum codToPeriodicidad(String cod){
        return new ModelMapper().map(cod, ModalidadPagoXmlEnum.class);
    }
    public ContratoObligacionXmlEnum codToContrato(String cod){
        return new ModelMapper().map(cod, ContratoObligacionXmlEnum.class);
    }

    public EstadoTitularEnum codToEstadoTitular(String cod){
        return new ModelMapper().map(cod, EstadoTitularEnum.class);
    }
    public GarantiaDeudaGlobalXmlEnum codToGarantiaGlobal(String cod){
        return new ModelMapper().map(cod, GarantiaDeudaGlobalXmlEnum.class);
    }

    public AdjetivoCreditoCarteraXmlEnum codToAdjetivo(String cod){
        return new ModelMapper().map(cod, AdjetivoCreditoCarteraXmlEnum.class);
    }

    public SectorXmlEnum codToSector(String cod){
        return new ModelMapper().map(cod, SectorXmlEnum.class);
    }

}
