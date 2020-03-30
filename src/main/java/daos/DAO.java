package daos;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DAO implements DAOInterface {

    public DTO findById(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car WHERE id=" + id);
            if(rs.next()){
                return extractDTOfromResultSet(rs);
            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public List findAll() {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery("SELECT * FROM car");
            List users = new ArrayList<DTO>();
            while(rs.next()){
                DTO user = extractDTOfromResultSet(rs);
                users.add(user);
            }
            return users;
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public Boolean update(DTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("UPDATE car SET make=?, model=?, year=?, color=?, vin=? WHERE id=?");
            ps.setString(1, dto.getMake());
            ps.setString(2, dto.getModel());
            ps.setInt(3,dto.getYear());
            ps.setString(4, dto.getColor());
            ps.setInt(5, dto.getVin());
            ps.setInt(6, dto.getId());
            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    public Boolean create(DTO dto) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement("INSERT INTO car VALUES (?, ?, ?, ?, ?, ?)");
            ps.setInt(1, dto.getId());
            ps.setString(2, dto.getMake());
            ps.setString(3, dto.getModel());
            ps.setInt(4, dto.getYear());
            ps.setString(5, dto.getColor());
            ps.setInt(6, dto.getVin());

            int i = ps.executeUpdate();
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }


    public Boolean delete(int id) {
        Connection connection = ConnectionFactory.getConnection();
        try {
            Statement stmt = connection.createStatement();
            int i = stmt.executeUpdate("DELETE FROM people WHERE id=" + id);
            if(i == 1) {
                return true;
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return false;
    }

    private DTO extractDTOfromResultSet(ResultSet rs) throws SQLException {
        DTO user = new DTO();
        user.setId( rs.getInt("id") );
        user.setMake( rs.getString("make") );
        user.setModel( rs.getString("model") );
        user.setYear( rs.getInt("year") );
        user.setColor(rs.getString("color"));
        user.setVin(rs.getInt("vin"));

        return user;
    }
}