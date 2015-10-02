package org.frangoro.acu.editor;

import java.beans.PropertyEditorSupport;

import org.frangoro.acu.model.CategoryEntity;

public class CategoryEditor extends PropertyEditorSupport {

	@Override
	public void setAsText(String id) {
		CategoryEntity d;
		switch (Integer.parseInt(id)) {
		case 1:
			d = new CategoryEntity(1, "BMX");
			break;
		case 2:
			d = new CategoryEntity(2, "Mountain Bike");
			break;
		case 3:
			d = new CategoryEntity(3, "Road");
			break;
		case 4:
			d = new CategoryEntity(4, "Track");
			break;
		default:
			d = null;
		}
		this.setValue(d);
	}

}
