package cu.edu.cujae.backend.core.dto;

public class EvaluacionDto {
	
	private int idevaluacion;
	private String evaluacion;

	public EvaluacionDto() {
		// TODO Auto-generated constructor stub
	}

	public EvaluacionDto(int idevaluacion, String evaluacion) {
		super();
		this.idevaluacion = idevaluacion;
		this.evaluacion = evaluacion;
	}

	public int getIdevaluacion() {
		return idevaluacion;
	}

	public void setIdevaluacion(int idevaluacion) {
		this.idevaluacion = idevaluacion;
	}

	public String getEvaluacion() {
		return evaluacion;
	}

	public void setEvaluacion(String evaluacion) {
		this.evaluacion = evaluacion;
	}

}
