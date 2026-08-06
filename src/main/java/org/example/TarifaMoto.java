package org.example;

    // Tarifa específica para Motos ($1.00 por hora)
    public class TarifaMoto implements TARIFA
    {
        @Override
        public double calcular(int horas)
        {
            return horas * 1.0;
        }
    }

