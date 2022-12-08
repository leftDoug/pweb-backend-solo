package cu.edu.cujae.backend.core.dto;

public class AnnoDto {
	
	private int idanno;
	private int anno;

	public AnnoDto() {
		// TODO Auto-generated constructor stub
	}

	public AnnoDto(int idanno, int anno) {
		super();
		this.idanno = idanno;
		this.anno = anno;
	}

	public int getIdanno() {
		return idanno;
	}

	public void setIdanno(int idanno) {
		this.idanno = idanno;
	}

	public int getAnno() {
		return anno;
	}

	public void setAnno(int anno) {
		this.anno = anno;
	}

}
