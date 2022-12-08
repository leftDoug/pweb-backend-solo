package cu.edu.cujae.backend.core.dto;

public class UsuarioDto {
	
	private int idusuario;
	private int idrol;
	private String usuario;
	private String contrasenna;
	
	public UsuarioDto() {
		// TODO Auto-generated constructor stub
	}
	
	public UsuarioDto(int idUsuario, int idRol, String usuario, String contrasenna) {
		super();
		this.idusuario = idUsuario;
		this.idrol = idRol;
		this.usuario = usuario;
		this.contrasenna = contrasenna;
	}

	public int getIdusuario() {
		return idusuario;
	}

	public void setIdusuario(int idUsuario) {
		this.idusuario = idUsuario;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idRol) {
		this.idrol = idRol;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getContrasenna() {
		return contrasenna;
	}

	public void setContrasenna(String contrasenna) {
		this.contrasenna = contrasenna;
	}

}
