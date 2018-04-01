package br.com.ademme.util;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;
import br.com.ademme.CPFUtils.CPFUtils;

//converter CPF
@FacesConverter("cpfconverter")
public  class cpfconverter implements Converter {
	public Object getAsObject(FacesContext context, UIComponent component, String value) throws ConverterException {

	        /*Ira converter CPF formatado para um sem pontos e traco.
	         *Ex. : 355.245.198-87 torna-se 35524519887.
	         */
		
		 if(value != null){
			 String  cpf = CPFUtils.limparCpf(value);
					
			   return cpf;
		   }else{
			   return null;
		   }
	
	    }
		@Override
		public String getAsString(FacesContext context, UIComponent component, Object value ) {
			
			
			 if(value != null && value.toString().length() == 11){
				 String  cpf = CPFUtils.formatarCpf(value.toString());
						
				   return cpf;
			   }else{
				   return value.toString();
			   }
		    
		}
			  
	}