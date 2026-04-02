package src.model;

import java.math.BigDecimal;

// constante regra do banco
public class RegrasBanco {
    public static final BigDecimal LIMITE_DEPOSITO = new BigDecimal("10000");

    public static final BigDecimal LIMITE_SAQUE_DIARIO = new BigDecimal("2000");
    public static final BigDecimal LIMITE_TRASFERENCIA_DIARIO = new BigDecimal("5000");

}
