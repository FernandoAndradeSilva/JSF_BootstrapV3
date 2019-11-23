package br.com.gerenciador.converters;


import br.com.gerenciador.model.Marca;
import org.omnifaces.converter.SelectItemsConverter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.FacesConverter;

@FacesConverter("marcaConverter")
public class MarcaConverter extends SelectItemsConverter {

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        Long id = (value instanceof Marca) ? ((Marca) value).getId() : null;
        return (id != null) ? String.valueOf(id) : null;
    }

}