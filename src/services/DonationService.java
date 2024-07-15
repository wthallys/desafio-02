package services;

import dao.DonationDAO;
import model.Donation;

import java.util.List;

public class DonationService {
    private DonationDAO donationDAO = new DonationDAO();

    public void addDonation(Donation donation) {
        donationDAO.insertDonation(donation);
    }

    public Donation getDonation(int id) {
        return donationDAO.selectDonation(id);
    }

    public List<Donation> getAllDonations() {
        return donationDAO.selectAllDonations();
    }

    public boolean updateDonation(Donation donation) {
        return donationDAO.updateDonation(donation);
    }

    public boolean deleteDonation(int id) {
        return donationDAO.deleteDonation(id);
    }
}
