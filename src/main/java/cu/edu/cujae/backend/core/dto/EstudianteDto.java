package cu.edu.cujae.backend.core.dto;

public class EstudianteDto {
	
	private int idestudiante;
	private int numero;
	private String nombre;
	private String apellido;
	private int idgrupo;
	private int idsexo;

	public EstudianteDto() {
		// TODO Auto-generated constructor stub
	}

	public EstudianteDto(int idestudiante, int numero, String nombre, String apellido, int idgrupo, int idsexo) {
		super();
		this.idestudiante = idestudiante;
		this.numero = numero;
		this.nombre = nombre;
		this.apellido = apellido;
		this.idgrupo = idgrupo;
		this.idsexo = idsexo;
	}

	public int getIdestudiante() {
		return idestudiante;
	}

	public void setIdestudiante(int idestudiante) {
		this.idestudiante = idestudiante;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public int getIdsexo() {
		return idsexo;
	}

	public void setIdsexo(int idsexo) {
		this.idsexo = idsexo;
	}

}
