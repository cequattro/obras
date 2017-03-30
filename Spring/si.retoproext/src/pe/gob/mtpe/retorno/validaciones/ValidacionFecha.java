package pe.gob.mtpe.retorno.validaciones;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.validator.FacesValidator;
import javax.faces.validator.Validator;
import javax.faces.validator.ValidatorException;

@FacesValidator(value="validacionFecha")
public class ValidacionFecha implements Validator{

	@Override
	public void validate(FacesContext fc, UIComponent component, Object value)
			throws ValidatorException {
		String[] fecha=value.toString().split("/");
		Integer mes=0;
		Integer ano=0;
		mes=Integer.parseInt(fecha[0]);
		ano=Integer.parseInt(fecha[1]);
		if(mes<1 || mes>12){
			FacesMessage mensaje=new FacesMessage();
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
		
		if(ano<1900 || ano>2200){
			FacesMessage mensaje=new FacesMessage();
			mensaje.setSeverity(FacesMessage.SEVERITY_ERROR);
			throw new ValidatorException(mensaje);
		}
		
	}

}
