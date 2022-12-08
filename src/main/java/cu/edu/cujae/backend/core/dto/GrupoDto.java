package cu.edu.cujae.backend.core.dto;

public class GrupoDto {
	
	private int idgrupo;
	private int idanno;
	private int grupo;

	public GrupoDto() {
		// TODO Auto-generated constructor stub
	}

	public GrupoDto(int idgrupo, int idanno, int grupo) {
		super();
		this.idgrupo = idgrupo;
		this.idanno = idanno;
		this.grupo = grupo;
	}

	public int getIdgrupo() {
		return idgrupo;
	}

	public void setIdgrupo(int idgrupo) {
		this.idgrupo = idgrupo;
	}

	public int getIdanno() {
		return idanno;
	}

	public void setIdanno(int idanno) {
		this.idanno = idanno;
	}

	public int getGrupo() {
		return grupo;
	}

	public void setGrupo(int grupo) {
		this.grupo = grupo;
	}

}
