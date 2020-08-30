package dao.implDB;

import java.sql.*;

public class ABM {
	
	/*
	private final String update = "UPDATE escuela SET Nombre_escuela = ?, Domicilio_escuela = ? "
			+ "WHERE Codigo_escuela = ?";
	
	public UsuarioDAOImpJDBC() {
		this.sql = new shared.conexionSQL();
	}

	@Override
	public void saveUser(Usuario u) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			
			con = sql.getConnection();
			st = con.createStatement();
			
			st.execute("INSERT INTO escuela "
					+ "VALUES ('"+u.getId()+"', '"+u.getName()+"', '"+u.getDireccion()+"')");
			
			System.out.println("Registro agregado");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				st.close();
				con.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
			
		}
		
	}

	@Override
	public Usuario getUserById(int id) {
		
		Connection con = null;
		Statement st = null;
		
		try {
			
			con = sql.getConnection();
			st = con.createStatement();
			String comando = "SELECT * FROM escuela WHERE Codigo_escuela = "+id;
			ResultSet rs = st.executeQuery(comando);
			
			Usuario u = new Usuario();
			
			if(rs.next()) {//DATA MAPPER -> Se agarran los datos de la base de datos y se asignan a un objeto usuario
				u.setId(rs.getInt("Codigo_escuela"));
				u.setName(rs.getString("Nombre_escuela"));
				u.setDireccion(rs.getString("Domicilio_escuela"));
				return u;
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public void deleteUserById(int id) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = sql.getConnection();
			st = con.createStatement();
			
			String comando = "DELETE FROM escuela WHERE Codigo_escuela = "+id;
			
			st.execute(comando);
			System.out.println("Escuela eliminada");
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
				
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
	}

	@Override
	public void updateUser(Usuario u) {
		Connection con = null;
		Statement st = null;
		
		try {
			con = sql.getConnection();
			st = con.createStatement();
			
			int registrosActualizados = st.executeUpdate("UPDATE escuela SET Nombre_escuela = '"+u.getName()+"', Domicilio_escuela = '"+u.getDireccion()+"'"
					+ "WHERE Codigo_escuela = "+u.getId());
			
			System.out.println("Registros actualizados: "+registrosActualizados);
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			}catch(SQLException e) {
				e.printStackTrace();
			}
		}
		
		
	}

	@Override
	public void updateUserPS(int id, String escuela, String direccion) {
		Connection con = null;
		PreparedStatement updateSt = null;
		
		try {
			con = sql.getConnection();
			updateSt = con.prepareStatement(update);
			
			updateSt.setString(1, escuela);
			updateSt.setString(2, direccion);
			updateSt.setInt(3, id);
			
			int registrosActualizados = updateSt.executeUpdate();
			System.out.println(registrosActualizados+" registro(s) actualizado(s)");
		}catch(SQLException e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void saveUserCallableSt(Usuario u) {
		
	}

	@Override
	public List<Usuario> getUsuarios() {
		List <Usuario> users = new ArrayList<Usuario>();
		
		Connection con = null;
		Statement st = null;
		try {
			con = sql.getConnection();
			st = con.createStatement();
			String comando = "SELECT * FROM escuela";
			ResultSet rs= st.executeQuery(comando);
			
			while(rs.next()) {
				Usuario u = new Usuario();
				u.setId(rs.getInt("Codigo_escuela"));
				u.setName(rs.getString("Nombre_escuela"));
				u.setDireccion(rs.getString("Domicilio_escuela"));
				
				users.add(u);
			}
			return users;
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				st.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}

	@Override
	public List<Usuario> getUsuarioCallableSt() {
		
		Connection con = null;
		CallableStatement callSt = null;
		try {
			con = sql.getConnection();
			String comando = "{call getEscuelas}";
			callSt = con.prepareCall(comando);
			
			boolean result = callSt.execute();
			
			if(result) {
				ResultSet rs = callSt.getResultSet();
				while(rs.next()) {
					System.out.println(rs.getInt(1));
					System.out.println(rs.getString(2));
					System.out.println(rs.getString(3));
				}
			}else {
				System.out.println("Por el momento no hay datos");
			}
			
		}catch(SQLException e) {
			e.printStackTrace();
		}finally {
			try {
				con.close();
				callSt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return null;
	}
	*/
}
