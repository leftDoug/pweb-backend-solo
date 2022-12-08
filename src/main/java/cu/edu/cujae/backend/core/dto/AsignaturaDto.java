package cu.edu.cujae.backend.core.dto;

public class AsignaturaDto {
	
	private int idasignatura;
	private int idanno;
	private String asignatura;
	private int horas;

	public AsignaturaDto() {
		// TODO Auto-generated constructor stub
	}

	public AsignaturaDto(int idasignatura, int idanno, String asignatura, int horas) {
		super();
		this.idasignatura = idasignatura;
		this.idanno = idanno;
		this.asignatura = asignatura;
		this.horas = horas;
	}

	public int getIdasignatura() {
		return idasignatura;
	}

	public void setIdasignatura(int idasignatura) {
		this.idasignatura = idasignatura;
	}

	public int getIdanno() {
		return idanno;
	}

	public void setIdanno(int idanno) {
		this.idanno = idanno;
	}

	public String getAsignatura() {
		return asignatura;
	}

	public void setAsignatura(String asignatura) {
		this.asignatura = asignatura;
	}

	public int getHoras() {
		return horas;
	}

	public void setHoras(int horas) {
		this.horas = horas;
	}

}
