package starter.apirest.model;

public enum Status {
	Aberto ("Aberto"), 
	Aprovado ("Aprovado"),
	Cancelado ("Cancelado");
	
	private String status;

	private Status(String status) {
		this.status = status;
	}

	public String getStatus() {
		return status;
	}
	
	//Metodo para aceitar tanto o nome quanto o valor do Enum
//	@JsonCreator
//	public static Status getStatusFromCode(String value) {
//	 
//	    for (Status st : Status.values()) {
//	 
//	        if (st.getStatus().equals(value)) {
//	 
//	            return st;
//	        }
//	    }
//	 
//	    return null;
//	}
	
	
}
