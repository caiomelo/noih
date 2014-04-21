package br.ufc.apsoo.converters;

import java.util.ResourceBundle;

@Convert(int.class)
@ApplicationScoped
public class PrimitiveIntConverter implements Converter<Integer> {

    public Integer convert(String value, Class<? extends Integer> type, ResourceBundle bundle) {
      	if (value == null || value.isEmpty()) {
            return 0;
        }
    	
        try {
            return Integer.parseInt(value);
        } catch (NumberFormatException e) {
        	return 0;
        }
    }

}