package cu.edu.cujae.backend.core.dto;

public class SexoDto {
	
	private int idsexo;
	private String sexo;

	public SexoDto() {
		// TODO Auto-generated constructor stub
	}

	public SexoDto(int idsexo, String sexo) {
		super();
		this.idsexo = idsexo;
		this.sexo = sexo;
	}

	public int getIdsexo() {
		return idsexo;
	}

	public void setIdsexo(int idsexo) {
		this.idsexo = idsexo;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

}
