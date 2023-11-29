package com.mibanco.generarpdfriesgo.ms.gen.type;

import com.mibanco.generarpdfriesgo.ms.gen.type.AnalisisVectorType;
import com.mibanco.generarpdfriesgo.ms.gen.type.EndeudamientoActualTotalType;
import com.mibanco.generarpdfriesgo.ms.gen.type.EndeudamientoActualType;
import com.mibanco.generarpdfriesgo.ms.gen.type.EndeudamientoGlobalType;
import com.mibanco.generarpdfriesgo.ms.gen.type.EvolucionDeudaType;
import com.mibanco.generarpdfriesgo.ms.gen.type.HabitoDePagoAbiertasType;
import com.mibanco.generarpdfriesgo.ms.gen.type.HabitoDePagoCerradasType;
import com.mibanco.generarpdfriesgo.ms.gen.type.HistoricoConsultaType;
import com.mibanco.generarpdfriesgo.ms.gen.type.PerfilSectorTotalType;
import com.mibanco.generarpdfriesgo.ms.gen.type.PerfilSectorType;
import com.mibanco.generarpdfriesgo.ms.gen.type.ResumenEndeudamientoGlobalType;
import com.mibanco.generarpdfriesgo.ms.gen.type.SaldosYMorasType;
import java.util.ArrayList;
import java.util.List;
import jakarta.validation.constraints.*;
import jakarta.validation.Valid;

import java.util.Objects;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.annotation.JsonTypeName;



@JsonTypeName("ConsultaDetalladaType")
@jakarta.annotation.Generated(value = "org.openapitools.codegen.languages.JavaJAXRSSpecServerCodegen", date = "2023-11-22T11:43:13.018607800-05:00[America/Bogota]")
public class ConsultaDetalladaType   {
  private @Valid List<AnalisisVectorType> analisisVector;
  private @Valid List<EndeudamientoActualType> endeudamientoActual;
  private @Valid EndeudamientoActualTotalType endeudamientoActualTotal;
  private @Valid List<EndeudamientoGlobalType> endeudamientoGlobal;
  private @Valid List<EvolucionDeudaType> evolucionDeuda;
  private @Valid List<HabitoDePagoAbiertasType> habitoDePagoAbiertas;
  private @Valid List<HabitoDePagoCerradasType> habitoDePagoCerradas;
  private @Valid List<HistoricoConsultaType> historicoConsulta;
  private @Valid List<PerfilSectorType> perfilSector;
  private @Valid List<PerfilSectorTotalType> perfilSectorTotal;
  private @Valid List<ResumenEndeudamientoGlobalType> resumenEndeudamientoGlobal;
  private @Valid List<SaldosYMorasType> saldosYMoras;

  /**
   **/
  public ConsultaDetalladaType analisisVector(List<AnalisisVectorType> analisisVector) {
    this.analisisVector = analisisVector;
    return this;
  }

  
  @JsonProperty("analisisVector")
  public List<AnalisisVectorType> getAnalisisVector() {
    return analisisVector;
  }

  @JsonProperty("analisisVector")
  public void setAnalisisVector(List<AnalisisVectorType> analisisVector) {
    this.analisisVector = analisisVector;
  }

  public ConsultaDetalladaType addAnalisisVectorItem(AnalisisVectorType analisisVectorItem) {
    if (this.analisisVector == null) {
      this.analisisVector = new ArrayList<>();
    }

    this.analisisVector.add(analisisVectorItem);
    return this;
  }

  public ConsultaDetalladaType removeAnalisisVectorItem(AnalisisVectorType analisisVectorItem) {
    if (analisisVectorItem != null && this.analisisVector != null) {
      this.analisisVector.remove(analisisVectorItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType endeudamientoActual(List<EndeudamientoActualType> endeudamientoActual) {
    this.endeudamientoActual = endeudamientoActual;
    return this;
  }

  
  @JsonProperty("endeudamientoActual")
  public List<EndeudamientoActualType> getEndeudamientoActual() {
    return endeudamientoActual;
  }

  @JsonProperty("endeudamientoActual")
  public void setEndeudamientoActual(List<EndeudamientoActualType> endeudamientoActual) {
    this.endeudamientoActual = endeudamientoActual;
  }

  public ConsultaDetalladaType addEndeudamientoActualItem(EndeudamientoActualType endeudamientoActualItem) {
    if (this.endeudamientoActual == null) {
      this.endeudamientoActual = new ArrayList<>();
    }

    this.endeudamientoActual.add(endeudamientoActualItem);
    return this;
  }

  public ConsultaDetalladaType removeEndeudamientoActualItem(EndeudamientoActualType endeudamientoActualItem) {
    if (endeudamientoActualItem != null && this.endeudamientoActual != null) {
      this.endeudamientoActual.remove(endeudamientoActualItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType endeudamientoActualTotal(EndeudamientoActualTotalType endeudamientoActualTotal) {
    this.endeudamientoActualTotal = endeudamientoActualTotal;
    return this;
  }

  
  @JsonProperty("endeudamientoActualTotal")
  public EndeudamientoActualTotalType getEndeudamientoActualTotal() {
    return endeudamientoActualTotal;
  }

  @JsonProperty("endeudamientoActualTotal")
  public void setEndeudamientoActualTotal(EndeudamientoActualTotalType endeudamientoActualTotal) {
    this.endeudamientoActualTotal = endeudamientoActualTotal;
  }

  /**
   **/
  public ConsultaDetalladaType endeudamientoGlobal(List<EndeudamientoGlobalType> endeudamientoGlobal) {
    this.endeudamientoGlobal = endeudamientoGlobal;
    return this;
  }

  
  @JsonProperty("endeudamientoGlobal")
  public List<EndeudamientoGlobalType> getEndeudamientoGlobal() {
    return endeudamientoGlobal;
  }

  @JsonProperty("endeudamientoGlobal")
  public void setEndeudamientoGlobal(List<EndeudamientoGlobalType> endeudamientoGlobal) {
    this.endeudamientoGlobal = endeudamientoGlobal;
  }

  public ConsultaDetalladaType addEndeudamientoGlobalItem(EndeudamientoGlobalType endeudamientoGlobalItem) {
    if (this.endeudamientoGlobal == null) {
      this.endeudamientoGlobal = new ArrayList<>();
    }

    this.endeudamientoGlobal.add(endeudamientoGlobalItem);
    return this;
  }

  public ConsultaDetalladaType removeEndeudamientoGlobalItem(EndeudamientoGlobalType endeudamientoGlobalItem) {
    if (endeudamientoGlobalItem != null && this.endeudamientoGlobal != null) {
      this.endeudamientoGlobal.remove(endeudamientoGlobalItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType evolucionDeuda(List<EvolucionDeudaType> evolucionDeuda) {
    this.evolucionDeuda = evolucionDeuda;
    return this;
  }

  
  @JsonProperty("evolucionDeuda")
  public List<EvolucionDeudaType> getEvolucionDeuda() {
    return evolucionDeuda;
  }

  @JsonProperty("evolucionDeuda")
  public void setEvolucionDeuda(List<EvolucionDeudaType> evolucionDeuda) {
    this.evolucionDeuda = evolucionDeuda;
  }

  public ConsultaDetalladaType addEvolucionDeudaItem(EvolucionDeudaType evolucionDeudaItem) {
    if (this.evolucionDeuda == null) {
      this.evolucionDeuda = new ArrayList<>();
    }

    this.evolucionDeuda.add(evolucionDeudaItem);
    return this;
  }

  public ConsultaDetalladaType removeEvolucionDeudaItem(EvolucionDeudaType evolucionDeudaItem) {
    if (evolucionDeudaItem != null && this.evolucionDeuda != null) {
      this.evolucionDeuda.remove(evolucionDeudaItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType habitoDePagoAbiertas(List<HabitoDePagoAbiertasType> habitoDePagoAbiertas) {
    this.habitoDePagoAbiertas = habitoDePagoAbiertas;
    return this;
  }

  
  @JsonProperty("habitoDePagoAbiertas")
  public List<HabitoDePagoAbiertasType> getHabitoDePagoAbiertas() {
    return habitoDePagoAbiertas;
  }

  @JsonProperty("habitoDePagoAbiertas")
  public void setHabitoDePagoAbiertas(List<HabitoDePagoAbiertasType> habitoDePagoAbiertas) {
    this.habitoDePagoAbiertas = habitoDePagoAbiertas;
  }

  public ConsultaDetalladaType addHabitoDePagoAbiertasItem(HabitoDePagoAbiertasType habitoDePagoAbiertasItem) {
    if (this.habitoDePagoAbiertas == null) {
      this.habitoDePagoAbiertas = new ArrayList<>();
    }

    this.habitoDePagoAbiertas.add(habitoDePagoAbiertasItem);
    return this;
  }

  public ConsultaDetalladaType removeHabitoDePagoAbiertasItem(HabitoDePagoAbiertasType habitoDePagoAbiertasItem) {
    if (habitoDePagoAbiertasItem != null && this.habitoDePagoAbiertas != null) {
      this.habitoDePagoAbiertas.remove(habitoDePagoAbiertasItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType habitoDePagoCerradas(List<HabitoDePagoCerradasType> habitoDePagoCerradas) {
    this.habitoDePagoCerradas = habitoDePagoCerradas;
    return this;
  }

  
  @JsonProperty("habitoDePagoCerradas")
  public List<HabitoDePagoCerradasType> getHabitoDePagoCerradas() {
    return habitoDePagoCerradas;
  }

  @JsonProperty("habitoDePagoCerradas")
  public void setHabitoDePagoCerradas(List<HabitoDePagoCerradasType> habitoDePagoCerradas) {
    this.habitoDePagoCerradas = habitoDePagoCerradas;
  }

  public ConsultaDetalladaType addHabitoDePagoCerradasItem(HabitoDePagoCerradasType habitoDePagoCerradasItem) {
    if (this.habitoDePagoCerradas == null) {
      this.habitoDePagoCerradas = new ArrayList<>();
    }

    this.habitoDePagoCerradas.add(habitoDePagoCerradasItem);
    return this;
  }

  public ConsultaDetalladaType removeHabitoDePagoCerradasItem(HabitoDePagoCerradasType habitoDePagoCerradasItem) {
    if (habitoDePagoCerradasItem != null && this.habitoDePagoCerradas != null) {
      this.habitoDePagoCerradas.remove(habitoDePagoCerradasItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType historicoConsulta(List<HistoricoConsultaType> historicoConsulta) {
    this.historicoConsulta = historicoConsulta;
    return this;
  }

  
  @JsonProperty("historicoConsulta")
  public List<HistoricoConsultaType> getHistoricoConsulta() {
    return historicoConsulta;
  }

  @JsonProperty("historicoConsulta")
  public void setHistoricoConsulta(List<HistoricoConsultaType> historicoConsulta) {
    this.historicoConsulta = historicoConsulta;
  }

  public ConsultaDetalladaType addHistoricoConsultaItem(HistoricoConsultaType historicoConsultaItem) {
    if (this.historicoConsulta == null) {
      this.historicoConsulta = new ArrayList<>();
    }

    this.historicoConsulta.add(historicoConsultaItem);
    return this;
  }

  public ConsultaDetalladaType removeHistoricoConsultaItem(HistoricoConsultaType historicoConsultaItem) {
    if (historicoConsultaItem != null && this.historicoConsulta != null) {
      this.historicoConsulta.remove(historicoConsultaItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType perfilSector(List<PerfilSectorType> perfilSector) {
    this.perfilSector = perfilSector;
    return this;
  }

  
  @JsonProperty("perfilSector")
  public List<PerfilSectorType> getPerfilSector() {
    return perfilSector;
  }

  @JsonProperty("perfilSector")
  public void setPerfilSector(List<PerfilSectorType> perfilSector) {
    this.perfilSector = perfilSector;
  }

  public ConsultaDetalladaType addPerfilSectorItem(PerfilSectorType perfilSectorItem) {
    if (this.perfilSector == null) {
      this.perfilSector = new ArrayList<>();
    }

    this.perfilSector.add(perfilSectorItem);
    return this;
  }

  public ConsultaDetalladaType removePerfilSectorItem(PerfilSectorType perfilSectorItem) {
    if (perfilSectorItem != null && this.perfilSector != null) {
      this.perfilSector.remove(perfilSectorItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType perfilSectorTotal(List<PerfilSectorTotalType> perfilSectorTotal) {
    this.perfilSectorTotal = perfilSectorTotal;
    return this;
  }

  
  @JsonProperty("perfilSectorTotal")
  public List<PerfilSectorTotalType> getPerfilSectorTotal() {
    return perfilSectorTotal;
  }

  @JsonProperty("perfilSectorTotal")
  public void setPerfilSectorTotal(List<PerfilSectorTotalType> perfilSectorTotal) {
    this.perfilSectorTotal = perfilSectorTotal;
  }

  public ConsultaDetalladaType addPerfilSectorTotalItem(PerfilSectorTotalType perfilSectorTotalItem) {
    if (this.perfilSectorTotal == null) {
      this.perfilSectorTotal = new ArrayList<>();
    }

    this.perfilSectorTotal.add(perfilSectorTotalItem);
    return this;
  }

  public ConsultaDetalladaType removePerfilSectorTotalItem(PerfilSectorTotalType perfilSectorTotalItem) {
    if (perfilSectorTotalItem != null && this.perfilSectorTotal != null) {
      this.perfilSectorTotal.remove(perfilSectorTotalItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType resumenEndeudamientoGlobal(List<ResumenEndeudamientoGlobalType> resumenEndeudamientoGlobal) {
    this.resumenEndeudamientoGlobal = resumenEndeudamientoGlobal;
    return this;
  }

  
  @JsonProperty("resumenEndeudamientoGlobal")
  public List<ResumenEndeudamientoGlobalType> getResumenEndeudamientoGlobal() {
    return resumenEndeudamientoGlobal;
  }

  @JsonProperty("resumenEndeudamientoGlobal")
  public void setResumenEndeudamientoGlobal(List<ResumenEndeudamientoGlobalType> resumenEndeudamientoGlobal) {
    this.resumenEndeudamientoGlobal = resumenEndeudamientoGlobal;
  }

  public ConsultaDetalladaType addResumenEndeudamientoGlobalItem(ResumenEndeudamientoGlobalType resumenEndeudamientoGlobalItem) {
    if (this.resumenEndeudamientoGlobal == null) {
      this.resumenEndeudamientoGlobal = new ArrayList<>();
    }

    this.resumenEndeudamientoGlobal.add(resumenEndeudamientoGlobalItem);
    return this;
  }

  public ConsultaDetalladaType removeResumenEndeudamientoGlobalItem(ResumenEndeudamientoGlobalType resumenEndeudamientoGlobalItem) {
    if (resumenEndeudamientoGlobalItem != null && this.resumenEndeudamientoGlobal != null) {
      this.resumenEndeudamientoGlobal.remove(resumenEndeudamientoGlobalItem);
    }

    return this;
  }
  /**
   **/
  public ConsultaDetalladaType saldosYMoras(List<SaldosYMorasType> saldosYMoras) {
    this.saldosYMoras = saldosYMoras;
    return this;
  }

  
  @JsonProperty("saldosYMoras")
  public List<SaldosYMorasType> getSaldosYMoras() {
    return saldosYMoras;
  }

  @JsonProperty("saldosYMoras")
  public void setSaldosYMoras(List<SaldosYMorasType> saldosYMoras) {
    this.saldosYMoras = saldosYMoras;
  }

  public ConsultaDetalladaType addSaldosYMorasItem(SaldosYMorasType saldosYMorasItem) {
    if (this.saldosYMoras == null) {
      this.saldosYMoras = new ArrayList<>();
    }

    this.saldosYMoras.add(saldosYMorasItem);
    return this;
  }

  public ConsultaDetalladaType removeSaldosYMorasItem(SaldosYMorasType saldosYMorasItem) {
    if (saldosYMorasItem != null && this.saldosYMoras != null) {
      this.saldosYMoras.remove(saldosYMorasItem);
    }

    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (o == null || getClass() != o.getClass()) {
      return false;
    }
    ConsultaDetalladaType consultaDetalladaType = (ConsultaDetalladaType) o;
    return Objects.equals(this.analisisVector, consultaDetalladaType.analisisVector) &&
        Objects.equals(this.endeudamientoActual, consultaDetalladaType.endeudamientoActual) &&
        Objects.equals(this.endeudamientoActualTotal, consultaDetalladaType.endeudamientoActualTotal) &&
        Objects.equals(this.endeudamientoGlobal, consultaDetalladaType.endeudamientoGlobal) &&
        Objects.equals(this.evolucionDeuda, consultaDetalladaType.evolucionDeuda) &&
        Objects.equals(this.habitoDePagoAbiertas, consultaDetalladaType.habitoDePagoAbiertas) &&
        Objects.equals(this.habitoDePagoCerradas, consultaDetalladaType.habitoDePagoCerradas) &&
        Objects.equals(this.historicoConsulta, consultaDetalladaType.historicoConsulta) &&
        Objects.equals(this.perfilSector, consultaDetalladaType.perfilSector) &&
        Objects.equals(this.perfilSectorTotal, consultaDetalladaType.perfilSectorTotal) &&
        Objects.equals(this.resumenEndeudamientoGlobal, consultaDetalladaType.resumenEndeudamientoGlobal) &&
        Objects.equals(this.saldosYMoras, consultaDetalladaType.saldosYMoras);
  }

  @Override
  public int hashCode() {
    return Objects.hash(analisisVector, endeudamientoActual, endeudamientoActualTotal, endeudamientoGlobal, evolucionDeuda, habitoDePagoAbiertas, habitoDePagoCerradas, historicoConsulta, perfilSector, perfilSectorTotal, resumenEndeudamientoGlobal, saldosYMoras);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("class ConsultaDetalladaType {\n");
    
    sb.append("    analisisVector: ").append(toIndentedString(analisisVector)).append("\n");
    sb.append("    endeudamientoActual: ").append(toIndentedString(endeudamientoActual)).append("\n");
    sb.append("    endeudamientoActualTotal: ").append(toIndentedString(endeudamientoActualTotal)).append("\n");
    sb.append("    endeudamientoGlobal: ").append(toIndentedString(endeudamientoGlobal)).append("\n");
    sb.append("    evolucionDeuda: ").append(toIndentedString(evolucionDeuda)).append("\n");
    sb.append("    habitoDePagoAbiertas: ").append(toIndentedString(habitoDePagoAbiertas)).append("\n");
    sb.append("    habitoDePagoCerradas: ").append(toIndentedString(habitoDePagoCerradas)).append("\n");
    sb.append("    historicoConsulta: ").append(toIndentedString(historicoConsulta)).append("\n");
    sb.append("    perfilSector: ").append(toIndentedString(perfilSector)).append("\n");
    sb.append("    perfilSectorTotal: ").append(toIndentedString(perfilSectorTotal)).append("\n");
    sb.append("    resumenEndeudamientoGlobal: ").append(toIndentedString(resumenEndeudamientoGlobal)).append("\n");
    sb.append("    saldosYMoras: ").append(toIndentedString(saldosYMoras)).append("\n");
    sb.append("}");
    return sb.toString();
  }

  /**
   * Convert the given object to string with each line indented by 4 spaces
   * (except the first line).
   */
  private String toIndentedString(Object o) {
    if (o == null) {
      return "null";
    }
    return o.toString().replace("\n", "\n    ");
  }


}

