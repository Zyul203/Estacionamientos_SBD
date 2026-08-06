package org.example;

    // Tarifa específica para Autos ($2.00 por hora)
    public class TarifaAuto implements TARIFA
    {
        @Override
        public double calcular(int horas)
        {
            return horas * 2.0;
        }
    }

