package dao;

import model.Donation;
import utils.DatabaseUtil;
import utils.DbException;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class DonationDAO {
    private static final String INSERT_DONATION_SQL = "INSERT INTO donations (itemType, itemDescription, itemExpirationDate, quantity, distributionCenter) VALUES (?, ?, ?, ?, ?)";
    private static final String SELECT_DONATION_BY_ID = "SELECT id, itemType, itemDescription, itemExpirationDate, quantity, distributionCenter FROM donations WHERE id = ?";
    private static final String SELECT_ALL_DONATIONS = "SELECT * FROM donations ORDER BY id";
    private static final String DELETE_DONATION_SQL = "DELETE FROM donations WHERE id = ?";
    private static final String UPDATE_DONATION_SQL = "UPDATE donations SET itemType = ?, itemDescription = ?, itemExpirationDate = ?, quantity = ?, distributionCenter = ? WHERE id = ?";

    SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

    public void insertDonation(Donation donation) {

        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(INSERT_DONATION_SQL);
            preparedStatement.setString(1, donation.getItemType());
            preparedStatement.setString(2, donation.getItemDescription());
            preparedStatement.setString(3, donation.getItemExpirationDate());
            preparedStatement.setInt(4, donation.getQuantity());
            preparedStatement.setInt(5, donation.getDistributionCenter());

            int rowsAffected = preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
    }

    public Donation selectDonation(int id) {
        Donation donation = null;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_DONATION_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet rs = preparedStatement.executeQuery();

            while (rs.next()) {
                String itemType = rs.getString("itemType");
                String itemDescription = rs.getString("itemDescription");
                String itemExpirationDate = rs.getString("itemExpirationDate");
                int quantity = rs.getInt("quantity");
                int distributionCenter = rs.getInt("distributionCenter");
                donation = new Donation(id, itemType, itemDescription, itemExpirationDate, quantity, distributionCenter);
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return donation;
    }

    public List<Donation> selectAllDonations() {
        List<Donation> donations = new ArrayList<>();
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(SELECT_ALL_DONATIONS);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String itemType = resultSet.getString("itemType");
                String itemDescription = resultSet.getString("itemDescription");
                String itemExpirationDate = resultSet.getString("itemExpirationDate");
                int quantity = resultSet.getInt("quantity");
                int distributionCenter = resultSet.getInt("distributionCenter");
                donations.add(new Donation(id, itemType, itemDescription, itemExpirationDate, quantity, distributionCenter));
            }
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return donations;
    }

    public boolean deleteDonation(int id) {
        boolean rowDeleted;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(DELETE_DONATION_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        }
        catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return rowDeleted;
    }

    public boolean updateDonation(Donation donation) {
        boolean rowUpdated;
        try {
            Connection connection = DatabaseUtil.getConnection();
            PreparedStatement statement = connection.prepareStatement(UPDATE_DONATION_SQL);
            statement.setString(1, donation.getItemType());
            statement.setString(2, donation.getItemDescription());
            statement.setString(3, donation.getItemExpirationDate());
            statement.setInt(4, donation.getQuantity());
            statement.setInt(5, donation.getDistributionCenter());
            statement.setInt(6, donation.getId());

            rowUpdated = statement.executeUpdate() > 0;
        } catch (SQLException e) {
            throw new DbException(e.getMessage());
        }
        return rowUpdated;
    }

}
