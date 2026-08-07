package org.example.SQL;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class VehiculoSql
{
    private int id;
    private String placa;
    private String tipo;
    private int horas;
    private double tarifa;

    public VehiculoSql(int id, String placa, String tipo, int horas, double tarifa)
    {
        this.id = id;
        this.placa = placa;
        this.tipo = tipo;
        this.horas = horas;
        this.tarifa = tarifa;
    }

    public VehiculoSql(String placa, String tipo, int horas, double tarifa)
    {
        this.placa = placa;
        this.tipo = tipo;
        this.horas = horas;
        this.tarifa = tarifa;
    }




    public int save() throws Exception
    {
        String sql = "INSERT INTO Vehiculo (placa, tipo, horas, tarifa) VALUES (?,?,?,?)";

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS))
        {

            stmt.setString(1, this.placa);
            stmt.setString(2, this.tipo);
            stmt.setInt(3, this.horas);
            stmt.setDouble(4, this.tarifa);

            int funcion = stmt.executeUpdate();
            if (funcion > 0)
            {
                try (ResultSet rs = stmt.getGeneratedKeys())
                {
                    if (rs.next()) {
                        this.id = rs.getInt(1);
                    }
                }
            }
            return funcion;
        }
    }

    public static int deletebyId(int id) throws Exception
    {
        try( Connection con= Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement("DELETE FROM Vehiculo where id = ?");
        ) {
            stmt.setInt(1, id);
            return stmt.executeUpdate();
        }
    }

    public static List<VehiculoSql> getAllMotos(String tipo) throws Exception {
        String sql = "SELECT * FROM VehiculoSql where tipo = ?";
        List<VehiculoSql> listaMotos = new ArrayList<>();

        try (Connection con = Conexion.getConexion();
             PreparedStatement stmt = con.prepareStatement(sql))
        {
            stmt.setString(1, tipo);

            ResultSet rs = stmt.executeQuery();
            while (rs.next())
            {
                listaMotos.add(new VehiculoSql(
                        rs.getInt("id"),
                        rs.getString("placa"),
                        rs.getString("tipo"),
                        rs.getInt("horas"),
                        rs.getDouble("tarifa")));
            }
            return listaMotos;
        }
    }



    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getPlaca() { return placa; }
    public void setPlaca(String placa) { this.placa = placa; }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public int getHoras() { return horas; }
    public void setHoras(int horas) { this.horas = horas; }

    public double getTarifa() { return tarifa; }
    public void setTarifa(double tarifa) { this.tarifa = tarifa; }
}
