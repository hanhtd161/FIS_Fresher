package fis.topic01.pratice01;

import java.util.ArrayList;
import java.util.List;

public class Form {
	private List<Component> components = new ArrayList<Component>();
	public void addComponent(Component component) {
		this.components.add(component);
	}
	
	public Form() {
	}
	
	public boolean validateForm() {
		for(Component component : components) {
			if(!component.validate()) {
				return false;
			}
		}
		return true;
	}
}
