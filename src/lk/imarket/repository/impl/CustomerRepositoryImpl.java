package lk.imarket.repository.impl;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import lk.imarket.db.DBConnection;
import lk.imarket.dto.CustomerDto;
import lk.imarket.repository.CustomerRepository;

/**
 *
 * @author Hp
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    
    @Override
    public int addCustomer(CustomerDto customerDto) throws SQLException {
        int custId = 0;
        ResultSet rs = null;
        String sqlInsert = "INSERT INTO customer(cus_nic, cus_name, "
                + "dob, phone, email) "
                + "VALUES (?, ?, ?, ?, ?)";

        try (Connection con = new DBConnection().getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sqlInsert,
                Statement.RETURN_GENERATED_KEYS);) {
            
            pstmt.setString(1, customerDto.getCustomerNic());
            pstmt.setString(2, customerDto.getCustomerFirstName());
            pstmt.setDate(3, Date.valueOf(customerDto.getDateOfBirth()));
            pstmt.setString(4, customerDto.getPhone());
            pstmt.setString(5, customerDto.getEmai());

            int rowAffected = pstmt.executeUpdate();

            if (rowAffected == 1) {
                rs = pstmt.getGeneratedKeys();
                if (rs.next()) {
                    custId = rs.getInt(1);
                }
            }

        } finally {
             if (rs != null) {
                 rs.close();
             }
        }
        return custId;
    }

    @Override
    public List<CustomerDto> getAllCustomers() throws SQLException {
        List<CustomerDto> dtoList = new ArrayList<>();
        String sql = "SELECT * FROM customer";

        try (Connection con = new DBConnection().getConnection()) {

            Statement createStatement = con.createStatement();
            ResultSet rs = createStatement.executeQuery(sql);

            // loop through the result set
            while (rs.next()) {
                CustomerDto dto = new CustomerDto();

                dto.setCustomerId(rs.getInt("cus_id"));
                dto.setCustomerNic(rs.getString("cus_nic"));
                dto.setCustomerFirstName(
                        rs.getString("cus_name"));
                dto.setDateOfBirth(
                        String.valueOf(rs.getDate("dob")));
                dto.setPhone(rs.getString("phone"));
                dto.setEmai(rs.getString("email"));

                dtoList.add(dto);

            }

        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return dtoList;
    }

    @Override
    public CustomerDto getCustomerByNic(String nic) throws SQLException {
        String sql = " SELECT * FROM customer WHERE cus_nic = ?";

        try (Connection con = new DBConnection().getConnection(); 
                PreparedStatement pstmt = con.prepareStatement(sql)) {

            pstmt.setString(1, nic);

            ResultSet rs = pstmt.executeQuery();

            if (rs.next()) {
                CustomerDto dto = new CustomerDto();

                dto.setCustomerFirstName(
                        rs.getString("cus_name"));
                dto.setCustomerId(rs.getInt("cus_id"));
                dto.setDateOfBirth(rs.getString("dob"));
                dto.setPhone(rs.getString("phone"));
                dto.setEmai(rs.getString("email"));

                return dto;
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }

        return null;
    }

    @Override
    public CustomerDto getCustomerById(int id) throws SQLException {
       return null;
    }

    @Override
    public int updateCustomerByNic(String nic) throws SQLException {
        return 0;
    }

    @Override
    public int deleteCustomerByNic(String nic) throws SQLException {
        return 0;
    }

    @Override
    public int deleteCustomerById(int id) throws SQLException {
        return 0;
    }

}
