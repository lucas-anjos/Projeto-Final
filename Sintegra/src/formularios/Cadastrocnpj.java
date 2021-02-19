package formularios;

import java.awt.BorderLayout;
import java.awt.Toolkit;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class Cadastrocnpj extends JDialog {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/* Criando objetos JDBC para conexão e uso do banco */
	Connection con = null;
	PreparedStatement pst = null;
	ResultSet rs = null;

	private final JPanel contentPanel = new JPanel();
	private JTextField txtNj;
	private JTextField txtNe;
	private JTextField txtIe;
	private JTextField txtNf;
	private JTextField txtCnpj;
	private JTextField txtAe;
	private JTextField txtLo;
	private JTextField txtNu;
	private JTextField txtCo;
	private JTextField txtCp;
	private JTextField txtBa;
	private JTextField txtMu;
	private JTextField txtUf;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		try {
			Cadastrocnpj dialog = new Cadastrocnpj();
			dialog.setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
			dialog.setVisible(true);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Create the dialog.
	 */
	public Cadastrocnpj() {
		setDefaultCloseOperation(JDialog.DISPOSE_ON_CLOSE);
		setModal(true);
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(Cadastrocnpj.class.getResource("")));
		setTitle("Cadastro de Empresa");
		setBounds(100, 100, 600, 600);
		getContentPane().setLayout(new BorderLayout());
		contentPanel.setBorder(new EmptyBorder(5, 5, 5, 5));
		getContentPane().add(contentPanel, BorderLayout.CENTER);
		contentPanel.setLayout(null);

		JLabel lblNj = new JLabel("Natureza Jur\u00EDdica*");
		lblNj.setBounds(6, 143, 114, 14);
		contentPanel.add(lblNj);

		JLabel lblIe = new JLabel("IE*");
		lblIe.setBounds(319, 192, 59, 14);
		contentPanel.add(lblIe);

		JLabel lblNf = new JLabel("Nome Fantasia*");
		lblNf.setBounds(6, 192, 93, 14);
		contentPanel.add(lblNf);

		JLabel lblAe = new JLabel("Atividade Econ\u00F4mica*");
		lblAe.setBounds(6, 244, 129, 14);
		contentPanel.add(lblAe);

		JLabel lblCnpj = new JLabel("CNPJ*");
		lblCnpj.setBounds(135, 80, 48, 14);
		contentPanel.add(lblCnpj);

		JLabel lblNe = new JLabel("Nome Empresarial*");
		lblNe.setBounds(264, 143, 114, 14);
		contentPanel.add(lblNe);

		txtNj = new JTextField();
		txtNj.setBounds(125, 140, 129, 20);
		contentPanel.add(txtNj);
		txtNj.setColumns(10);

		txtNe = new JTextField();
		txtNe.setBounds(388, 140, 172, 20);
		contentPanel.add(txtNe);
		txtNe.setColumns(10);

		txtIe = new JTextField();
		txtIe.setBounds(388, 189, 172, 20);
		contentPanel.add(txtIe);
		txtIe.setColumns(10);

		txtNf = new JTextField();
		txtNf.setBounds(125, 189, 129, 20);
		contentPanel.add(txtNf);
		txtNf.setColumns(10);

		txtCnpj = new JTextField();
		txtCnpj.setBounds(214, 77, 195, 20);
		contentPanel.add(txtCnpj);
		txtCnpj.setColumns(10);

		txtAe = new JTextField();
		txtAe.setBounds(148, 241, 195, 20);
		contentPanel.add(txtAe);
		txtAe.setColumns(10);

		JButton btnCreatecadastro = new JButton("");
		btnCreatecadastro.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				adicionar();
			}
		});
		btnCreatecadastro.setToolTipText("Cadastrar Empresa");
		btnCreatecadastro.setIcon(new ImageIcon(Cadastrocnpj.class.getResource("/icones/adicionar.png")));
		btnCreatecadastro.setBounds(297, 481, 64, 64);
		contentPanel.add(btnCreatecadastro);

		JButton btnNewButton_1 = new JButton("");
		btnNewButton_1.setIcon(new ImageIcon(Cadastrocnpj.class.getResource("/icones/editar.png")));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				alterar();
			}
		});
		btnNewButton_1.setToolTipText("Editar Cadastro");
		btnNewButton_1.setBounds(400, 481, 64, 64);
		contentPanel.add(btnNewButton_1);

		JLabel lblId = new JLabel("Endere\u00E7o");
		lblId.setBounds(126, 309, 253, 14);
		contentPanel.add(lblId);

		txtLo = new JTextField();
		txtLo.setBounds(102, 352, 138, 20);
		contentPanel.add(txtLo);
		txtLo.setColumns(10);

		JLabel lblNu = new JLabel("N\u00FAmero*");
		lblNu.setBounds(263, 355, 58, 14);
		contentPanel.add(lblNu);

		txtNu = new JTextField();
		txtNu.setBounds(359, 352, 154, 20);
		contentPanel.add(txtNu);
		txtNu.setColumns(10);

		JLabel lblCamposObrigatrios = new JLabel("Campos Obrigat\u00F3rios(*)");
		lblCamposObrigatrios.setForeground(Color.RED);
		lblCamposObrigatrios.setBounds(264, 11, 138, 14);
		contentPanel.add(lblCamposObrigatrios);

		JButton btnNewButton_3 = new JButton("");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				pesquisar();
			}
		});
		btnNewButton_3.setIcon(new ImageIcon(Cadastrocnpj.class.getResource("/icones/procurar.png")));
		btnNewButton_3.setToolTipText("Pesquisar CNPJ");
		btnNewButton_3.setBounds(432, 65, 32, 32);
		contentPanel.add(btnNewButton_3);
		
		JLabel lblLo = new JLabel("Logradouro*");
		lblLo.setBounds(10, 355, 77, 14);
		contentPanel.add(lblLo);
		
		JLabel lblCo = new JLabel("Complemento");
		lblCo.setBounds(10, 392, 89, 14);
		contentPanel.add(lblCo);
		
		txtCo = new JTextField();
		txtCo.setBounds(102, 389, 138, 20);
		contentPanel.add(txtCo);
		txtCo.setColumns(10);
		
		JLabel lblCp = new JLabel("Cep*");
		lblCp.setBounds(264, 392, 46, 14);
		contentPanel.add(lblCp);
		
		txtCp = new JTextField();
		txtCp.setBounds(359, 389, 154, 20);
		contentPanel.add(txtCp);
		txtCp.setColumns(10);
		
		JLabel lblBa = new JLabel("Bairro*");
		lblBa.setBounds(10, 421, 46, 14);
		contentPanel.add(lblBa);
		
		txtBa = new JTextField();
		txtBa.setBounds(102, 418, 138, 20);
		contentPanel.add(txtBa);
		txtBa.setColumns(10);
		
		JLabel lblMu = new JLabel("Munic\u00EDpio*");
		lblMu.setBounds(264, 421, 79, 14);
		contentPanel.add(lblMu);
		
		txtMu = new JTextField();
		txtMu.setBounds(359, 418, 154, 20);
		contentPanel.add(txtMu);
		txtMu.setColumns(10);
		
		JLabel lblUf = new JLabel("Uf*");
		lblUf.setBounds(10, 456, 46, 14);
		contentPanel.add(lblUf);
		
		txtUf = new JTextField();
		txtUf.setBounds(102, 453, 138, 20);
		contentPanel.add(txtUf);
		txtUf.setColumns(10);
		
		JButton btnCreatemulta_1 = new JButton("");
		btnCreatemulta_1.setIcon(new ImageIcon(Cadastrocnpj.class.getResource("/icones/excluir.png")));
		btnCreatemulta_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				apagar();
			}
		});
		btnCreatemulta_1.setToolTipText("Excluir Cadastro");
		btnCreatemulta_1.setBounds(496, 481, 64, 64);
		contentPanel.add(btnCreatemulta_1);
	}



	
  /** inicio do adicionar**/
	private void adicionar() {
		if (txtCnpj.getText().isEmpty() || txtNj.getText().isEmpty() || txtIe.getText().isEmpty()
				|| txtAe.getText().isEmpty() || txtNf.getText().isEmpty() ||txtNe.getText().isEmpty() || txtLo.getText().isEmpty()
				|| txtNu.getText().isEmpty() ||txtCp.getText().isEmpty() || txtBa.getText().isEmpty()
				|| txtMu.getText().isEmpty() || txtUf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			String adicionar = "insert into dados(cnpj,ie,nomeem,natureza,fantasia,ateconomica,logradouro,numero,complemento,cep,bairro,municipio,uf) values(?,?,?,?,?,?,?,?,?,?,?,?,?)";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(adicionar);
				
				pst.setString(4, txtNj.getText());
				pst.setString(3, txtNe.getText());
				pst.setString(2, txtIe.getText());
				pst.setString(5, txtNf.getText());
				pst.setString(1, txtCnpj.getText());
				pst.setString(6, txtAe.getText());
				pst.setString(7, txtLo.getText());
				pst.setString(8, txtNu.getText());
				pst.setString(9, txtCo.getText());
				pst.setString(10, txtCp.getText());
				pst.setString(11, txtBa.getText());
				pst.setString(12, txtMu.getText());
				pst.setString(13, txtUf.getText());
				
				int adicionado = pst.executeUpdate();
				if (adicionado > 0) {
					JOptionPane.showMessageDialog(null, "Cadastro concluído");
				}
				limpar();

				con.close();

			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	private void limpar() {
		txtIe.setText(null);
		txtNj.setText(null);
		txtNf.setText(null);
		txtAe.setText(null);
		txtNe.setText(null);
		txtCnpj.setText(null);
		txtUf.setText(null);
		txtMu.setText(null);
		txtBa.setText(null);
		txtCp.setText(null);
		txtCo.setText(null);
		txtNu.setText(null);
		txtLo.setText(null);
	}
	
	/** inicio do pesquisar **/

	private void pesquisar() {
		String create1 = "select * from dados where cnpj = ?";
		try {
		
			con = DAO.conectar();
			
			pst = con.prepareStatement(create1);
			
		
			pst.setString(1, txtCnpj.getText());
			rs = pst.executeQuery();
			if (rs.next()) {
				txtCnpj.setText(rs.getString(1));
				txtIe.setText(rs.getString(2));
				txtNe.setText(rs.getString(3));
				txtNj.setText(rs.getString(4));
				txtNf.setText(rs.getString(5));
				txtAe.setText(rs.getString(6));
				txtLo.setText(rs.getString(7));
				txtNu.setText(rs.getString(8));
				txtCo.setText(rs.getString(9));
				txtCp.setText(rs.getString(10));
				txtBa.setText(rs.getString(11));
				txtMu.setText(rs.getString(12));
				txtUf.setText(rs.getString(13));
				
				
			} else {
				
				JOptionPane.showMessageDialog(null, "CNPJ não cadastrado!");
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	/** inicio do alterar **/

	private void alterar() {
		if (txtCnpj.getText().isEmpty() || txtIe.getText().isEmpty() || txtNe.getText().isEmpty()
				|| txtNj.getText().isEmpty() || txtNf.getText().isEmpty() ||txtAe.getText().isEmpty() || txtLo.getText().isEmpty()
				|| txtNu.getText().isEmpty() || txtCp.getText().isEmpty() || txtBa.getText().isEmpty()
				|| txtMu.getText().isEmpty() || txtUf.getText().isEmpty()) {
			JOptionPane.showMessageDialog(null, "Preencha os campos obrigatórios");
		} else {
			String update = "update dados set ie=?,nomeem=?,natureza=?,fantasia=?,ateconomica=?,logradouro=?,numero=?,complemento=?,cep=?,bairro=?,municipio=?,uf=? where cnpj=?";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(update);
				pst.setString(13, txtCnpj.getText());
				pst.setString(1, txtIe.getText());
				pst.setString(2, txtNe.getText());
				pst.setString(3, txtNj.getText());
				pst.setString(4, txtNf.getText());
				pst.setString(5, txtAe.getText());
				pst.setString(6, txtLo.getText());
				pst.setString(7, txtNu.getText());
				pst.setString(8, txtCo.getText());
				pst.setString(9, txtCp.getText());
				pst.setString(10, txtBa.getText());
				pst.setString(11, txtMu.getText());
				pst.setString(12, txtUf.getText());
				

				
				int adicionado = pst.executeUpdate();
				if (adicionado == 1) {
					JOptionPane.showMessageDialog(null, "Cadastro alterado com sucesso!");
				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível alterar o cadastro");
				}
				con.close();
				
				limpar();
			} catch (Exception e) {
				System.out.println(e);
			}
		}
	}

	
	/** inicio do apagar  **/

	private void apagar() {
		int confirma = JOptionPane.showConfirmDialog(null, "Tem certeza que deseja remover este cadastro?", "Atenção",
				JOptionPane.YES_NO_OPTION);
		if (confirma == JOptionPane.YES_OPTION) {
			String remover = "delete from dados where cnpj = ?";
			try {
				con = DAO.conectar();
				pst = con.prepareStatement(remover);
				pst.setString(1, txtCnpj.getText());
				int removido = pst.executeUpdate();
				if (removido == 1) {
					limpar();
					JOptionPane.showMessageDialog(null, "Cadastro Removido com sucesso");

				} else {
					JOptionPane.showMessageDialog(null, "Não foi possível remover este cadastro");
				}
				con.close();
			} catch (Exception e) {
				JOptionPane.showMessageDialog(null, e);

			}
		}
	}
	
}
