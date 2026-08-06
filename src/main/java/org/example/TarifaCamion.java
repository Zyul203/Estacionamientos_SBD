package org.example;

    // Tarifa específica para Camiones ($4.00 por hora + $5.00 fijos)
    public class TarifaCamion implements TARIFA
    {
        @Override
        public double calcular(int horas)
        {
            return (horas * 4.0) + 5.0;
        }
    }

