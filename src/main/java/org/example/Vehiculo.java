package org.example;

    public abstract class Vehiculo
    {
        protected String placa;
        protected int horasEstacionado;
        protected TARIFA tarifa;

        // Constructor obligatorio para los hijos
        public Vehiculo(String placa, int horasEstacionado, TARIFA tarifa)
        {
            this.placa = placa;
            this.horasEstacionado = horasEstacionado;
            this.tarifa = tarifa;
        }

        public String getPlaca() { return placa; }
        public int getHorasEstacionado() { return horasEstacionado; }


        // Metodo que delega el comportamiento
        public double calcularCostoEstacionamiento()
        {
            return tarifa.calcular(this.horasEstacionado);
        }


    }

