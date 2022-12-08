package cu.edu.cujae.backend.service;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.sql.CallableStatement;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.DatatypeConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Service;

import cu.edu.cujae.backend.core.dto.UsuarioDto;
import cu.edu.cujae.backend.core.service.UsuarioService;

@Service
public class UsuarioServiceImpl implements UsuarioService {

	@Autowired
	private JdbcTemplate jdbctemplate;

	public UsuarioServiceImpl() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void createUsuario(UsuarioDto usuario) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call usuario_create(?, ?, ?)}");

		ps.setInt(1, usuario.getIdrol());
		ps.setString(2, usuario.getUsuario());
		ps.setString(3, getMd5Hash(usuario.getContrasenna()));
		ps.executeUpdate();

	}

	@Override
	public List<UsuarioDto> listUsuarios() throws SQLException {
		// TODO Auto-generated method stub

		List<UsuarioDto> usuarios = new ArrayList<UsuarioDto>();
		ResultSet rs = jdbctemplate.getDataSource().getConnection().createStatement().executeQuery("SELECT * FROM usuario");

		while(rs.next()) {
			usuarios.add(new UsuarioDto(rs.getInt("idUsuario"), rs.getInt("idRol"), rs.getString("usuario"), rs.getString("contrasenna")));
		}

		return usuarios;
	}

	@Override
	public UsuarioDto getUsuarioById(int userId) throws SQLException {
		// TODO Auto-generated method stub

		UsuarioDto usuario = null;
		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareStatement("SELECT * FROM usuario WHERE idusuario = ?");

		ps.setInt(1, userId); ResultSet rs = ps.executeQuery();

		while(rs.next()) {
			usuario = new UsuarioDto(rs.getInt("idusuario"), rs.getInt("idrol"), rs.getString("usuario"), rs.getString("contrasenna"));
		}

		return usuario;

	}

	@Override
	public void updateUsuario(UsuarioDto usuario) throws SQLException {
		// TODO Auto-generated method stub

		PreparedStatement ps = jdbctemplate.getDataSource().getConnection().prepareCall("{call usuario_update(?, ?, ?, ?)}");

		ps.setInt(1, usuario.getIdusuario());
		ps.setInt(2, usuario.getIdrol());
		ps.setString(3, usuario.getUsuario());
		ps.setString(4, usuario.getContrasenna());
		ps.executeUpdate();

	}

	@Override
	public void deleteUsuario(int userId) throws SQLException {
		// TODO Auto-generated method stub

		CallableStatement cs = jdbctemplate.getDataSource().getConnection().prepareCall("{call usuario_delete(?)}");

		cs.setInt(1, userId);
		cs.executeUpdate();

	}

	private String getMd5Hash(String password) {
		MessageDigest md;
		String md5Hash = "";
		try {
			md = MessageDigest.getInstance("MD5");
			md.update(password.getBytes());
			byte[] digest = md.digest();
			md5Hash = DatatypeConverter
					.printHexBinary(digest).toUpperCase();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return md5Hash;
	}

}
