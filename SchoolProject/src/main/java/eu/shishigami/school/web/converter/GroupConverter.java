package eu.shishigami.school.web.converter;

import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import eu.shishigami.school.domain.GroupEntity;
import eu.shishigami.school.service.GroupService;

@Component
@FacesConverter(value = "groupConverter")
public class GroupConverter implements Converter {
	
	@Autowired
	private GroupService groupService;

	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		return groupService.findByGroupName(value);
	}

	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value == null) {
			return "";
		}
		
		return ((GroupEntity) value).getGroupName() != null ? ((GroupEntity) value).getGroupName() : "";
	}
	
}
