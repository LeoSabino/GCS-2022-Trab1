public class Authorization {
	private int id;
	private int dia;
	private int mes;
	private int ano;
	private String doctorsName;
	private String patientsName;
	private String exam;


	public Authorization(int id, int dia, int mes, int ano, String doctorsName, String patientsName, String exam) {
		this.id = id;
		this.dia=dia;
		this.mes=mes;
		this.ano=ano;
		this.doctorsName = doctorsName;
		this.patientsName = patientsName;
		this.exam = exam;
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDoctorsName() {
		return this.doctorsName;
	}

	public void setDoctorsName(String doctorsName) {
		this.doctorsName = doctorsName;
	}

	public String getPatientsName() {
		return this.patientsName;
	}

	public void setPatientsName(String patientsName) {
		this.patientsName = patientsName;
	}

	public String getExam() {
		return this.exam;
	}

	public void setExam(String exam) {
		this.exam = exam;
	}

	public int getDia() {
		return dia;
	}

	public void setDia(int dia) {
		this.dia = dia;
	}

	public int getMes() {
		return mes;
	}

	public void setMes(int mes) {
		this.mes = mes;
	}

	public int getAno() {
		return ano;
	}

	public void setAno(int ano) {
		this.ano = ano;
	}

}
