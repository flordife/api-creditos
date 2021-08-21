package ar.com.ada.api.creditos.models.request;

import java.math.BigDecimal;
import java.util.Date;

public class InfoCancelacionNueva {
    
    public Integer prestamoId;
    public Date fechaCancelacion;
    public int numeroCuota;
    public BigDecimal importeCuota;
}
