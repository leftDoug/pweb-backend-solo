package cu.edu.cujae.backend.core.dto;

public class RolDto {
	
	private int idrol;
	private String rol;

	public RolDto() {
		// TODO Auto-generated constructor stub
	}

	public RolDto(int idrol, String rol) {
		super();
		this.idrol = idrol;
		this.rol = rol;
	}

	public int getIdrol() {
		return idrol;
	}

	public void setIdrol(int idrol) {
		this.idrol = idrol;
	}

	public String getRol() {
		return rol;
	}

	public void setRol(String rol) {
		this.rol = rol;
	}

}
