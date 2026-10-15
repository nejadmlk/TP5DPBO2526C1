
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class PersonMenu {
    private JPanel mainPanel;
    private JLabel titleLabel;
    private JTable personTable;

    private JTextField idField;
    private JTextField namaField;
    private JTextField lahirField;
    private JTextField gmailField;

    private JComboBox<String> kategoriComboBox;

    private JButton addUpdateButton;
    private JButton deleteButton;
    private JButton cancelButton;

    private int selectedIndex = -1;
    private String selectedId = null;

    private Database database;

    public static void main(String[] args) {
        JFrame frame = new JFrame("Person Menu");
        PersonMenu personMenu = new PersonMenu();

        frame.setContentPane(personMenu.mainPanel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setSize(800, 600);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }

    public PersonMenu() {
        database = new Database();

        titleLabel.setFont(
                titleLabel.getFont().deriveFont(Font.BOLD, 20f)
        );

        String[] kategoriData = {
                "Mahasiswa",
                "Dosen",
                "Staf"
        };

        kategoriComboBox.setModel(
                new DefaultComboBoxModel<>(kategoriData)
        );

        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);

        personTable.setModel(setTable());

        addUpdateButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (selectedId == null) {
                    insertData();
                } else {
                    updateData();
                }
            }
        });

        deleteButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteData();
            }
        });

        cancelButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });

        personTable.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                selectedIndex = personTable.getSelectedRow();

                String CurId = personTable.getValueAt(selectedIndex, 0).toString();
                String CurNama = personTable.getValueAt(selectedIndex, 1).toString();
                String CurLahir = personTable.getValueAt(selectedIndex, 2).toString();
                String CurGmail = personTable.getValueAt(selectedIndex, 3).toString();
                String CurKategori = kategoriComboBox.getSelectedItem().toString();

                idField.setText(CurId);
                namaField.setText(CurNama);
                lahirField.setText(CurLahir);
                gmailField.setText(CurGmail);
                kategoriComboBox.setSelectedItem(CurKategori);

                addUpdateButton.setText("Update");

                deleteButton.setVisible(true);
            }
        });
    }

    // Mengambil data dari database dan menampilkan ke tabel
    public DefaultTableModel setTable() {
        String[] columnNames = {
                "ID",
                "Nama",
                "Tahun Lahir",
                "Kategori",
                "Gmail"
        };

        DefaultTableModel model = new DefaultTableModel(
                columnNames, 0
        ) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };

        String sql = "SELECT id, nama, thn_lahir, kategori, email " +
                "FROM person";

        try {
            ResultSet hasil = database.selectQuery(sql);

            while (hasil.next()) {
                Object[] data = {
                        hasil.getString("id"),
                        hasil.getString("nama"),
                        hasil.getInt("thn_lahir"),
                        hasil.getString("kategori"),
                        hasil.getString("email")
                };

                model.addRow(data);
            }

            hasil.close();

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal mengambil data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }

        return model;
    }

    // Memeriksa input sebelum insert atau update
    private boolean validasiInput() {
        String id = idField.getText().trim();
        String nama = namaField.getText().trim();
        String lahir = lahirField.getText().trim();
        String gmail = gmailField.getText().trim();

        if (id.isEmpty() || nama.isEmpty()
                || lahir.isEmpty() || gmail.isEmpty()) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Semua kolom input harus diisi!",
                    "Peringatan",
                    JOptionPane.WARNING_MESSAGE
            );
            return false;
        }

        try {
            Integer.parseInt(lahir);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Tahun lahir harus berupa angka!",
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
            return false;
        }

        return true;
    }

    // Menambahkan data ke database
    public void insertData() {
        if (!validasiInput()) {
            return;
        }

        String sql = "INSERT INTO person " +
                "(id, nama, thn_lahir, kategori, email) " +
                "VALUES (?, ?, ?, ?, ?)";

        try (PreparedStatement ps =
                     database.getConnection().prepareStatement(sql)) {

            ps.setString(1, idField.getText().trim());
            ps.setString(2, namaField.getText().trim());
            ps.setInt(3, Integer.parseInt(lahirField.getText().trim()));
            ps.setString(4, kategoriComboBox.getSelectedItem().toString());
            ps.setString(5, gmailField.getText().trim());

            ps.executeUpdate();

            JOptionPane.showMessageDialog(
                    mainPanel, "Data berhasil ditambahkan!"
            );

            refreshTable();
            clearForm();

        } catch (SQLIntegrityConstraintViolationException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "ID sudah digunakan! Gunakan ID lain.",
                    "ID Duplikat",
                    JOptionPane.ERROR_MESSAGE
            );

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal menambahkan data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Mengubah data di database
    public void updateData() {
        if (!validasiInput()) {
            return;
        }

        String sql = "UPDATE person SET nama = ?, thn_lahir = ?, " +
                "kategori = ?, email = ? WHERE id = ?";

        try (PreparedStatement ps =
                     database.getConnection().prepareStatement(sql)) {

            ps.setString(1, namaField.getText().trim());
            ps.setInt(2, Integer.parseInt(lahirField.getText().trim()));
            ps.setString(3, kategoriComboBox.getSelectedItem().toString());
            ps.setString(4, gmailField.getText().trim());
            ps.setString(5, selectedId);

            int jumlah = ps.executeUpdate();

            if (jumlah > 0) {
                JOptionPane.showMessageDialog(
                        mainPanel, "Data berhasil diubah!"
                );

                refreshTable();
                clearForm();
            } else {
                JOptionPane.showMessageDialog(
                        mainPanel, "Data tidak ditemukan!"
                );
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal mengubah data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Menghapus data dari database
    public void deleteData() {
        if (selectedId == null) {
            return;
        }

        int pilihan = JOptionPane.showConfirmDialog(
                mainPanel,
                "Apakah kamu yakin ingin menghapus data ini?",
                "Konfirmasi Hapus",
                JOptionPane.YES_NO_OPTION
        );

        if (pilihan != JOptionPane.YES_OPTION) {
            return;
        }

        String sql = "DELETE FROM person WHERE id = ?";

        try (PreparedStatement ps =
                     database.getConnection().prepareStatement(sql)) {

            ps.setString(1, selectedId);

            int jumlah = ps.executeUpdate();

            if (jumlah > 0) {
                JOptionPane.showMessageDialog(
                        mainPanel, "Data berhasil dihapus!"
                );

                refreshTable();
                clearForm();
            }

        } catch (SQLException e) {
            JOptionPane.showMessageDialog(
                    mainPanel,
                    "Gagal menghapus data: " + e.getMessage(),
                    "Error",
                    JOptionPane.ERROR_MESSAGE
            );
        }
    }

    // Memuat ulang tabel dari database
    private void refreshTable() {
        personTable.setModel(setTable());
    }

    // Membersihkan form
    public void clearForm() {
        idField.setText("");
        idField.setEditable(true);

        namaField.setText("");
        lahirField.setText("");
        gmailField.setText("");

        kategoriComboBox.setSelectedIndex(0);

        addUpdateButton.setText("Add");
        deleteButton.setVisible(false);

        selectedIndex = -1;
        selectedId = null;

        personTable.clearSelection();
    }
}
