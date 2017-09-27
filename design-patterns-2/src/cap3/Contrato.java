package cap3;

import java.util.Calendar;

public class Contrato {

	private Calendar data;
    private String cliente;
    private TipoContrato tipo;
    
    public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public String getCliente() {
		return cliente;
	}

	public void setCliente(String cliente) {
		this.cliente = cliente;
	}

	public TipoContrato getTipo() {
		return tipo;
	}

	public void setTipo(TipoContrato tipo) {
		this.tipo = tipo;
	}
    
	public Contrato(Calendar data, String cliente, TipoContrato tipo) {
        this.data = data;
        this.cliente = cliente;
        this.tipo = tipo;
    }

    public void avanca() {
        if(getTipo() == TipoContrato.NOVO) setTipo(TipoContrato.EM_ANDAMENTO);
        else if(getTipo() == TipoContrato.EM_ANDAMENTO) setTipo(TipoContrato.ACERTADO);
        else if(getTipo() == TipoContrato.ACERTADO) setTipo(TipoContrato.CONCLUIDO);
    }
    
    public Estado salvaEstado() {
        return new Estado(new Contrato(data, cliente, getTipo()));
    }

}
